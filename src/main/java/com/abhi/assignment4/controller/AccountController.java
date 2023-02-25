package com.abhi.assignment4.controller;

import com.abhi.assignment4.entity.CustomerResponse;
import com.abhi.assignment4.exception.AppAccountNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value="/customerDetails",produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
@Validated
@Tag(name="customer details api",description = "api operations on customer details")
public interface AccountController {

    @GetMapping("/{customerName}")
    @Operation(summary = "To get customer details based on name")
    ResponseEntity<CustomerResponse> getCustomerEnrichment(@PathVariable (value = "customerName") String customerName) throws AppAccountNotFoundException;
}
