package org.example.employeecrud.service;

import junit.framework.TestCase;
import org.example.employeecrud.dao.EmployeeDAO;
import org.example.employeecrud.dao.EmployeeDAOImpl;
import org.example.employeecrud.model.Employee;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeServiceImplTest extends TestCase {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void testSaveAndGetEmployeeById() {
        Employee employee = new Employee();
        employee.setFirstName("Raj");
        employee.setLastName("Verma");
        employee.setEmail("raj.verma@imagine.com");
        employee.setAge(35);

        int id = employeeService.saveEmployee(employee);

        Employee employee1 = employeeService.getEmployeeById(id);

        assertEquals("Raj", employee1.getFirstName());
        assertEquals("Verma", employee1.getLastName());
        assertEquals("raj.verma@imagine.com", employee1.getEmail());
        assertEquals(35,employee1.getAge());

    }

    @Test
    public void testGetEmployeeList() {
        Employee employee1 = new Employee( "Raj", "Verma",
                "raj.verma@imagine.com",35);
        Employee employee2 = new Employee( "Vaibhav ", "Telang",
                "v.telang@futureready.com",29);
        employeeService.saveEmployee(employee1);
        employeeService.saveEmployee(employee2);

        List<Employee> employees = employeeService.getEmployeeList();

        assertEquals("Raj", employees.get(0).getFirstName());
        assertEquals("Verma", employees.get(0).getLastName());
        assertEquals("raj.verma@imagine.com", employees.get(0).getEmail());
        assertEquals(35,employees.get(0).getAge());

        assertEquals("Vaibhav", employees.get(1).getFirstName());
        assertEquals("Telang", employees.get(1).getLastName());
        assertEquals("v.telang@futureready.com", employees.get(1).getEmail());
        assertEquals(29,employees.get(1).getAge());

    }

    @Test
    public void testUpdateEmployee() {

        Employee employee = new Employee();
        employee.setFirstName("Raj");
        employee.setLastName("Verma");
        employee.setEmail("raj.verma@imagine.com");
        employee.setAge(35);

        int id = employeeService.saveEmployee(employee);

        employee.setAge(45);
        employeeService.updateEmployee(employee);

        Employee updatedEmployee = employeeService.getEmployeeById(id);

        assertEquals(45, updatedEmployee.getAge());

    }

    @Test
    public void testDeleteEmployee() {

        Employee employee = new Employee();
        employee.setFirstName("Raj");
        employee.setLastName("Verma");
        employee.setEmail("raj.verma@imagine.com");
        employee.setAge(35);

        int id = employeeService.saveEmployee(employee);
        employeeService.deleteEmployee(id);

        assertNull(employeeService.getEmployeeById(id));

    }

}
