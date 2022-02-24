package com.dc.sql.service;

import com.dc.sql.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import reactor.core.publisher.Flux;

import javax.net.ssl.SSLException;

import java.time.Duration;

public class TaxiOlu4aService {

    @Value("${proxy.url}")
    private String proxyUrl;
    @Value("${proxy.buffer-size:10000000}")
    private int proxyBufferSize;

    @Autowired
    Client webClient;

    public Flux<String> findAll() throws SSLException {
        return webClient.createWebClient(proxyUrl, proxyBufferSize)
                .post()
                //.uri(PathINQUIRY_EXCHANGERATE)  //     /uags/api/v1/exchange
                .contentType(MediaType.APPLICATION_JSON)
                //.body(BodyInserters.fromValue(request))  // msgID
                //.header("UPI-JWS",getupijws.getContent() )
                .retrieve()
                .bodyToFlux(String.class)
                .timeout(Duration.ofMillis(60_000));
    }
}
