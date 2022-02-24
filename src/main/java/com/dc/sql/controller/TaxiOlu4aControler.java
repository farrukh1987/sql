package com.dc.sql.controller;

import com.dc.sql.client.Client;
import com.dc.sql.service.TaxiOlu4aService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import reactor.core.publisher.Flux;

import javax.net.ssl.SSLException;
import java.time.Duration;

@RestController

public class TaxiOlu4aControler {
    /*@Autowired
    private TaxiOlu4aRepository TaxiOlu4aRepo;*/

    //@Autowired
    private TaxiOlu4aService taxiOlu4aService;

    //@GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    //@ResponseStatus(HttpStatus.OK)
    @Value("${proxy.url}")
    private String proxyUrl;
    @Value("${proxy.buffer-size:10000000}")
    private int proxyBufferSize;

    @Autowired
    Client webClient;
    @GetMapping("/drivers")
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
    /*public Flux<String> findAll() throws SSLException {
        return taxiOlu4aService.findAll();
    }*/
}
