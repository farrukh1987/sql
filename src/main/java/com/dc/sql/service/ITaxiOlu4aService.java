package com.dc.sql.service;

import reactor.core.publisher.Flux;
import com.dc.sql.database.TaxiOlu4a;

public interface ITaxiOlu4aService {
    public interface IEmployeeService {
        Flux<TaxiOlu4a> findAll();
    }
}
