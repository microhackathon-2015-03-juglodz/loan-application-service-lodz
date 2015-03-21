package com.ofg.twitter.place.service;

import groovy.transform.TypeChecked;
import groovy.util.logging.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@TypeChecked
@Slf4j
public class MainService implements Consumer {

    @Autowired
    private DbService dbService;
    @Autowired
    private FraudService fraudService;
    @Autowired
    private ReportingService reportingService;


    @Override
    public void consume(LoanApplication loanApplication) {
        log.debug("Consuming LoanApplication:: " + loanApplication);
        dbService.consume(loanApplication);
        fraudService.consume(loanApplication);
        reportingService.consume(loanApplication);
    }
}
