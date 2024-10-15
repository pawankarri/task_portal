package com.example.leaveService.Service;
import com.example.leaveService.Dto.Employees;
import com.example.leaveService.Dto.EmployeesDto;
import com.example.leaveService.Dto.LeavesAsPerBandsDto;
import com.example.leaveService.Entites.LeavesAsPerBands;
import com.example.leaveService.Repository.LeavesAsPerBandsRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;

public class LeavesAsPerBandsService {


    @Autowired
    LeavesAsPerBandsRepo leavesAsPerBandsRepo;

//    @Autowired
//    WebClient.Builder builder;

    @Autowired
   private WebClient webClient;


    public EmployeesDto getLeavesAsPerBands() throws IOException {
        String response = webClient.get()
                .uri("http://localhost:8090/api/v2/getByName/TARUN")
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJTVURIRUVSIiwiaWF0IjoxNzI4Njc2OTU2LCJleHAiOjI0ODkyOTQ4MTY4OTc3NjB9.FNRxf_sTisJLO1slYpjGhuqm11CW1be-eYZ2EE8qziA")
                .exchange()
                .flatMap(clientResponse -> {
                    if (clientResponse.statusCode().is5xxServerError()) {
                        clientResponse.body((clientHttpResponse, context) ->
                        {
                            return clientHttpResponse.getBody();
                        });
                        return clientResponse.bodyToMono(String.class);
                    } else {
                        return clientResponse.bodyToMono(String.class);
                    }
                }).block();
        ObjectMapper objectMapper = new ObjectMapper();
        Employees employees = objectMapper.readValue(response, Employees.class);
        EmployeesDto dto = employeesDto(employees);
        System.out.println(dto);
        return dto;
    }

    public EmployeesDto employeesDto(Employees employees) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(employees, EmployeesDto.class);
    }


    public LeavesAsPerBandsDto convertToDto(LeavesAsPerBands leavesAsPerBands) {
        return
                new LeavesAsPerBandsDto(
                        leavesAsPerBands.getBandId(),
                        leavesAsPerBands.getNoOfLeaves(),
                        leavesAsPerBands.getDesignation()
                );
    }

//    public LeavesAsPerBands convertToEntity(LeavesAsPerBandsDto leaves)
//    {
//        LeavesAsPerBands entity = new LeavesAsPerBands();
//        entity.setLeavesAsPerBandId(leaves.getLeavesAsPerBandId());
//        entity.setBandId(leaves.getBandId());
//        entity.setNoOfLeaves(leaves.getNoOfLeaves());
//        return entity;
//    }

}
