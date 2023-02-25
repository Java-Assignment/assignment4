package com.abhi.assignment4.controller;

import com.abhi.assignment4.entity.CustomerResponse;
import com.abhi.assignment4.exception.AppAccountNotFoundException;
import com.abhi.assignment4.service.CustomerEnrichmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AccountControllerImpl implements AccountController{
    @Autowired
    private CustomerEnrichmentService customerEnrichmentService;

    @Override
    public ResponseEntity<CustomerResponse> getCustomerEnrichment(String customerName) throws AppAccountNotFoundException {
        CustomerResponse cr=customerEnrichmentService.getByCustomerName(customerName);
        return new ResponseEntity<>(cr,HttpStatus.OK);
    }
}
