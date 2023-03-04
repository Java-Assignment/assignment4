package com.abhi.assignment4;

import com.abhi.assignment4.common.Relationship;
import com.abhi.assignment4.dto.CustomerDTO;
import com.abhi.assignment4.repo.CustomerRepo;
import com.abhi.assignment4.save.entity.Customer;
import com.abhi.assignment4.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class TestCustomer {
    @Autowired
    CustomerRepo customerRepo;
    private ObjectMapper objectMapper;
    @Autowired
    MockMvc mockMvc;

    private Customer testAddCustomer1;
    private Customer testAddCustomer2;
    private Customer testAddCustomer3;
    @Autowired
    CustomerService customerService;

    @BeforeEach
    void Setup() {
        customerRepo.deleteAll();
        testAddCustomer1 = new Customer();
        testAddCustomer1.setCustomerID("Cust1");
        testAddCustomer1.setCustomerName("Test User1");
        testAddCustomer1.setAge(23);
        testAddCustomer1.setRelationship(Relationship.ACTIVE);
        testAddCustomer1.setAddress("sector 23,s appartments,gurgaon");
        testAddCustomer2 = new Customer();
        testAddCustomer2.setCustomerID("Cust2");
        testAddCustomer2.setCustomerName("Test User2");
        testAddCustomer2.setAge(22);
        testAddCustomer2.setRelationship(Relationship.INACTIVE);
        testAddCustomer2.setAddress("rourkela");
        testAddCustomer3 = new Customer();
        testAddCustomer3.setCustomerID("Cust3");
        testAddCustomer3.setCustomerName("Test User3");
        testAddCustomer3.setAge(30);
        testAddCustomer3.setRelationship(Relationship.ACTIVE);
        testAddCustomer3.setAddress("bangalore");


        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());


    }

    @Test
    @DisplayName("Add customer accounts")
    void AddCustomerAccount() throws Exception {
        CustomerDTO c = customerService.add(testAddCustomer1);
        customerService.add(testAddCustomer2);
        customerService.add(testAddCustomer3);
        String custname = c.getCustomerName();
        MvcResult mvcResult = mockMvc.perform(
                        MockMvcRequestBuilders.get("/customer" + "/" + custname)
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .accept(MediaType.APPLICATION_JSON_VALUE)
                )
                .andDo(print())
                .andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        CustomerDTO customerDTO = objectMapper.readValue(contentAsString, CustomerDTO.class);


        Assertions.assertAll(
                () -> Assertions.assertEquals(testAddCustomer1.getCustomerName(), customerDTO.getCustomerName())

        );

    }
}
