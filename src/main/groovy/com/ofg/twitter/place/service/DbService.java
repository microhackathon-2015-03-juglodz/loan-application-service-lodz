package com.ofg.twitter.place.service;

import groovy.transform.TypeChecked;
import groovy.util.logging.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@TypeChecked
@Slf4j
public class DbService implements Consumer {

    final static Logger log = LoggerFactory.getLogger(DbService.class);

    @Override
    public void consume(LoanApplication loanApplication) {
        log.debug("Saving LoaanApplication to db: " + loanApplication);

        System.out.println("Saving LoanApplication to db:: " + loanApplication);
    }
}
