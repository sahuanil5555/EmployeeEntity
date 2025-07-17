package com.flutecode.project5.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="employee")

public class EmployeeEntity {
    @Id
    @Column(name="emp_id")
    private Integer id;
    @Column(name="emp_name")
    private String name;
    @Column(name="emp_designation")
    private String designation;
    @Column(name="emp_mobile")
    private Long mobile;
    @Column(name="emp_salary")
    private Double salary;

}
