package com.springboot.EmployeeCRM.repository;

import com.springboot.EmployeeCRM.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
