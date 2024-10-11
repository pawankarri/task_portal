package com.eidiko.employee_service.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long empId;

    @NotBlank(message = "Employee name is mandatory")
    @Size(min = 3, max = 100, message = "Employee name must be between 3 and 100 characters")
    private String empName;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is mandatory")
    @Column(unique = true, nullable = false)
    private String emailId;

    @NotBlank(message = "Contact number is mandatory")
    @Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Invalid phone number")
    private String phoneNumber;

    @Temporal(TemporalType.DATE)
    @NotNull(message = "Date of joining is required")
    private LocalDate dateOfJoining;

   // @NotNull(message = "isResigned flag is required")
    private boolean isResigned = false;

    @Size(max = 500, message = "About section must be less than 500 characters")
    private String about;

    // One-to-One Relationship with LoginDetails
    @OneToOne(mappedBy = "employee",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private LoginDetails loginDetails;

    @JsonIgnore
    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Role> empRoles;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private DesignationAndBand designation;

    // One-to-One Relationship with EmpProfilePic
    @JsonIgnore
    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private EmpProfilePic empProfilePic;

    // One-to-Many Relationship with ReportingManager (for employees managed by this employee)@JsonIgnore
    @JsonIgnore
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ReportingManager> reportingManagerForEmployee;

    @JsonIgnore
    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ReportingManager> reportingManagerForManager;
    }
