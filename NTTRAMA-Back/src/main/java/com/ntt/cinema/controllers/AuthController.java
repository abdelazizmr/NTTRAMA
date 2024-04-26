package com.ntt.cinema.controllers;

import com.ntt.cinema.models.Customer;
import com.ntt.cinema.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AuthController {


    private CustomerService customerService;

    public AuthController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerCustomer(@RequestBody Customer customer) {
        // Check if the customer already exists
        if (customerService.getCustomerByEmail(customer.getEmail()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Customer already exists");
        }

        // Save the new customer
        customerService.createOrUpdateCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body("Customer registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginCustomer(@RequestBody Customer customer) {
        // Check if the customer exists
        Customer existingCustomer = customerService.getCustomerByEmail(customer.getEmail());
        if (existingCustomer == null || !existingCustomer.getPassword().equals(customer.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }

        // Login successful
        return ResponseEntity.ok("Login successful");
    }
}
