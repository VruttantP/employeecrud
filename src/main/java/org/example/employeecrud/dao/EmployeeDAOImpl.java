package org.example.employeecrud.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.example.employeecrud.model.Employee;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private Configuration config;
    private SessionFactory sessionFactory;

    public EmployeeDAOImpl(){

        this.config=new Configuration().configure();
        this.sessionFactory= config.buildSessionFactory();
    }

    @Override
    @Transactional
    public int saveEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        int id=(int)session.save(employee);
        return id;
    }

    @Override
    @Transactional
    public Employee getEmployeeById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Employee.class,id);
    }

    @Override
    @Transactional
    public void updateEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        Employee existingEmployee = this.getEmployeeById(employee.getId());
        if (existingEmployee != null) {
            session.update(employee);
        }
    }

    @Override
    @Transactional
    public List<Employee> getEmployeeList() {
        Session session = sessionFactory.getCurrentSession();
        String queryStatement = "FROM org.example.employeecrud.model.Employee";
        return session.createQuery(queryStatement,Employee.class).list();
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = session.get(Employee.class,id);
        if(employee != null){
            session.delete(employee);
        }
    }
}
