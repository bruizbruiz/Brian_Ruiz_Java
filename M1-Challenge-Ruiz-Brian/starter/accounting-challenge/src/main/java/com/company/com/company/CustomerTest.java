package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerTest {

    @Test
    public void testGetBalance() {
        Customer customer = new Customer();
        AccountRecord charge1 = new AccountRecord();
        charge1.setCharge(5000);
        customer.getCharges().add(charge1);

        AccountRecord charge2 = new AccountRecord();
        charge2.setCharge(-10000);
        customer.getCharges().add(charge2);

        assertEquals(-5000, customer.getBalance());
    }

    @Test
    public void testToString() {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Joe");
        AccountRecord charge1 = new AccountRecord();
        charge1.setCharge(6500);
        customer.getCharges().add(charge1);

        assertEquals("Customer ID: 1, Name: Joe, Balance: 6500", customer.toString());
    }
}