package com.dewiz.restwithspringsecurity;

import com.dewiz.restwithspringsecurity.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ImMemoryEmployeeRepository  {
    private static final List<Employee> DATABASE = new ArrayList<>();

    static {
        DATABASE.add(new Employee(1, "John", "Smith", "john@gmail.com"));
        DATABASE.add(new Employee(2, "Alex", "Raymond", "alex@gmail.com"));
        DATABASE.add(new Employee(3, "David", "Cameron", "david@gmail.com"));
    }

    public Employee addEmployee(Employee employee) {
        DATABASE.add(employee);
        return employee;
    }

    public List<Employee> getAllEmployees() {
        return List.copyOf(DATABASE);
    }

    public Employee findById(Integer id) {
        return DATABASE
                .stream()
                .filter(employee -> id.equals(employee.getId()))
                .findFirst()
                .orElseThrow();
    }

    public void updateEmployee(Employee employee) {
    }

    public Boolean deleteById(Integer id) {
        Employee employee = findById(id);
        DATABASE.remove(employee);
        return Boolean.TRUE;
    }
}
