package com.example.tracker_system.Model;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Project {
    private String id; 
    private String title;
    private String description;
    private String status = "Not Done"; 
    private String companyName; 
}
