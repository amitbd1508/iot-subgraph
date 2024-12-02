package com.sleepai.iotserver.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class AuthorInput {
    private String firstName;
    private String lastName;
}
