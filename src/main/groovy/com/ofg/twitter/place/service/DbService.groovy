package com.ofg.twitter.place.service;

import groovy.transform.TypeChecked;
import groovy.util.logging.Slf4j;
import org.springframework.stereotype.Component;

@Component
@TypeChecked
@Slf4j
public class DbService implements Consumer {

    @Override
    public void consume(LoanApplication loanApplication) {
        log.debug("Saving LoaanApplication to db: " + loanApplication);

        System.out.println("Saving LoanApplication to db:: " + loanApplication);
    }
}
