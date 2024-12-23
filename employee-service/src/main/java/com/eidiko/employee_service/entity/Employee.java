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

    @NotBlank(message = "Password is required")
//    @Size(min = 8, max = 50, message = "Password must be between 8 and 50 characters")
    private String password;

    @NotBlank(message = "Contact number is mandatory")
    @Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Invalid phone number")
    private String phoneNumber;

    @Temporal(TemporalType.DATE)
    @NotNull(message = "Date of joining is required")
    private LocalDate dateOfJoining;

    // @NotNull(message = "isResigned flag is required")
    private boolean resigned = false;

    @Size(max = 500, message = "About section must be less than 500 characters")
    private String about;

    @Column(name = "profile_pic")
    @Lob
    private String empProfilePicPath;

//    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Role> empRoles;

    private Long manager;

}
