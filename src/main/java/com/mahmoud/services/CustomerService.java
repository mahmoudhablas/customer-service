package com.mahmoud.services;

import com.mahmoud.models.Customer;
import com.mahmoud.models.entities.CustomerEntity;
import com.mahmoud.repository.CustomerRepository;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Singleton
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer getCustomer(Long id)
    {

        CustomerEntity customerEntity = this.customerRepository.findById(id).orElse(null);
        if (customerEntity != null) {
            return Customer.builder()
                    .name(customerEntity.getName())
                    .email(customerEntity.getEmail())
                    .id(customerEntity.getId()).build();
        }
        return null;
    }
    public List<Customer> getCustomers(){
        List<CustomerEntity> customerEntities = this.customerRepository.findAll();
        List<Customer> customers = new ArrayList<>();
        for (CustomerEntity customerEntity: customerEntities){

            customers.add(Customer.builder()
                    .name(customerEntity.getName())
                    .email(customerEntity.getEmail())
                    .id(customerEntity.getId()).build());
        }
        return customers;
    }
    public Customer createCustomer(Customer customerDetails)
    {
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
    public void deleteCustomer(Long id){

        this.customerRepository.deleteById(id);
    }
    public void updateCustomer(Long id, Customer customer){
        CustomerEntity customerEntity = this.customerRepository.findById(id).orElseThrow();
        customerEntity.setEmail(customer.getEmail());
        customerEntity.setName(customer.getName());
        this.customerRepository.save(customerEntity);

    }
}
