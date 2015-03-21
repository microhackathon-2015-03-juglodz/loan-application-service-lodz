package com.ofg.twitter.place.extractor

import com.ofg.infrastructure.web.resttemplate.fluent.ServiceRestClient
import com.ofg.twitter.config.Collaborators
import groovy.transform.CompileStatic

@CompileStatic
class ReportingClient {

    private final ServiceRestClient serviceRestClient

    ReportingClient(ServiceRestClient serviceRestClient) {
        this.serviceRestClient = serviceRestClient
    }

    void newClient(String loanApplication) {
        serviceRestClient.forService(Collaborators.REPORTING_DEPENDENCY_NAME)
                .post()
                .onUrlFromTemplate("/").withVariables()
                .body(loanApplication)
                .anObject()
                .ofType(String)
    }

}
