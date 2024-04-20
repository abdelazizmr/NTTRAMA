package com.ntt.cinema.controllers;

import com.ntt.cinema.models.Customer;
import com.ntt.cinema.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public String getAllCustomers(Model model) {
        List<Customer> customers = customerService.getAllCustomers();
        model.addAttribute("customers", customers);
        return "customers";
    }

    @PostMapping("/customers")
    public String createOrUpdateCustomer(@ModelAttribute("customer") Customer customer) {
        Optional<Customer> existingCustomer = customerService.getCustomerById(customer.getId());
        if (existingCustomer.isPresent()) {
            Customer existing = existingCustomer.get();
            existing.setFirstname(customer.getFirstname());
            existing.setLastname(customer.getLastname());
            existing.setEmail(customer.getEmail());
            customerService.createOrUpdateCustomer(existing);
        } else {
            customer.setAdded_date(new Timestamp(System.currentTimeMillis()));
            customerService.createOrUpdateCustomer(customer);
        }
        return "redirect:/customers";
    }

    @PostMapping("/{id}")
    public String deleteCustomer(@PathVariable int id) {
        customerService.deleteCustomerById(id);
        return "redirect:/customers";
    }
}

