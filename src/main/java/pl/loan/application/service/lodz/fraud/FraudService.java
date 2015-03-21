package pl.loan.application.service.lodz.fraud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.loan.application.service.lodz.model.LoanApplication;
import org.springframework.stereotype.Service;
import pl.loan.application.service.lodz.Consumer;

@Service
public class FraudService implements Consumer {

    final static Logger log = LoggerFactory.getLogger(FraudService.class);

    @Override
    public void consume(LoanApplication loanApplication) {
        log.debug("Sending LoaanApplication to FraudService: " + loanApplication);
    }
}
