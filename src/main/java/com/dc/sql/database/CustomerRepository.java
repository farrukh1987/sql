package com.dc.sql.database;

import com.dc.sql.database.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    ////@Query("SELECT payid FROM oper")
    //Customer updateCustomer(Customer customer);


}