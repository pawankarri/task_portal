package com.eidiko.employee_service.dto;
import com.eidiko.employee_service.entity.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDto {

    private long empId;
    private String empName;
    private String emailId;
    private String phoneNumber;
    private LocalDate dateOfJoining;
    private boolean resigned;
    private String about;
    private String empProfilePicPath;
    private List<RoleDto> empRoles;
    private Long manager;

}

