package com.ofg.twitter.place.extractor

import com.ofg.twitter.place.model.LoanApplication
import com.ofg.twitter.place.model.Tweet
import groovy.transform.TypeChecked
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired

@TypeChecked
@Slf4j
class ApplicationLoanPropagationWorker implements ApplicationLoanWorker {


    @Override
    void collectAndPropagate(LoanApplication application) {
        log.debug("Sent json [$application] to collerator")
    }
}
