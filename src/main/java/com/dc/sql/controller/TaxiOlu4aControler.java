package com.dc.sql.controller;

import com.dc.sql.service.TaxiOlu4aService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import reactor.core.publisher.Flux;

import javax.net.ssl.SSLException;

@RestController
@RequestMapping("/drivers")
public class TaxiOlu4aControler {
    /*@Autowired
    private TaxiOlu4aRepository TaxiOlu4aRepo;*/

    //@Autowired
    private TaxiOlu4aService taxiOlu4aService;

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Flux<String> findAll() throws SSLException {
        return taxiOlu4aService.findAll();
    }
}
