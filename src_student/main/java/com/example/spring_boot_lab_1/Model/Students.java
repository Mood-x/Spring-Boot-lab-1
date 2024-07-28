package com.example.spring_boot_lab_1.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Students {
    private String name; 
    private int age; 
    private String degree; 
    private String status; 
}
