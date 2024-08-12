package com.springboot.EmployeeCRM.service;

import com.springboot.EmployeeCRM.entity.Employee;
import com.springboot.EmployeeCRM.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository theemployeeRepository){
        this.employeeRepository=theemployeeRepository;
    }
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Optional<Employee> getById(int id){
        return employeeRepository.findById(id);
    }

    public void deleteById(int id){
        employeeRepository.deleteById(id);
    }

    public Employee updateEmployee(Employee emp){
        return employeeRepository.save(emp);
    }
    public Employee addEmployee(Employee emp){
        return employeeRepository.save(emp);
    }

}
