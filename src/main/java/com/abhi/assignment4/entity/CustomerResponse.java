package com.abhi.assignment4.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerResponse {
    private String customerName;
    private int age;
    private String relationship;
    private String address;
}
