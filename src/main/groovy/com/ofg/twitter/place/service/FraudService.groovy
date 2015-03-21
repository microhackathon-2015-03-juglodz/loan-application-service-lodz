package com.ofg.twitter.place.service

import com.ofg.twitter.place.extractor.FraudClient
import com.ofg.twitter.place.extractor.LoanJsonBuilder;
import groovy.transform.TypeChecked;
import groovy.util.logging.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@TypeChecked
@Slf4j
public class FraudService implements Consumer {

    @Autowired private FraudClient client

    @Override
    public void consume(LoanApplication loanApplication) {
        log.debug("Sending LoaanApplication to FraudService: " + loanApplication);
        final String loanApplicationJson = new LoanJsonBuilder().buildLoanJson(loanApplication)
        client.newApplication(loanApplicationJson)
    }
}
