package com.ofg.twitter.place

import com.ofg.twitter.place.extractor.ApplicationLoanWorker
import com.ofg.twitter.place.extractor.PropagationWorker
import com.ofg.twitter.place.model.LoanApplication
import com.ofg.twitter.place.model.Tweet
import com.wordnik.swagger.annotations.Api
import com.wordnik.swagger.annotations.ApiOperation
import groovy.transform.TypeChecked
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import javax.validation.constraints.NotNull
import java.util.concurrent.Callable

import static com.ofg.twitter.config.Versions.TWITTER_PLACES_ANALYZER_JSON_VERSION_1
import static org.springframework.web.bind.annotation.RequestMethod.PUT
import static org.springframework.web.bind.annotation.RequestMethod.POST

@Slf4j
@RestController
@RequestMapping('/api')
@TypeChecked
@Api(value = "loanApplication", description = "")
class LoanApplicationServiceController {


    private final ApplicationLoanWorker applicationLoanWorker;

    @Autowired LoanApplicationServiceController(ApplicationLoanWorker applicationLoanWorker) {
        this.applicationLoanWorker = applicationLoanWorker
    }
    
    @RequestMapping(
            value = '{pairId}',
            method = POST,
            consumes = TWITTER_PLACES_ANALYZER_JSON_VERSION_1,
            produces = TWITTER_PLACES_ANALYZER_JSON_VERSION_1)
    @ApiOperation(value = "Stores loan application, notifies reportingService and FraudDetectionService",
            notes = "Stores loan applications details received from the UI. Notifies ReportingService about new loan applications. Updates FraudDetectionService")
    Callable<Void> getPlacesFromTweets(@RequestBody @NotNull LoanApplication loanApplication) {
        return {
            applicationLoanWorker.collectAndPropagate(loanApplication)
        }
    }

}
