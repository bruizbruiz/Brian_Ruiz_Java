package com.company.customerdataservice.repository;

import com.company.customerdataservice.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


@SpringBootTest
public class CustomerRepositoryTests {

    @Autowired
    CustomerRepository repo;

    @BeforeEach
    public void setUp() throws Exception{
        repo.deleteAll();
    }

    @Test
    public void addCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("Brian");
        customer.setLastName("Ruiz");
        customer.setAddress1("225 Chestnut St");
        customer.setCity("NWR");
        customer.setState("NJ");
        customer.setCountry("United States");
        customer.setPostalCode("07102");
        customer.setCompany("Pepsi");
        customer.setEmail("bruiz@pepsi.co");
        customer.setPhone("111-223-7584");

        customer = repo.save(customer);

        Optional<Customer> customer1 = repo.findById(customer.getId());
        assertEquals(customer1.get(), customer);
    }

    @Test
    public void updateCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("Brian");
        customer.setLastName("Ruiz");
        customer.setAddress1("225 Chestnut St");
        customer.setCity("NWR");
        customer.setState("NJ");
        customer.setCountry("United States");
        customer.setPostalCode("07102");
        customer.setCompany("Pepsi");
        customer.setEmail("bruiz@pepsi.co");
        customer.setPhone("111-223-7584");

        customer = repo.save(customer);

        customer.setLastName("Joe");
        repo.save(customer);

        Optional<Customer> customer1 = repo.findById(customer.getId());
        assertEquals(customer1.get(), customer);
    }

    @Test
    public void deleteCustomerById() {
        Customer customer = new Customer();
        customer.setFirstName("Brian");
        customer.setLastName("Ruiz");
        customer.setAddress1("225 Chestnut St");
        customer.setCity("NWR");
        customer.setState("NJ");
        customer.setCountry("United States");
        customer.setPostalCode("07102");
        customer.setCompany("Pepsi");
        customer.setEmail("bruiz@pepsi.co");
        customer.setPhone("111-223-7584");

        customer = repo.save(customer);

        repo.deleteById(customer.getId());
        Optional<Customer> customer1 = repo.findById(customer.getId());

        assertFalse(customer1.isPresent());
    }

    @Test
    public void getCustomerById() {
        
    }
}