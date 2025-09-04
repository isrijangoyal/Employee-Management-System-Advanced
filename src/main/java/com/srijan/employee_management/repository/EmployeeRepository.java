package com.srijan.employee_management.repository;

import com.srijan.employee_management.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Extra query methods can go here later (e.g., findByDepartment)
}

