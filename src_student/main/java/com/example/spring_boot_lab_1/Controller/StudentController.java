package com.example.spring_boot_lab_1.Controller;

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

import com.example.spring_boot_lab_1.API.ApiResponse;
import com.example.spring_boot_lab_1.Model.Students;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    List<Students> students = new ArrayList<>(); 
    

    @GetMapping()
    public List<Students> getAllStudents(){
        return students; 
    }


    @GetMapping("/{index}/name")
    public ApiResponse getStudentName(@PathVariable int index){
        Students student = students.get(index); 
        return new ApiResponse(student.getName()); 
    }


    @GetMapping("/{index}/age")
    public ApiResponse getStudentAge(@PathVariable int index){
        Students student = students.get(index);
        return new ApiResponse("Student age: [ " + student.getAge() + " ]"); 
    }


    @GetMapping("/{index}/college/degree")
    public ApiResponse getStudentDegree(@PathVariable int index){

        Students student = students.get(index);
        return new ApiResponse("Student degree: [ " + student.getDegree() + " ]"); 
    }


    @GetMapping("/{index}/study/status")
    public ApiResponse getStudentStatus(@PathVariable int index){
        Students student = students.get(index);
        return new ApiResponse(student.getStatus().equalsIgnoreCase("graduated") ? "[ True ]" : "[ False ]"); 
    }


    @PostMapping("/add")
    public ApiResponse createStudent(@RequestBody Students student){
        students.add(student);
        return new ApiResponse("Added student [ " + student.getName() + " ]"); 
    } 

    @PutMapping("/{index}/update")
    public ApiResponse updateStudent(@PathVariable int index, @RequestBody Students student){
        students.set(index, student); 
        return new ApiResponse(student.getName() + " are updated"); 
    }

    @DeleteMapping("/{index}/delete")
    public ApiResponse deleteStudent(@PathVariable int index){
        Students student = students.get(index); 
        students.remove(index); 
        return new ApiResponse(student.getName() + " are deleted"); 
    }

}
