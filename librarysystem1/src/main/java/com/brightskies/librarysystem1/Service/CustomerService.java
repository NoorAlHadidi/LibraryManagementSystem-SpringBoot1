package com.brightskies.librarysystem1.Service;

import com.brightskies.librarysystem1.DTO.AuthorDTO;
import com.brightskies.librarysystem1.DTO.CustomerDTO;
import com.brightskies.librarysystem1.Interface.CustomerInterface;
import com.brightskies.librarysystem1.Model.Book;
import com.brightskies.librarysystem1.Model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService implements CustomerInterface {
    private ArrayList<Customer> customers;

    public CustomerService() {
        this.customers = new ArrayList<>();
    }

    /*@Autowired
    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }*/

    @Override
    public ArrayList<CustomerDTO> displayCustomers() {
        return (this.customers).stream().map(customer -> new CustomerDTO(customer.getFirst(), customer.getLast())).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public Optional<Customer> findCustomer(String fName, String lName) {
        Customer result = null;
        for (Customer tempCustomer : customers) {
            if ((tempCustomer.getFirst()).equals(fName) && (tempCustomer.getLast()).equals(lName)) {
                result = tempCustomer;
                break;
            }
        }
        return Optional.ofNullable(result);
    }

    @Override
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public void removeCustomer(Customer customer) {
        customers.remove(customer);
    }

    @Override
    public void reserveBook(Customer customer, Book book) {
        if(book.getCustomer().isEmpty()) {
            book.setCustomer(customer);
        }
    }

}
