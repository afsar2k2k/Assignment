package com.company.rewards.repository;

import org.springframework.data.repository.CrudRepository;

import com.company.rewards.entity.CustomerEntity;

public interface CustomerRepository extends CrudRepository<CustomerEntity,Long> {
    public CustomerEntity findByCustomerId(Long customerId);
}
