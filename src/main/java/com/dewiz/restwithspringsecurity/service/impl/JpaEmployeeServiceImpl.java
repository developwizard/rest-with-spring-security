package com.dewiz.restwithspringsecurity.service.impl;

import com.dewiz.restwithspringsecurity.model.Employee;
import com.dewiz.restwithspringsecurity.repository.JpaEmployeeRepository;
import com.dewiz.restwithspringsecurity.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier(value = "mySQLEmployeeService")
public class JpaEmployeeServiceImpl implements EmployeeService {
    private final JpaEmployeeRepository jpaEmployeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        return jpaEmployeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return jpaEmployeeRepository.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        return jpaEmployeeRepository.findById(id).get();
    }

    @Override
    public void updateEmployee(Employee employee) {

    }

    @Override
    public Boolean deleteById(Integer id) {
        jpaEmployeeRepository.deleteById(id);
        return  Boolean.TRUE;
    }
}
