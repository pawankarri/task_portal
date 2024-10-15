package com.example.leaveService.Controller;
import com.example.leaveService.Dto.Employees;
import com.example.leaveService.Dto.EmployeesDto;
import com.example.leaveService.Service.LeavesAsPerBandsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;

@RestController
public class LeavesAsPerBandsController {


    @Autowired
    LeavesAsPerBandsService service;


//    @GetMapping("/getLeavesAsPerBands/{bandId}")
//    public ResponseEntity<LeavesAsPerBandsDto> leavesPerBand(@PathVariable long bandId)
//    {
//        LeavesAsPerBandsDto dto=service.getLeavesAsPerBands(bandId);
//        return
//                ResponseEntity.ok(dto);
//    }


    @GetMapping("/getAll")
    public EmployeesDto leavesAsPerBands() throws IOException {
        return
                service.getLeavesAsPerBands();
    }

}
