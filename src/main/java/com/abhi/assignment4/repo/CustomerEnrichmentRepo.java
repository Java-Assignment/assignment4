package com.abhi.assignment4.repo;

import com.abhi.assignment4.entity.CustomerEnrichment;
import com.abhi.assignment4.entity.CustomerResponse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;

@Repository
public interface CustomerEnrichmentRepo extends MongoRepository<CustomerEnrichment,String> {


    CustomerEnrichment findByCustomerName(String customerName);
}
