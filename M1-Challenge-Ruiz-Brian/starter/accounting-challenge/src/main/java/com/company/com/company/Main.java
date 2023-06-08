package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static List<String[]> customerData = Arrays.asList(
            // id, name, charge, date
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","-7500","01-10-2022"},
            new String[] {"1","Wayne Enterprises","18000","12-22-2021"},
            new String[] {"3","Ace Chemical","-48000","01-10-2022"},
            new String[] {"3","Ace Chemical","-95000","12-15-2021"},
            new String[] {"1","Wayne Enterprises","175000","01-01-2022"},
            new String[] {"1","Wayne Enterprises","-35000","12-09-2021"},
            new String[] {"1","Wayne Enterprises","-64000","01-17-2022"},
            new String[] {"3","Ace Chemical","70000","12-29-2022"},
            new String[] {"2","Daily Planet","56000","12-13-2022"},
            new String[] {"2","Daily Planet","-33000","01-07-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","33000","01-17-2022"},
            new String[] {"3","Ace Chemical","140000","01-25-2022"},
            new String[] {"2","Daily Planet","5000","12-12-2022"},
            new String[] {"3","Ace Chemical","-82000","01-03-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"}
    );

    public static void main(String[] args) {
        //Update this
        List<Customer> customers = convertToCustomers(customerData);

        printBalanceAccounts(customers);
    }

    public static List<Customer> convertToCustomers(List<String[]> customerData) {
        List<Customer> customers = new ArrayList<>();

        for (String[] record : customerData) {
            int id = Integer.parseInt(record[0]);
            String name = record[1];
            int chargeAmount = Integer.parseInt(record[2]);
            String date = record[3];

            Customer existingCustomer = findExistingCustomer(customers, name);

            if (existingCustomer != null) {
                AccountRecord accountRecord = new AccountRecord();
                accountRecord.setCharge(chargeAmount);
                accountRecord.setChargeDate(date);

                existingCustomer.getCharges().add(accountRecord);
            }

            else {
                Customer newCustomer = new Customer();
                newCustomer.setId(id);
                newCustomer.setName(name);

                AccountRecord accountRecord = new AccountRecord();
                accountRecord.setCharge(chargeAmount);
                accountRecord.setChargeDate(date);

                newCustomer.getCharges().add(accountRecord);

                customers.add(newCustomer);
            }
        }
        return customers;
    }


    private static Customer findExistingCustomer(List<Customer> customers, String name) {
        for (Customer customer : customers) {
            if (customer.getName().equals(name)) {
                return customer;
            }
        }
        return null;
    }

    public static void printBalanceAccounts(List<Customer> customers) {
        List<Customer> negativeBalances = new ArrayList<>();
        List<Customer> positiveBalances = new ArrayList<>();

        for (Customer customer: customers) {
            if (customer.getBalance() < 0){
                negativeBalances.add(customer);
            }
            else {
                positiveBalances.add(customer);
            }
        }

        if (!negativeBalances.isEmpty()) {
            System.out.println("Negative Accounts: ");
            for (Customer customer : negativeBalances) {
                System.out.println(customer);
            }
        }

        if (!positiveBalances.isEmpty()) {
            System.out.println("Positive Accounts: ");
            for (Customer customer : positiveBalances) {
                System.out.println(customer);
            }
        }
    }
}
