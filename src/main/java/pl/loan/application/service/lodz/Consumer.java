package pl.loan.application.service.lodz;

import java.math.BigDecimal;

public interface Consumer {
    void consume(BigDecimal amount, String loanId);
}
