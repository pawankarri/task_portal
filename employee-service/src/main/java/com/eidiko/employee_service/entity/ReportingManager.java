package com.eidiko.employee_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "reportingManager")
public class ReportingManager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate startDate;

    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "emp_id", referencedColumnName = "empId")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "manager_id", referencedColumnName = "empId")
    private Employee manager;
}
