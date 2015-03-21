package com.ofg.twitter.place.extractor

import com.ofg.twitter.place.model.LoanApplication

interface ApplicationLoanWorker {
    void collectAndPropagate(LoanApplication message)
}