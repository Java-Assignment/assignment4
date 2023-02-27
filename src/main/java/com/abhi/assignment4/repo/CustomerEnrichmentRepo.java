package com.abhi.assignment4.repo;

import com.abhi.assignment4.entity.CustomerEnrichment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerEnrichmentRepo extends MongoRepository<CustomerEnrichment, String> {


    CustomerEnrichment findByCustomerName(String customerName);
}
