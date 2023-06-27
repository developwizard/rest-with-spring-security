package com.dewiz.restwithspringsecurity.service.impl;

import com.dewiz.restwithspringsecurity.ImMemoryEmployeeRepository;
import com.dewiz.restwithspringsecurity.model.Employee;
import com.dewiz.restwithspringsecurity.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class InMemoryEmployeeServiceImpl implements EmployeeService {
    private final ImMemoryEmployeeRepository imMemoryEmployeeRepository;

    @Override
    public void addEmployee(Employee employee) {
        imMemoryEmployeeRepository.addEmployee(employee);
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
