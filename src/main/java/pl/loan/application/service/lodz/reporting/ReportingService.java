package pl.loan.application.service.lodz.reporting;

import org.springframework.stereotype.Service;
import pl.loan.application.service.lodz.Consumer;

import java.math.BigDecimal;

@Service
public class ReportingService implements Consumer {

    @Override
    public void consume(BigDecimal amount, String loanId) {

    }
}
