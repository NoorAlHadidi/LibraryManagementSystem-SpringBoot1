package com.brightskies.librarysystem1.Interface;

import com.brightskies.librarysystem1.DTO.CustomerDTO;
import com.brightskies.librarysystem1.Model.Book;
import com.brightskies.librarysystem1.Model.Customer;

import java.util.ArrayList;
import java.util.Optional;

public interface CustomerInterface {
    public ArrayList<CustomerDTO> displayCustomers();
    public Optional<Customer> findCustomer(String fName, String lName);
    public void addCustomer(Customer customer);
    public void removeCustomer(Customer customer);
    public void reserveBook(Customer customer, Book book);
}
