package com.ofg.twitter.place.extractor

import com.ofg.twitter.place.service.LoanApplication
import groovy.text.SimpleTemplateEngine
import groovy.transform.PackageScope
import groovy.transform.TypeChecked

@TypeChecked
@PackageScope
class LoanJsonBuilder {

    String buildLoanJson(long pairId, LoanApplication loanApplication) {
        return new SimpleTemplateEngine()
                .createTemplate(JSON_RESPONSE_TEMPLATE)
                .make([pairId: pairId, loan: loanApplication])
                .toString()
    }

    private static final String JSON_RESPONSE_TEMPLATE = '''
                {
                    "pair_id" : $pairId
                    "firstName" : ${loan.firsName},
                    "lastName" : ${loan.lastName},
                    "job" : ${loan.job},
                    "age" : ${loan.age},
                    "amount" : ${loan.amount},
                    "loanId" : ${loan.loanId}
                }
                '''

}
