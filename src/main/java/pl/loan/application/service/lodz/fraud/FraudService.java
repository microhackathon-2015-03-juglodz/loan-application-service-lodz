package pl.loan.application.service.lodz.fraud;

import org.springframework.stereotype.Service;
import pl.loan.application.service.lodz.Consumer;

import java.math.BigDecimal;

@Service
public class FraudService implements Consumer {

    @Override
    public void consume(BigDecimal amount, String loanId) {

    }
}
