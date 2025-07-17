package com.flutecode.project5.mapper;

import com.flutecode.project5.dto.EmployeeRequestDto;
import com.flutecode.project5.dto.EmployeeResponseDto;
import com.flutecode.project5.entity.EmployeeEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface Employeemapper {
    EmployeeResponseDto toEmployeeResponseDto(EmployeeEntity employeeEntity);
    EmployeeEntity toEmployeeEntity(EmployeeRequestDto employeeRequestDto);
}
