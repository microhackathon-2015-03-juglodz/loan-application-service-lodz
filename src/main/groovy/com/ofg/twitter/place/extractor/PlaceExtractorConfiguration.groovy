package com.ofg.twitter.place.extractor

import com.codahale.metrics.Meter
import com.codahale.metrics.MetricRegistry
import com.ofg.infrastructure.web.resttemplate.fluent.ServiceRestClient
import com.ofg.twitter.place.extractor.metrics.ExtractorMetricsConfiguration
import com.ofg.twitter.place.extractor.metrics.MatchProbabilityMetrics
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import pl.loan.application.service.lodz.db.DbService
import pl.loan.application.service.lodz.fraud.FraudService
import pl.loan.application.service.lodz.reporting.ReportingService
import pl.loan.application.service.lodz.service.MainService

@Configuration
@Import(ExtractorMetricsConfiguration)
class PlaceExtractorConfiguration {

    @Bean
    CityFinder cityFinder(ServiceRestClient serviceRestClient, @Value('${city.finding.service.url:http://api.openweathermap.org/data/2.5/weather}') String cityFindingServiceUrl) {
        return new CityFinder(new WeatherClient(serviceRestClient, cityFindingServiceUrl))
    }
    
    @Bean
    PlacesExtractor placesExtractor(CityFinder cityFinder, MatchProbabilityMetrics matchProbabilityMetrics, MetricRegistry metricRegistry) {
        Meter analyzedTweetsMeter = metricRegistry.meter('twitter.places.analyzed.tweets')
        List<PlaceExtractor> placeExtractors = [ new PlaceSectionExtractor(matchProbabilityMetrics),
                                                 new CoordinatesPlaceExtractor(cityFinder, matchProbabilityMetrics) ]
        return new PlacesExtractor(placeExtractors, analyzedTweetsMeter)
    }
    
    @Bean
    PlacesJsonBuilder placesJsonBuilder() {
        return new PlacesJsonBuilder()
    }
    
    @Bean
    PropagationWorker propagationWorker(PlacesExtractor placesExtractor,
                                        PlacesJsonBuilder placesJsonBuilder,
                                        ColleratorClient colleratorClient) {
        return new PlacePropagatingWorker(placesExtractor, placesJsonBuilder, colleratorClient)
    }
    
    @Bean
    DbService dbService() {
        return new DbService();
    }

    @Bean
    FraudService fraudService() {
        return new FraudService();
    }

    @Bean
    ReportingService reportingService() {
        return new ReportingService();
    }

    @Bean
    MainService mainService(DbService dbService, FraudService fraudService, ReportingService reportingService) {
        return new MainService(dbService, fraudService, reportingService);
    }


    @Bean
    ColleratorClient colleratorClient(ServiceRestClient serviceRestClient) {
        return new ColleratorClient(serviceRestClient)
    }

}
