package com.mahmoud.controller;

import com.mahmoud.models.Customer;
import io.micronaut.http.annotation.*;

@Controller
public class CustomerController {

    @Get("/customer")
    public Customer getCustomer(){
        return Customer.builder()
                .id("1")
                .name("Mahmoud")
                .email("mkmohamed").build();
    }

    @Post("/customer")
    public Customer createCustomer(Customer customerDetails){
        return Customer.builder()
                .id("1")
                .name("Mahmoud")
                .email("mkmohamed").build();

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
