package com.springboot.EmployeeCRM.controller;

import com.springboot.EmployeeCRM.entity.Employee;
import com.springboot.EmployeeCRM.exception.ApiSuccessResponse;
import com.springboot.EmployeeCRM.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService theemployeeService){
        this.employeeService=theemployeeService;
    }

    @GetMapping("/employees")
    public ResponseEntity<ApiSuccessResponse> getAllEmployees(){
        List<Employee> employees=employeeService.getAllEmployees();
        ApiSuccessResponse response=new ApiSuccessResponse(true,"[]",employees);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<ApiSuccessResponse> addNewEmployee(@RequestBody Employee emp){
        Employee employee=employeeService.addEmployee(emp);
        ApiSuccessResponse response=new ApiSuccessResponse(true,"[]",employee);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PutMapping("/employees")
    public ResponseEntity<ApiSuccessResponse> updateExistingEmployee(@RequestBody Employee emp){
        Employee employee=employeeService.updateEmployee(emp);
        ApiSuccessResponse response=new ApiSuccessResponse(true,"[]",employee);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping("/employees/{employeeId}")
    public ResponseEntity<ApiSuccessResponse> updateExistingEmployee(@PathVariable("employeeId")int id){
        employeeService.deleteById(id);
        ApiSuccessResponse response=new ApiSuccessResponse(true,"[]","Deleted Employee Of Id: "+id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
