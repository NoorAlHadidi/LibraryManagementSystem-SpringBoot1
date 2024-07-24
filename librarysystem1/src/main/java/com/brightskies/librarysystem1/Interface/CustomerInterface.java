package com.brightskies.librarysystem1.Interface;

import com.brightskies.librarysystem1.Model.Customer;

public interface CustomerInterface {
    public Customer findCustomer(String fName, String lName);
    public void addCustomer(Customer newCustomer);
    public void removeCustomer(Customer customer);
}
