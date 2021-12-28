package com.dc.sql.Controller;

import com.dc.sql.Controller.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller	// This means that this class is a Controller
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepo;

    @GetMapping("/customers")
    public Iterable<Customer> listAll(Model model) {
        System.out.print("it`s controler");
        Iterable<Customer> listCustomers = customerRepo.findAll();
        model.addAttribute("listCustomers", listCustomers);
        return customerRepo.findAll();
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<Customer> getCustomers() {
        // This returns a JSON or XML with the users
        return customerRepo.findAll();
    }
}
