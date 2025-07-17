package com.flutecode.project5.mapper;

import com.flutecode.project5.dto.EmployeeRequestDto;
import com.flutecode.project5.dto.EmployeeResponseDto;
import com.flutecode.project5.entity.EmployeeEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-04T21:22:23+0530",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.7 (Microsoft)"
)
@Component
public class EmployeemapperImpl implements Employeemapper {

    @Override
    public EmployeeResponseDto toEmployeeResponseDto(EmployeeEntity employeeEntity) {
        if ( employeeEntity == null ) {
            return null;
        }

        EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();

        employeeResponseDto.setId( employeeEntity.getId() );
        employeeResponseDto.setName( employeeEntity.getName() );
        employeeResponseDto.setDesignation( employeeEntity.getDesignation() );
        employeeResponseDto.setMobile( employeeEntity.getMobile() );
        employeeResponseDto.setSalary( employeeEntity.getSalary() );

        return employeeResponseDto;
    }

    @Override
    public EmployeeEntity toEmployeeEntity(EmployeeRequestDto employeeRequestDto) {
        if ( employeeRequestDto == null ) {
            return null;
        }

        EmployeeEntity employeeEntity = new EmployeeEntity();

        employeeEntity.setId( employeeRequestDto.getId() );
        employeeEntity.setName( employeeRequestDto.getName() );
        employeeEntity.setDesignation( employeeRequestDto.getDesignation() );
        employeeEntity.setMobile( employeeRequestDto.getMobile() );
        employeeEntity.setSalary( employeeRequestDto.getSalary() );

        return employeeEntity;
    }
}
