package com.project_webapp.springboot.service;


import java.util.List;

import org.springframework.data.domain.Page;

import com.project_webapp.springboot.model.Employee;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee); 
    Employee getEmployeeById(Long id);
    void deleteEmployeeById(Long id);
    Page<Employee> findPaginated(int pageNo, int pageSize,String pageField,String PageDirection);
}