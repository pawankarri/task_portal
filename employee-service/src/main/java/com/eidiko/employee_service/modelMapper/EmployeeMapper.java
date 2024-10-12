package com.eidiko.employee_service.modelMapper;

import com.eidiko.employee_service.dto.EmployeeDto;
import com.eidiko.employee_service.entity.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    @Autowired
    private ModelMapper modelMapper;

    public  EmployeeDto employeeToEmployeeDto(Employee employee){
        return modelMapper.map(employee , EmployeeDto.class);
    }

    public Employee employeeDtoToEmployee(EmployeeDto employeeDto){
        return modelMapper.map(employeeDto , Employee.class);
    }
}
