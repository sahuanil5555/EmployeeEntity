package com.flutecode.project5.repository;

import com.flutecode.project5.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Integer> {
}
