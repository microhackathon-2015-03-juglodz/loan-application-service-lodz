package com.ofg.twitter.place.extractor

import com.ofg.infrastructure.web.resttemplate.fluent.ServiceRestClient
import com.ofg.twitter.config.Collaborators
import groovy.transform.CompileStatic

@CompileStatic
class FraudClient {

    private final ServiceRestClient serviceRestClient

    FraudClient(ServiceRestClient serviceRestClient) {
        this.serviceRestClient = serviceRestClient
    }

    void newApplication(long pairId, String loanApplication) {
        serviceRestClient.forService(Collaborators.FRAUD_DEPENDENCY_NAME)
                .put()
                .onUrlFromTemplate("/{pairId}").withVariables(pairId)
                .body(loanApplication)
                .anObject()
                .ofType(String)
    }

}
