package com.srijan.employee_management.controller;

import com.srijan.employee_management.entity.Employee;
import com.srijan.employee_management.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    // Add an employee
    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee e) {
        return ResponseEntity.ok(service.create(e));
    }

    // Add employees in bulk
    @PostMapping("/bulk")
    public ResponseEntity<List<Employee>> createEmployees(@RequestBody List<@Valid Employee> employees) {
        return ResponseEntity.ok(service.createEmployees(employees));
    }

    // Read all
    @GetMapping
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    // Read one
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable Long id, @RequestBody Employee e) {
        return ResponseEntity.ok(service.update(id, e));
    }

    // Partial update employee
//    @PatchMapping("/{id}")
//    public ResponseEntity<Employee> updatePartial(
//            @PathVariable Long id,
//            @RequestBody Map<String, Object> updates) {
//        return ResponseEntity.ok(service.updatePartial(id, updates));
//    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
