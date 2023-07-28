package org.example.employeecrud.dao;

import junit.framework.TestCase;
import org.example.employeecrud.model.Employee;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

public class EmployeeDAOImplTest extends TestCase {
    private EmployeeDAO employeeDAO;

    @BeforeEach
    public void setUp() {
        employeeDAO = new EmployeeDAOImpl();
    }

    @Test
    public void testSaveAndGetEmployee() {

        Employee employee = new Employee();
        employee.setFirstName("Raj");
        employee.setLastName("Verma");
        employee.setEmail("raj.verma@imagine.com");
        employee.setAge(35);

        employeeDAO.saveEmployee(employee);

        List<Employee> employees = employeeDAO.getEmployeeList();

        Employee savedEmployee = employees.get(0);
        assertEquals("Raj", savedEmployee.getFirstName());
        assertEquals("Verma", savedEmployee.getLastName());
        assertEquals("raj.verma@imagine.com", savedEmployee.getEmail());
        assertEquals(35,savedEmployee.getAge());

    }

    @Test
    public void testSaveAndGetEmployeeById() {
        Employee employee = new Employee();
        employee.setFirstName("Raj");
        employee.setLastName("Verma");
        employee.setEmail("raj.verma@imagine.com");
        employee.setAge(35);

        int id = employeeDAO.saveEmployee(employee);

        Employee employee1 = employeeDAO.getEmployeeById(id);

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
        employeeDAO.saveEmployee(employee1);
        employeeDAO.saveEmployee(employee2);

        List<Employee> employees = employeeDAO.getEmployeeList();

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

        int id = employeeDAO.saveEmployee(employee);

        employee.setAge(45);
        employeeDAO.updateEmployee(employee);

        Employee updatedEmployee = employeeDAO.getEmployeeById(id);

        assertEquals(45, updatedEmployee.getAge());

    }

    @Test
    public void testDeleteEmployee() {

        Employee employee = new Employee();
        employee.setFirstName("Raj");
        employee.setLastName("Verma");
        employee.setEmail("raj.verma@imagine.com");
        employee.setAge(35);

        int id = employeeDAO.saveEmployee(employee);
        employeeDAO.deleteEmployee(id);

        assertNull(employeeDAO.getEmployeeById(id));

    }

}