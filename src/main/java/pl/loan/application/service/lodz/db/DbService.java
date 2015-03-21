package pl.loan.application.service.lodz.db;

import groovy.transform.TypeChecked;
import groovy.util.logging.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.loan.application.service.lodz.model.LoanApplication;
import org.springframework.stereotype.Service;
import pl.loan.application.service.lodz.Consumer;

@Service
public class DbService implements Consumer {

    final static Logger log = LoggerFactory.getLogger(DbService.class);
    
    @Override
    public void consume(LoanApplication loanApplication) {
        log.debug("Saving LoaanApplication to db: " + loanApplication);

        System.out.println("Saving LoanApplication to db:: " + loanApplication);
    }
}
