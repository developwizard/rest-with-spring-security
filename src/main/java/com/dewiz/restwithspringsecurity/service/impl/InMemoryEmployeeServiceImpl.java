package com.dewiz.restwithspringsecurity.service.impl;

import com.dewiz.restwithspringsecurity.model.Employee;
import com.dewiz.restwithspringsecurity.repository.ImMemoryEmployeeRepository;
import com.dewiz.restwithspringsecurity.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Qualifier(value = "inMemoryEmployeeService")
public class InMemoryEmployeeServiceImpl implements EmployeeService {
    private final ImMemoryEmployeeRepository imMemoryEmployeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        return imMemoryEmployeeRepository.addEmployee(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return imMemoryEmployeeRepository.getAllEmployees();
    }

    @Override
    public Employee findById(Integer id) {
        return imMemoryEmployeeRepository.findById(id);
    }

    @Override
    public void updateEmployee(Employee employee) {

    }

    @Override
    public Boolean deleteById(Integer id) {
        return imMemoryEmployeeRepository.deleteById(id);
    }
}
