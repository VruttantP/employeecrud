package org.example.employeecrud.service;

import org.example.employeecrud.model.Employee;

import java.util.List;

public interface EmployeeService {

    int saveEmployee(Employee employee);

    Employee getEmployeeById(int id);

    void updateEmployee(Employee employee);

    List<Employee> getEmployeeList();

    void deleteEmployee(int id);
}
