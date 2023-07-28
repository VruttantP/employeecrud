package org.example.employeecrud.contoller;

import org.example.employeecrud.model.Employee;
import org.example.employeecrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restapi/employeeDetails")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getEmployeeList() {
        return employeeService.getEmployeeList();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id){
       return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public int saveEmployee(@RequestBody Employee employee) {
        int id= employeeService.saveEmployee(employee);
        return id;
    }

    @PutMapping("/{id}")
    public void updateEmployee(Employee employee){
        employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
    }

}
