package com.springboot.crud.controller;

import com.springboot.crud.entity.Employee;
import com.springboot.crud.exception.ResourceNotFoundException;
import com.springboot.crud.repository.EmpOracleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/emp")
public class EmployeeController {

    private final EmpOracleRepository empOracleRepository;

    @Autowired
    EmployeeController(EmpOracleRepository empOracleRepository) {
        this.empOracleRepository = empOracleRepository;
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        Iterable<Employee> it = this.empOracleRepository.findAll();
        List<Employee> list = new ArrayList<>();
                it.forEach(list::add);
        return list;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmpById(@PathVariable(value = "id") int empId) {
        Employee employee = this.empOracleRepository.findById(empId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id :" + empId));
        return ResponseEntity.ok().body(employee);
    }

    @PostMapping("/createEmp")
    public Employee createEmployee(@RequestBody Employee employee) {
        return this.empOracleRepository.save(employee);

    }

    @PutMapping("{id}")
    public ResponseEntity < Employee > updateEmployee(@PathVariable(value = "id") int employeeId,
                                                       @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
        Employee employee = empOracleRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
        employee.setComments(employeeDetails.getComments());
        employee.setEmail(employeeDetails.getEmail());
        employee.setEname(employeeDetails.getEname());
        employee.setDoj(employeeDetails.getDoj());
        final Employee updatedEmployee = empOracleRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/{id}")
    public Map< String, Boolean > deleteEmployee(@PathVariable(value = "id") int employeeId)
            throws ResourceNotFoundException {
        Employee employee = empOracleRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

        empOracleRepository.delete(employee);
        Map < String, Boolean > response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


}
