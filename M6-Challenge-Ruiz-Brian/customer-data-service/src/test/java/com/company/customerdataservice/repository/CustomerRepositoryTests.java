package com.company.customerdataservice.repository;

import com.company.customerdataservice.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
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

        Customer customer1 = new Customer();
        customer1.setFirstName("Joe");
        customer1.setLastName("Billy");
        customer1.setAddress1("123 Place St");
        customer1.setCity("Union");
        customer1.setState("NY");
        customer1.setCountry("United States");
        customer1.setPostalCode("07087");
        customer1.setCompany("Coca Cola");
        customer1.setEmail("BillyJoe@cocacola.com");
        customer1.setPhone("246-421-5342");

        customer1 = repo.save(customer);

        Optional<Customer> foundCustomer = repo.findById(customer.getId());
        assertEquals(foundCustomer.get(), customer);
    }

    @Test
    public void getCustomerByState() {
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

        Customer customer1 = new Customer();
        customer1.setFirstName("Joe");
        customer1.setLastName("Billy");
        customer1.setAddress1("123 Place St");
        customer1.setCity("Union");
        customer1.setState("NY");
        customer1.setCountry("United States");
        customer1.setPostalCode("07087");
        customer1.setCompany("Coca Cola");
        customer1.setEmail("BillyJoe@cocacola.com");
        customer1.setPhone("246-421-5342");

        customer1 = repo.save(customer);
        List<Customer> customers = repo.findCustomerByState("NJ");
        assertEquals(customers.size(), 1);
    }
}