package com.brightskies.librarysystem1.Config;

import com.brightskies.librarysystem1.Model.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class AppConfig {
    @Bean
    public Author author() {
        return new Author();
    }
    @Bean
    public Customer customer() {
        return new Customer();
    }
    @Bean
    public ArrayList<Book> books() {
        return new ArrayList<Book>();
    }
    @Bean
    public ArrayList<Author> authors() {
        return new ArrayList<Author>();
    }
    @Bean
    public ArrayList<Customer> customers() {
        return new ArrayList<Customer>();
    }
    @Bean
    public ArrayList<Book> reserved() {
        return new ArrayList<Book>();
    }
    @Bean
    public ArrayList<Book> written() {
        return new ArrayList<Book>();
    }
}
