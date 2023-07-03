package com.dewiz.restwithspringsecurity.resource;

import com.dewiz.restwithspringsecurity.model.Employee;
import com.dewiz.restwithspringsecurity.service.EmployeeService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/api/employees")
public class EmployeeResource {

    @Qualifier(value = "mySQLEmployeeService")
    private final EmployeeService employeeService;

    public EmployeeResource(@Qualifier(value = "mySQLEmployeeService") EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(employeeService.findById(id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
//        employee.setId(employeeService.getAllEmployees().size() + 1);
        return ResponseEntity.created(getLocation(employee.getId())).body(employeeService.addEmployee(employee));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(employeeService.deleteById(id));
    }

    @PutMapping
    public ResponseEntity<Boolean> updateEmployee() {
        return null;
    }


    /**
     * Return location for use in the controller ResponseEntity.created
     *
     * @param id
     */
    protected static URI getLocation(Integer id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(id).toUri();
    }
}
