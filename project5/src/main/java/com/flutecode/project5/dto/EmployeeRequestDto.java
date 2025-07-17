package com.flutecode.project5.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class EmployeeRequestDto {
    @NotNull(message = "Id is required")

    private Integer id;
    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;
    @NotEmpty(message = "Designation cannot be empty")
    private String designation;
    @Positive(message = "Mobile number must be positive")
    private Long mobile;
    @Digits(integer = 9, fraction = 2, message = "Salary must be a valid number with up to 2 decimals places and a maximum of 9 digits")
    private Double salary;

    @Min(5)
    @Max(15)
    Integer experience;
    @Email(message = "email must be valid")
    String email;
    @FutureOrPresent(message = "date of joining must be present or future")
    LocalDate dateOfJoining;

    @Past(message = "date of Birth must be in the past")
    LocalDate dateOfBirth;

}
