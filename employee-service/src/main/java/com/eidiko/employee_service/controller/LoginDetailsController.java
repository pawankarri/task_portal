package com.eidiko.employee_service.controller;

import com.eidiko.employee_service.entity.LoginDetails;
import com.eidiko.employee_service.repository.LoginDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/loginDetails")
public class LoginDetailsController {
    @Autowired
    private LoginDetailsRepository loginDetailsRepository;
    @GetMapping("/{id}")
    public LoginDetails getLoginDetailsById(@PathVariable long id){
       return loginDetailsRepository.findById(id).get();
    }
}
