package com.ofg.twitter.place

import com.ofg.twitter.place.service.LoanApplication
import com.wordnik.swagger.annotations.Api
import com.wordnik.swagger.annotations.ApiOperation
import groovy.transform.TypeChecked
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.ofg.twitter.place.service.MainService

import javax.validation.constraints.NotNull
import java.util.concurrent.Callable

import static org.springframework.web.bind.annotation.RequestMethod.POST

@Slf4j
@RestController
@RequestMapping('/api')
@TypeChecked
@Api(value = "loanApplication", description = "")
class LoanApplicationServiceController {


    private final MainService mainService;

    @Autowired LoanApplicationServiceController(MainService mainService) {
        this.mainService = mainService
    }
    
    @RequestMapping(
            value = '{pairId}',
            method = POST
    )
    @ApiOperation(value = "Stores loan application, notifies reportingService and FraudDetectionService",
            notes = "Stores loan applications details received from the UI. Notifies ReportingService about new loan applications. Updates FraudDetectionService")
    Callable<Void> getPlacesFromTweets(@RequestBody @NotNull LoanApplication loanApplication) {

        log.debug("Consumming REST: " + loanApplication);
        return {
            mainService.consume(loanApplication);
        }
    }

}
