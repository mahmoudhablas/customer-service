package com.mahmoud.controller;

import com.mahmoud.models.Customer;
import com.mahmoud.models.entities.CustomerEntity;
import com.mahmoud.repository.CustomerRepository;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;

import java.util.Optional;

@Controller
public class CustomerController {

   private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    // TO DO use service instead of the controller (and use map struct)
    @Get("/customer")
    public Customer getCustomer(@QueryValue Long id){
        CustomerEntity customerEntity = this.customerRepository.findById(id).orElse(null);
        if (customerEntity != null) {
            return Customer.builder()
                    .name(customerEntity.getName())
                    .email(customerEntity.getEmail())
                    .id(customerEntity.getId()).build();
        }
        return null;

    }

    @Post("/customer")
    public Customer createCustomer(@Body Customer customerDetails){
        CustomerEntity customerEntity = CustomerEntity.builder()
                .name(customerDetails.getName())
                .email(customerDetails.getEmail())
                .build();
        this.customerRepository.save(customerEntity);
        return Customer.builder()
                .name(customerEntity.getName())
                .email(customerEntity.getEmail())
                .id(customerEntity.getId()).build();
    }
    @Delete
    public void deleteCustomer(String customerId)
    {
        // delete the customer using the id
    }
    @Put
    public void updateCustomer(String customerDetails){
        //update the customer using the id
    }
}
