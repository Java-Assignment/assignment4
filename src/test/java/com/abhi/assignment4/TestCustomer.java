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

    private Customer testAddAc;
    private Customer testAddAc1;
    private Customer testAddAc2;
    @Autowired
    CustomerService customerService;

    @BeforeEach
    void Setup() {
        testAddAc = new Customer();
//        testAddAc.add(new CustomerEnrichment("000000000001","abcd",23,Relationship.UNMARRIED,"sector 23,s appartments,gurgaon"));
        testAddAc.setCustomerID("000000000001");
        testAddAc.setCustomerName("abcd");
        testAddAc.setAge(23);
        testAddAc.setRelationship(Relationship.ACTIVE);
        testAddAc.setAddress("sector 23,s appartments,gurgaon");
        testAddAc1 = new Customer();
        testAddAc1.setCustomerID("000000000002");
        testAddAc1.setCustomerName("abcd1");
        testAddAc1.setAge(22);
        testAddAc1.setRelationship(Relationship.INACTIVE);
        testAddAc1.setAddress("rourkela");
        testAddAc2 = new Customer();
        testAddAc2.setCustomerID("000000000003");
        testAddAc2.setCustomerName("abcd2");
        testAddAc2.setAge(30);
        testAddAc2.setRelationship(Relationship.ACTIVE);
        testAddAc2.setAddress("bangalore");


        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());


    }

    @Test
    @DisplayName("Add customer accounts")
    void AddCustomerAccount() throws Exception {
        CustomerDTO c = customerService.add(testAddAc);
        customerService.add(testAddAc1);
        customerService.add(testAddAc2);
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
                () -> Assertions.assertEquals(testAddAc.getCustomerName(), customerDTO.getCustomerName())

        );

    }
}
