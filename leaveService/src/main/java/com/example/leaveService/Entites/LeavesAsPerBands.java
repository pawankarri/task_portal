package com.example.leaveService.Entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeavesAsPerBands  {



    @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer leavesAsPerBandId;

    private long bandId;
    private int noOfLeaves;
    private String designation;


}
