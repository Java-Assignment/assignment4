package com.abhi.assignment4.mapper;

import com.abhi.assignment4.dto.CustomerDTO;
import com.abhi.assignment4.save.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDTO ConverCetoCr(Customer customer);

    CustomerDTO ConvertCustomertoCustomerDTO(Customer customer);
}
