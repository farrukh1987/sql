package com.dc.sql.service;

import com.dc.sql.database.TaxiOlu4a;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class TaxiOlu4aService {

    @Autowired
    WebClient webClient;

    public Flux<TaxiOlu4a> findAll()
    {
        return webClient.get()
                .uri("/get_drivers_info")
                .retrieve()
                .bodyToFlux(TaxiOlu4a.class)
                .timeout(Duration.ofMillis(10_000));
    }
}
