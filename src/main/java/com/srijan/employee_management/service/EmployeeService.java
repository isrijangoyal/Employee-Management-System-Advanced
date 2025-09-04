package com.srijan.employee_management.service;

import com.srijan.employee_management.entity.Employee;
import com.srijan.employee_management.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import com.srijan.employee_management.exception.EmployeeNotFoundException;

import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public Employee create(Employee e) {
        return repo.save(e);
    }

    public List<Employee> createEmployees(List<Employee> employees) {
        return repo.saveAll(employees);
    }

    public List<Employee> getAll() {
        return repo.findAll();
    }

    public Employee getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
    }

    public Employee update(Long id, Employee updated) {
        Employee existing = getById(id);
        existing.setFirstName(updated.getFirstName());
        existing.setLastName(updated.getLastName());
        existing.setEmail(updated.getEmail());
        existing.setRole(updated.getRole());
        existing.setSalary(updated.getSalary());
        existing.setDepartment(updated.getDepartment());
        return repo.save(existing);
    }

    // PARTIALLY UPDATE THE LIST
//    public Employee updatePartial(Long id, Map<String, Object> updates) {
//        Employee emp = repository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Employee not found"));
//
//        updates.forEach((key, value) -> {
//            switch (key) {
//                case "name" -> emp.setName((String) value);
//                case "email" -> emp.setEmail((String) value);
//                case "salary" -> emp.setSalary(((Number) value).doubleValue());
//            }
//        });
//
//        return repository.save(emp);
//    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}

