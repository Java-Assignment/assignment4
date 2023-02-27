package com.abhi.assignment4;

import com.abhi.assignment4.entity.CustomerEnrichment;
import com.abhi.assignment4.entity.Relationship;
import com.abhi.assignment4.repo.CustomerEnrichmentRepo;
import com.abhi.assignment4.service.CustomerEnrichmentService;
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
public class TestCustomerEnrichment {
    @Autowired
    CustomerEnrichmentRepo customerEnrichmentRepo;
    private ObjectMapper objectMapper;

    @Autowired
    MockMvc mockMvc;

    private CustomerEnrichment testAddAc;
    private CustomerEnrichment testAddAc1;
    private CustomerEnrichment testAddAc2;
    @Autowired
    CustomerEnrichmentService customerEnrichmentService;

    @BeforeEach
    void Setup() {
        testAddAc = new CustomerEnrichment();
//        testAddAc.add(new CustomerEnrichment("000000000001","abcd",23,Relationship.UNMARRIED,"sector 23,s appartments,gurgaon"));
        testAddAc.setCustomerID("000000000001");
        testAddAc.setCustomerName("abcd");
        testAddAc.setAge(23);
        testAddAc.setRelationship(Relationship.UNMARRIED);
        testAddAc.setAddress("sector 23,s appartments,gurgaon");
        testAddAc1 = new CustomerEnrichment();
        testAddAc1.setCustomerID("000000000002");
        testAddAc1.setCustomerName("abcd1");
        testAddAc1.setAge(22);
        testAddAc1.setRelationship(Relationship.UNMARRIED);
        testAddAc1.setAddress("rourkela");
        testAddAc2 = new CustomerEnrichment();
        testAddAc2.setCustomerID("000000000003");
        testAddAc2.setCustomerName("abcd2");
        testAddAc2.setAge(30);
        testAddAc2.setRelationship(Relationship.MARRIED);
        testAddAc2.setAddress("bangalore");
        ;


        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());


    }

    @Test
    @DisplayName("Add customer accounts")
    void AddCustomerAccount() throws Exception {
        CustomerEnrichment c = customerEnrichmentService.add(testAddAc);
        customerEnrichmentService.add(testAddAc1);
        customerEnrichmentService.add(testAddAc2);
        String custname = c.getCustomerName();
        MvcResult mvcResult = mockMvc.perform(
                        MockMvcRequestBuilders.get("/customerDetails" + "/" + custname)
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .accept(MediaType.APPLICATION_JSON_VALUE)
                )
                .andDo(print())
                .andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        CustomerEnrichment customerEnrichment = objectMapper.readValue(contentAsString, CustomerEnrichment.class);


        Assertions.assertAll(
                () -> Assertions.assertEquals(testAddAc.getCustomerName(), customerEnrichment.getCustomerName())

        );

    }
}
