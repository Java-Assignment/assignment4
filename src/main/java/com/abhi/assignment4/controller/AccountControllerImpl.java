package com.abhi.assignment4.controller;

import com.abhi.assignment4.dto.CustomerDTO;
import com.abhi.assignment4.exception.AppAccountNotFoundException;
import com.abhi.assignment4.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AccountControllerImpl implements AccountController {
    @Autowired
    private CustomerService customerService;

    @Override
    public ResponseEntity<CustomerDTO> getCustomer(String customerName) throws AppAccountNotFoundException {
        CustomerDTO cr = customerService.getByCustomerName(customerName);
        return new ResponseEntity<>(cr, HttpStatus.OK);
    }
}
