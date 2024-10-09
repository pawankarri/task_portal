package com.eidiko.employee_service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;

    @NotBlank(message = "Employee name is mandatory")
    @Size(min = 3, max = 100, message = "Employee name must be between 3 and 100 characters")
    private String empName;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is mandatory")
    @Column(unique = true, nullable = false)
    private String emailId;

    @Temporal(TemporalType.DATE)
    @NotNull(message = "Date of joining is required")
    private Date dateOfJoining;

    private Timestamp modifiedDate;

    @NotBlank(message = "Contact number is mandatory")
    @Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Invalid contact number")
    private String contactNo;

    @NotNull(message = "Created by is required")
    private Long createdBy;

    @NotNull(message = "isDeleted flag is required")
    private Boolean isDeleted;

    @NotBlank(message = "Status is required")
    private String status;

    @Size(max = 500, message = "About section must be less than 500 characters")
    private String about;

    @Temporal(TemporalType.DATE)
    @NotNull(message = "Date of birth is required")
    private Date dateOfBirth;

    @Transient
    private String designation;

    // One-to-Many Relationship with EmpRoleMapping
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<EmpRoleMapping> empRoles;

    // One-to-One Relationship with LoginDetails
    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private LoginDetails loginDetails;

    // One-to-Many Relationship with ReportingManager (for employees managed by this employee)
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ReportingManager> reportingManagerForEmployee;

    // One-to-Many Relationship with ReportingManager (for managers managing this employee)
    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ReportingManager> reportingManagerForManager;

    // One-to-Many Relationship with EmpShiftTimings
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<EmpShiftTimings> empShiftTimings;

    // One-to-One Relationship with EmpProfilePic
    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private EmpProfilePic empProfilePic;

    // One-to-Many Relationship with EmployeeBandDesgMapping
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<EmployeeBandDesgMapping> bandDesgMappings;


}
