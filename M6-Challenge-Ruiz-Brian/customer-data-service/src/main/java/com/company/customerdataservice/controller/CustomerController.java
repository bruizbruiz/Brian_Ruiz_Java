package com.company.customerdataservice.controller;

import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
    @Autowired
    CustomerRepository repo;
    // CRUD routes
    // Creates a new customer
    @PostMapping("/customer")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer addCustomer(@RequestBody Customer customer) {
        return repo.save(customer);
    }

    // Updates an existing customer
    @PutMapping("/customer")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@RequestBody Customer customer) {
        repo.save(customer);
    }

    // Deletes a customer
    @DeleteMapping("/customer/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomerById(@PathVariable int id) {
        repo.deleteById(id);
    }

    // Gets a specific customer by id
    @GetMapping("/customer/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer getCustomerById(@PathVariable int id) {
        Optional<Customer> customer = repo.findById(id);

        return customer.isPresent() ? customer.get() : null;
    }

    // Gets customers by state
    @GetMapping("/customer/state/{state}")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getCustomersByState(@PathVariable String state) {
        return repo.findCustomerByState(state);
    }
    // For CustomerControllerTest create MockMVC object to test Http Status
}
