package com.dc.sql.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class CustomerController {
    @Autowired
    private CustomerRepository customerRepo;

    @GetMapping("/customers")
    public String listAll(Model model) {
        List<Customer> listCustomers = customerRepo.findAll();
        model.addAttribute("listCustomers", listCustomers);

        return "customers";
    }
}
