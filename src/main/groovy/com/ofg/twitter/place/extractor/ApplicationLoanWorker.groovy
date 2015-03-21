package com.ofg.twitter.place.extractor

import pl.loan.application.service.lodz.model.LoanApplication

interface ApplicationLoanWorker {
    void collectAndPropagate(LoanApplication message)
}