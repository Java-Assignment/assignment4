package com.abhi.assignment4.save.entity;

import com.abhi.assignment4.common.Relationship;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "as4accounts")
@Data
@NoArgsConstructor
public class Customer {
    @Id
    private String customerID;
    private String customerName;
    private int age;
    private Relationship relationship;
    private String address;
}
