package com.example.tracker_system.Api.Controller;

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

import com.example.tracker_system.Api.ApiResponse;
import com.example.tracker_system.Model.Project;

@RestController
@RequestMapping("/api/v1/projects")
public class ProjectController {
    List<Project> projects = new ArrayList<>(); 

    @GetMapping()
    public List<Project> displayProjects(){
        return projects; 
    }
    
    @PostMapping("/add")
    public ApiResponse createProject(@RequestBody Project project){
        projects.add(project); 
        return new ApiResponse(project.getTitle() + " Added to project list"); 
    }

    @PutMapping("/{index}/update")
    public ApiResponse updateProject(@PathVariable int index, @RequestBody Project project){
        projects.set(index, project); 
        return new ApiResponse("Project updated"); 
    }

    @DeleteMapping("/{index}/delete")
    public ApiResponse deleteProject(@PathVariable int index){
        Project project = projects.get(index); 
        projects.remove(project);
        return new ApiResponse(project.getTitle() + " Deleted from projects list "); 
    }

    @PutMapping("/{index}/status")
    public ApiResponse changeStatus(@PathVariable int index, @RequestBody String status){
        Project project = projects.get(index); 
        project.setStatus(status);
        return new ApiResponse(project.getTitle() + " Change status to " + project.getStatus()); 
    }

    @GetMapping("/search")
    public ApiResponse searchProject(@RequestBody String title){
        ArrayList titleProjects = new ArrayList<>(); 
        for(Project project : projects){
            if(project.getTitle().equalsIgnoreCase(title)){
                titleProjects.add(project); 
            }
        }
        return new ApiResponse(titleProjects.isEmpty() ? "Project not found" : titleProjects.toString());  
    }

    @GetMapping("/company")
    public ApiResponse displayCompanyProjects(@RequestBody String company){
        ArrayList companyProjects = new ArrayList<>(); 

        for(Project project : projects){
            if(project.getCompanyName().equalsIgnoreCase(company)){
                companyProjects.add(project); 
            }
        }
        return new ApiResponse(companyProjects.isEmpty() ? "Not found projects " : " All projects for this company " + companyProjects); 
    }
}
