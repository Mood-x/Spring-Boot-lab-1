package com.example.event_system.API.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.event_system.API.ApiResponse;
import com.example.event_system.Model.Events;

@RestController
@RequestMapping("/api/v1/events")

public class EventController {
    List<Events> events = new ArrayList<>(); 
    

    @GetMapping
    public List<Events> displayEvents(){
        return events; 
    }

    @PostMapping("/add")
    public ApiResponse createEvent(@RequestBody Events event){
        events.add(event);
        return new ApiResponse(" Added to events list"); 
    }

    @PutMapping("/{id}/update")
    public ApiResponse updateEvent(@PathVariable String id, @RequestBody Events newEvent){
        for(Events event: events){
            if(event.getId().equalsIgnoreCase(id)){
                event.setCapacity(newEvent.getCapacity());
                event.setDescription(newEvent.getDescription());
                event.setStartDate(newEvent.getStartDate());
                event.setEndDate(newEvent.getEndDate());
                return new ApiResponse("Event updated"); 
            }
        }
        return new ApiResponse("Evenet with this ID: (" + id + ") not found"); 
    }

    @DeleteMapping("/{id}/delete")
    public ApiResponse DeleteEvent(@PathVariable String id){
        for(Events event: events){
            if(event.getId().equalsIgnoreCase(id)){
                events.remove(event); 
                return new ApiResponse("Event deleted"); 
            }
        }
        return new ApiResponse("Evenet with this ID: (" + id + ") not found"); 
    }

    @PutMapping("/{id}/changeCapacity")
    public ApiResponse changeCapacity(@PathVariable String id, @RequestBody int capacity){
        for(Events event : events){
            if(event.getId().equalsIgnoreCase(id)){
                event.setCapacity(capacity);
                return new ApiResponse("Capascity changed to " + capacity ); 
            }
        }
        return new ApiResponse("Evenet with this ID: (" + id + ") not found"); 
    }

    @GetMapping("/search")
    public ApiResponse changeCapacity(@RequestBody String id){
        for(Events event : events){
            if(event.getId().equalsIgnoreCase(id)){
                return new ApiResponse("Event" + event.toString()); 
            }
        }
        return new ApiResponse("Evenet with this ID: (" + id + ") not found"); 
    }
}
