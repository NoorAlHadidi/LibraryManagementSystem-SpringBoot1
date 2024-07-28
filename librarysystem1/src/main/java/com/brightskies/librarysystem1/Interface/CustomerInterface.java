package com.brightskies.librarysystem1.Interface;

import com.brightskies.librarysystem1.Model.Customer;

import java.util.Optional;

public interface CustomerInterface {
    public Optional<Customer> findCustomer(String fName, String lName);
    public void addCustomer(Customer customer);
    public void removeCustomer(Customer customer);
}
