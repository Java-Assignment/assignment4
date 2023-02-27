package com.abhi.assignment4.service;

import com.abhi.assignment4.entity.CustomerEnrichment;
import com.abhi.assignment4.entity.CustomerResponse;
import com.abhi.assignment4.exception.AppAccountNotFoundException;
import com.abhi.assignment4.mapper.CustomerEnrichmentMapper;
import com.abhi.assignment4.repo.CustomerEnrichmentRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerEnrichmentServiceImpl implements CustomerEnrichmentService {
    @Autowired
    private CustomerEnrichmentRepo customerEnrichmentRepo;
    @Autowired
    private CustomerEnrichmentMapper customerEnrichmentMapper;


    @Override
    public CustomerResponse getByCustomerName(String customerName) throws AppAccountNotFoundException {
        if (customerName != null) {
            log.info(customerName);
            CustomerEnrichment customerEnrichment = customerEnrichmentRepo.findByCustomerName(customerName);
            CustomerResponse customerResponse = customerEnrichmentMapper.ConverCetoCr(customerEnrichment);
            return customerResponse;
        } else {
            throw new AppAccountNotFoundException("Missing account. AC : " + customerName);
        }
    }

    @Override
    public CustomerEnrichment add(CustomerEnrichment cus) {
        CustomerEnrichment customerEnrichment = customerEnrichmentRepo.save(cus);
        return customerEnrichment;
    }
}
