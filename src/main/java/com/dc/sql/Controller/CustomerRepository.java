package com.dc.sql.Controller;

import com.dc.sql.Controller.model.Customer;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


//public interface CustomerRepository extends JpaRepository<Customer, Long> {
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    ////@Query("SELECT payid FROM oper")
    //Customer updateCustomer(Customer customer);


}