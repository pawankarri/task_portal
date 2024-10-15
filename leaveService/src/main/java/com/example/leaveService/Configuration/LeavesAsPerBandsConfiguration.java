package com.example.leaveService.Configuration;

import com.example.leaveService.Entites.LeavesAsPerBands;
import com.example.leaveService.Service.LeavesAsPerBandsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LeavesAsPerBandsConfiguration {

    @Bean
    public LeavesAsPerBandsService leaves()
    {
        return new LeavesAsPerBandsService();
    }
}
