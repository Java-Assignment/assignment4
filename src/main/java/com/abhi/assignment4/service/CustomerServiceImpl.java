package com.abhi.assignment4.service;

import com.abhi.assignment4.dto.CustomerDTO;
import com.abhi.assignment4.exception.AppAccountNotFoundException;
import com.abhi.assignment4.mapper.CustomerMapper;
import com.abhi.assignment4.repo.CustomerRepo;
import com.abhi.assignment4.save.entity.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private CustomerMapper customerMapper;



    @Override
    public CustomerDTO getByCustomerName(String customerName) throws AppAccountNotFoundException {
        if (customerName != null) {
            log.info(customerName);
            CustomerDTO cu =customerRepo.findByCustomerName(customerName);
            return cu;
        } else {
            throw new AppAccountNotFoundException("Missing account. AC : " + customerName);
        }
    }

    @Override
    public void DeleteAll() {
        customerRepo.deleteAll();
    }

    @Override
    public CustomerDTO add(Customer cus) {
        Customer customer= customerRepo.save(cus);
        CustomerDTO customerDTO=customerMapper.ConvertCustomertoCustomerDTO(customer);
        return  customerDTO;
    }

}
