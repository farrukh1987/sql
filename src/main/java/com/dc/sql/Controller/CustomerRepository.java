package com.dc.sql.Controller;

import com.dc.sql.Controller.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    ////@Query("SELECT payid FROM oper")
    //Customer updateCustomer(Customer customer);


}