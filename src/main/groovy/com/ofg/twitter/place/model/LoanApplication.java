package com.ofg.twitter.place.model;

import java.math.BigDecimal;

public class LoanApplication {
    private BigDecimal amount;
    private String loanId;

    public LoanApplication(BigDecimal amount, String loanId) {
        this.amount = amount;
        this.loanId = loanId;
    }

    public LoanApplication() {
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    @Override
    public String toString() {
        return "LoanApplication{" +
                "amount=" + amount +
                ", loanId='" + loanId + '\'' +
                '}';
    }
}
