package com.mahmoud.repository;

import com.mahmoud.models.entities.CustomerEntity;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {
}
