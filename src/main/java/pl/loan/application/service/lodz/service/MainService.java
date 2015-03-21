package pl.loan.application.service.lodz.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.loan.application.service.lodz.model.LoanApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.loan.application.service.lodz.Consumer;

@Service
public class MainService implements Consumer{

    final static Logger log = LoggerFactory.getLogger(MainService.class);
    
    private Consumer dbService;
    private Consumer fraudService;
    private Consumer reportingService;

    @Autowired public MainService(Consumer dbService, Consumer fraudService, Consumer reportingService) {
        this.dbService = dbService;
        this.fraudService= fraudService;
        this.reportingService = reportingService;
    }


    @Override
    public void consume(LoanApplication loanApplication) {
        log.debug("Consuming LoanApplication:: " + loanApplication);

        dbService.consume(loanApplication);
        fraudService.consume(loanApplication);
        reportingService.consume(loanApplication);
    }
}
