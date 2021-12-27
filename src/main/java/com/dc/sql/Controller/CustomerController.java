package com.dc.sql.Controller;

import com.dc.sql.Controller.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class CustomerController {
    @Autowired
    private CustomerRepository customerRepo;

    @GetMapping("/customers")
    public String listAll(Model model) {
        System.out.print("it`s controler");
        List<Customer> listCustomers = customerRepo.findAll();
        model.addAttribute("listCustomers", listCustomers);

        return "SASAS";//String.valueOf(listCustomers);
    }
}
