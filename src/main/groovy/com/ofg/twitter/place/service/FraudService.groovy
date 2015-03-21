package com.ofg.twitter.place.service;

import groovy.transform.TypeChecked;
import groovy.util.logging.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@TypeChecked
@Slf4j
public class FraudService implements Consumer {

    @Override
    public void consume(LoanApplication loanApplication) {
        log.debug("Sending LoaanApplication to FraudService: " + loanApplication);
    }
}
