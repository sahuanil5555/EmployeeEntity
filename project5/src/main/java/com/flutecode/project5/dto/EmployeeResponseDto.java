package com.flutecode.project5.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponseDto {
    private Integer id;
    private String name;
    private String designation;
    private Long mobile;
    private Double salary;
}
