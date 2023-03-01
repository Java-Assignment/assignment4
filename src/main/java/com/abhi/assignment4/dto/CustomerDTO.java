package com.abhi.assignment4.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerDTO {
    private String customerName;
    private int age;
    private String relationship;
    private String address;
}
