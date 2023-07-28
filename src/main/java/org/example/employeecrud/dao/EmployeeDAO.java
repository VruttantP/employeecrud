package org.example.employeecrud.dao;

import org.example.employeecrud.model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {

    int saveEmployee(Employee employee);

    Employee getEmployeeById(int id);

    void updateEmployee(Employee employee);

    List<Employee> getEmployeeList();

    void deleteEmployee(int id);
}
