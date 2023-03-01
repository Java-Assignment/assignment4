package com.abhi.assignment4.repo;

import com.abhi.assignment4.dto.CustomerDTO;
import com.abhi.assignment4.save.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends MongoRepository<Customer, String> {


    CustomerDTO findByCustomerName(String customerName);
}
