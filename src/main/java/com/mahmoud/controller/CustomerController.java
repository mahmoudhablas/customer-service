package com.mahmoud.controller;

import com.mahmoud.models.Customer;
import com.mahmoud.models.entities.CustomerEntity;
import com.mahmoud.repository.CustomerRepository;
import com.mahmoud.services.CustomerService;
import io.micronaut.http.HttpMethod;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class CustomerController {

   private final CustomerRepository customerRepository;
    private final CustomerService customerService;


    @Get("/customers/{id}")
    public HttpResponse<Customer> getCustomer(@PathVariable Long id){

        return HttpResponse.ok(customerService.getCustomer(id));
    }
    @Get("/customers")
    public HttpResponse<List<Customer>> getCustomers(){
        return HttpResponse.ok(customerService.getCustomers());
    }
    @Post("/customers")
    public HttpResponse<Customer> createCustomer(@Body Customer customerDetails){

        return HttpResponse.created(this.customerService.createCustomer(customerDetails));
    }
    @Delete("/customers/{id}")
    public HttpResponse<?> deleteCustomer(@PathVariable Long id)
    {
        this.customerService.deleteCustomer(id);
        return HttpResponse.noContent();
    }
    @Put("/customers/{id}")
    public HttpResponse<?> updateCustomer(@PathVariable Long id, @Body Customer customerDetails){
        this.customerService.updateCustomer(id,customerDetails);
        return HttpResponse.ok();

    }
}
