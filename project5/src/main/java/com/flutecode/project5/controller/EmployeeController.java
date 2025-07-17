package com.flutecode.project5.controller;

import com.flutecode.project5.dto.EmployeeRequestDto;
import com.flutecode.project5.dto.EmployeeResponseDto;
import com.flutecode.project5.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    public ResponseEntity<EmployeeResponseDto> getEmployee(@PathVariable int id) {
        log.info("Received request to getEmployee for Employee id: {}", id);
        EmployeeResponseDto employeeResponseDto = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employeeResponseDto);
    }
   @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> addEmployee(@Valid @RequestBody EmployeeRequestDto employeeRequestDto) {
        log.info("Received request to add Employee endpoint");
        String resMsg = employeeService.addEmployee(employeeRequestDto);
        return ResponseEntity.ok(resMsg);
    }
    @RequestMapping(method = RequestMethod.PUT,value = "/{id}")
    public ResponseEntity<EmployeeResponseDto> updateEmployee(@PathVariable int id, @RequestBody EmployeeRequestDto employeeRequestDto) {
        log.info("Received request to update employee endPoint for employee roll:{}", id);
        EmployeeResponseDto employeeResponseDto = employeeService.updateEmployee(id, employeeRequestDto);
        return ResponseEntity.ok(employeeResponseDto);
    }
    @RequestMapping(method = RequestMethod.PATCH,value = "/{id}")
    public ResponseEntity<EmployeeResponseDto> partialUpdateUser(@PathVariable int id, @RequestBody Map<String, Object> fieldsToUpdate) {
        log.info("Received request partially update with id: {}", id);
        EmployeeResponseDto employeeResponseDto = employeeService.updateEmployee(id, fieldsToUpdate);
        return ResponseEntity.ok(employeeResponseDto);
    }
    @RequestMapping(method = RequestMethod.DELETE,value = "/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
        String msg = employeeService.deleteEmployeeById(id);
        return ResponseEntity.ok(msg);
    }
}
