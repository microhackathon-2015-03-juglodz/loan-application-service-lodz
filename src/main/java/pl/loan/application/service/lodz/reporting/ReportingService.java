package pl.loan.application.service.lodz.reporting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.loan.application.service.lodz.model.LoanApplication;
import org.springframework.stereotype.Service;
import pl.loan.application.service.lodz.Consumer;

@Service
public class ReportingService implements Consumer {
    final static Logger log = LoggerFactory.getLogger(ReportingService.class);

    @Override
    public void consume(LoanApplication loanApplication) {
        log.debug("Saving LoaanApplication to db: " + loanApplication);
    }

}
