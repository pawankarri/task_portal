package com.example.leaveService.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeavesAsPerBandsDto implements Serializable {

    private long bandId;
    private int noOfLeaves;
    private String designation;

}
