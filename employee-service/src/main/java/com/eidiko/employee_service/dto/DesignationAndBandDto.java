package com.eidiko.employee_service.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DesignationAndBandDto {

    private long id;
    private String designationName;
    private String band;

}
