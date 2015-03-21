package com.ofg.twitter.place.extractor

import com.ofg.twitter.place.service.LoanApplication
import groovy.transform.TypeChecked
import groovy.util.logging.Slf4j

@TypeChecked
@Slf4j
class ApplicationLoanPropagationWorker implements ApplicationLoanWorker {


    @Override
    void collectAndPropagate(LoanApplication application) {
        log.debug("Sent json [$application] to collerator")
    }
}
