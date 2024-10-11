package com.eidiko.employee_service.repository;

import com.eidiko.employee_service.entity.LoginDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginDetailsRepository extends JpaRepository<LoginDetails ,Long> {
}
