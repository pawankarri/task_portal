package com.eidiko.employee_service.controller;

import com.eidiko.employee_service.entity.Employee;
import com.eidiko.employee_service.jwt.AuthRequest;
import com.eidiko.employee_service.jwt.JwtResponse;
import com.eidiko.employee_service.jwt.JwtUtils;
import com.eidiko.employee_service.modelMapper.EmployeeMapper;
import com.eidiko.employee_service.repository.EmployeeRepository;
import com.eidiko.employee_service.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
@Slf4j
public class AuthController {

    private EmployeeRepository employeeRepository;
    private EmployeeService employeeService;
    private JwtUtils jwtUtils;
    private EmployeeMapper employeeMapper;
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) throws Exception {
        log.info("auth request: {}", authRequest);
        this.authenticate(authRequest.getEmailId(), authRequest.getPassword());
        UserDetails userDetails = employeeService.loadUserByUsername(authRequest.getEmailId());
        String token = jwtUtils.generateToken(userDetails.getUsername());
        Employee employee = employeeRepository.findByEmailId(userDetails.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Employee not available"));

        return ResponseEntity.ok().body(
                new JwtResponse(token, employeeMapper.employeeToEmployeeDto(employee))
        );
    }

    private void authenticate(String username,String password) throws Exception {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(username,password);
        try {
            this.authenticationManager.authenticate(authenticationToken);
        } catch (DisabledException e) {
            throw new DisabledException("user is disabled");
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("bad credentials");
        }
    }

}
