package com.flutecode.project5.service;

import com.flutecode.project5.dto.EmployeeRequestDto;
import com.flutecode.project5.dto.EmployeeResponseDto;
import com.flutecode.project5.entity.EmployeeEntity;
import com.flutecode.project5.exception.EmployeeAlreadyExistsException;
import com.flutecode.project5.exception.EmployeeNotFoundException;
import com.flutecode.project5.exception.InvalidEmployeeDataException;
import com.flutecode.project5.mapper.Employeemapper;
import com.flutecode.project5.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    Employeemapper employeemapper;

    public EmployeeResponseDto getEmployeeById(int id){
        log.info("Start to fetch details for Employee id: {}",id);
        Optional<EmployeeEntity>employeeEntity=employeeRepository.findById(id);
        if(employeeEntity.isPresent()){
            log.info("Employee found with id: {}",id);
            EmployeeResponseDto employeeResponseDto=employeemapper.toEmployeeResponseDto(employeeEntity.get());
            return employeeResponseDto;
        }else{
            throw new EmployeeNotFoundException("Employee not found with id: {}"+id);
        }
    }
    @Transactional
    public String addEmployee(EmployeeRequestDto employeeRequestDto){
        log.info("Start to add a new Employee, Employee details: {}",employeeRequestDto);
        Optional<EmployeeEntity> employeeEntity=employeeRepository.findById(employeeRequestDto.getId());
        if(employeeEntity.isPresent()){
            throw new EmployeeAlreadyExistsException("Failed to add employee with roll: "+employeeRequestDto.getId()+" already exists");
        }
        EmployeeEntity employeeEntity1=employeemapper.toEmployeeEntity(employeeRequestDto);
        employeeRepository.save(employeeEntity1);
        log.info("Employee added successfully with id: {}",employeeEntity1.getId());
        return "Employee added successfully!";
    }
    @Transactional
    public EmployeeResponseDto updateEmployee(int id,EmployeeRequestDto employeeRequestDto){
        log.info("Start to update employee with id: {}",id);
        if(employeeRequestDto.getId()!=id){
            throw new InvalidEmployeeDataException("Failed to update:id in request body does not match with URI id");
        }
        EmployeeEntity employeeEntity=employeemapper.toEmployeeEntity(employeeRequestDto);
        employeeRepository.save(employeeEntity);
        log.info("employee with id:{} updated successfully",employeeEntity.getId());
        EmployeeResponseDto employeeResponseDto=employeemapper.toEmployeeResponseDto(employeeEntity);
        return employeeResponseDto;
    }
    @Transactional
    public EmployeeResponseDto updateEmployee(int id, Map<String,Object>fieldsToUpdate){
        log.info("Start to update employee with id: {}",id);
        Optional<EmployeeEntity> existingEmployeeOpt=employeeRepository.findById(id);
        if(existingEmployeeOpt.isEmpty()){
            throw new EmployeeNotFoundException("Employee not found with id: "+id);
        }
        EmployeeEntity employeeEntity=existingEmployeeOpt.get();
        if(fieldsToUpdate.containsKey("name")){
            employeeEntity.setName((String)fieldsToUpdate.get("name"));
        }
        if(fieldsToUpdate.containsKey("designation")){
            employeeEntity.setDesignation((String)fieldsToUpdate.get("designation"));
        }
        if(fieldsToUpdate.containsKey("mobile")){
            employeeEntity.setMobile(((Long) fieldsToUpdate.get("mobile")).longValue());
        }
        if(fieldsToUpdate.containsKey("salary")){
            employeeEntity.setSalary(((Double) fieldsToUpdate.get("salary")).doubleValue());
        }
        employeeRepository.save(employeeEntity);
        log.info("Employee with id: {} updated successfully",employeeEntity.getId());
        EmployeeResponseDto employeeResponseDto=employeemapper.toEmployeeResponseDto(employeeEntity);
        return employeeResponseDto;
    }
    @Transactional
    public String deleteEmployeeById(int id){
        log.info("Start to delete employee with id: {}",id);
        Optional<EmployeeEntity> employeeEntity=employeeRepository.findById(id);
        if(employeeEntity.isEmpty()){
            throw new EmployeeNotFoundException("employee not found with id: {}"+id);
        }
        employeeRepository.deleteById(id);
        log.info("employee with id:{} deleted successfully",id);
        return "employee deleted successfully";
    }





}
