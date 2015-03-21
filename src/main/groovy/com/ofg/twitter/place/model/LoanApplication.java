package com.ofg.twitter.place.model;

import java.math.BigDecimal;

public class LoanApplication {
    private BigDecimal amount;
    private String loanId;
    private String firstName;
    private String lastName;
    private String job;
    private Integer age;

    public LoanApplication() {
    }

    public LoanApplication(BigDecimal amount, String loanId, String firstName, String lastName, String job, Integer age) {
        this.amount = amount;
        this.loanId = loanId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.job = job;
        this.age = age;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
