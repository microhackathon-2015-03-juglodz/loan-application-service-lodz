package com.ofg.twitter.place.extractor

import com.ofg.twitter.place.service.LoanApplication

interface ApplicationLoanWorker {
    void collectAndPropagate(LoanApplication message)
}