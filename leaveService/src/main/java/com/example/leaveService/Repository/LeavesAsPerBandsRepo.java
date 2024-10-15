package com.example.leaveService.Repository;

import com.example.leaveService.Dto.LeavesAsPerBandsDto;
import com.example.leaveService.Entites.LeavesAsPerBands;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeavesAsPerBandsRepo extends JpaRepository<LeavesAsPerBands,Integer> {

    LeavesAsPerBands findByBandId(long bandId);
}
