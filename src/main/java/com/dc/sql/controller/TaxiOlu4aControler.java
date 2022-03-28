package com.dc.sql.controller;


import com.dc.sql.database.TaxiOlu4a;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import com.dc.sql.client.Client;

import javax.net.ssl.SSLException;
import java.time.Duration;

@RestController
public class TaxiOlu4aControler {

    @Value("${proxy.url}")
    private String proxyUrl;
    @Value("${proxy.buffer-size:10000000}")
    private int proxyBufferSize;
    @Value("${proxy.PathKeyExchange}")
    private String PathKeyExchange;

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(TaxiOlu4aControler.class);

    @Autowired
    Client webClient;
    /*@Autowired
    private TaxiOlu4aRepository TaxiOlu4aRepo;*/

    //@Autowired
    //private TaxiOlu4aService taxiOlu4aService;

    //@GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    //@ResponseStatus(HttpStatus.OK)
    @GetMapping("/drivers")
    public Flux<TaxiOlu4a> findAll() throws SSLException {
        return webClient.createWebClient(proxyUrl, proxyBufferSize)
                .get()
                .uri(PathKeyExchange)  //     /uags/api/v1/exchange
                //.contentType(MediaType.APPLICATION_JSON)
                //.body(BodyInserters.fromValue(request))  // msgID
                //.header("UPI-JWS",getupijws.getContent() )
                .retrieve()
                .bodyToFlux(TaxiOlu4a.class)
                .timeout(Duration.ofMillis(60_000));
        //return taxiOlu4aService.findAll();
    }
}
