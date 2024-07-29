package com.brightskies.librarysystem1.Controller;

import com.brightskies.librarysystem1.Model.Book;
import com.brightskies.librarysystem1.Model.Customer;
import com.brightskies.librarysystem1.Service.BookService;
import com.brightskies.librarysystem1.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/customer")
@RestController
public class CustomerController {
    private CustomerService customerService;
    private BookService bookService;

    @Autowired
    public CustomerController(CustomerService customerService, BookService bookService) {
        this.customerService = customerService;
        this.bookService = bookService;
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addCustomer(@RequestBody Customer customer) {
        if (customerService.findCustomer(customer.getFirst(), customer.getLast()).isEmpty()) {
            customerService.addCustomer(customer);
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/remove/{first}/{last}")
    public ResponseEntity<Void> removeCustomer(@PathVariable String first, @PathVariable String last) {
        if (customerService.findCustomer(first, last).isPresent()) {
            customerService.removeCustomer(customerService.findCustomer(first, last).get());
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PatchMapping("/reserve/{first}/{last}")
    public ResponseEntity<Void> reserveBook(@RequestBody Book book, @PathVariable String first, @PathVariable String last) {
        if(bookService.findBook(book.getID()).isPresent()) {
            if (customerService.findCustomer(first, last).isEmpty()) {
                Customer customer = new Customer(first, last);
                customerService.addCustomer(customer);
            }
            bookService.findBook(book.getID()).get().setCustomer(customerService.findCustomer(first, last).get());
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
