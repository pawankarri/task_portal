package com.eidiko.employee_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class EmpProfilePic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String path;

    @OneToOne
    @JoinColumn(name = "emp_id", referencedColumnName = "empId")
    private Employee employee;

}
