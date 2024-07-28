package com.example.event_system.Model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor


public class Events {

    private String id;
    private String description; 
    private int capacity; 
    
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDateTime startDate; 

    @JsonFormat(pattern="yyyy-MM-dd")

    private LocalDateTime endDate; 
}
