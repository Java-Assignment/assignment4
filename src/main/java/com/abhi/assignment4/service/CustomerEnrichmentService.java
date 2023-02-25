package com.abhi.assignment4.service;

import com.abhi.assignment4.entity.CustomerEnrichment;
import com.abhi.assignment4.entity.CustomerResponse;
import com.abhi.assignment4.exception.AppAccountNotFoundException;

public interface CustomerEnrichmentService {
    CustomerResponse getByCustomerName(String customerName) throws AppAccountNotFoundException;

    CustomerEnrichment add(CustomerEnrichment cus);
}
