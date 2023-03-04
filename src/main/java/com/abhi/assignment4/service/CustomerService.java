package com.abhi.assignment4.service;

import com.abhi.assignment4.dto.CustomerDTO;
import com.abhi.assignment4.exception.AppAccountNotFoundException;
import com.abhi.assignment4.save.entity.Customer;

public interface CustomerService {
    CustomerDTO getByCustomerName(String customerName) throws AppAccountNotFoundException;

    void DeleteAll();

    CustomerDTO add(Customer cus);
}
