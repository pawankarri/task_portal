package com.example.leaveService.Configuration;

import com.example.leaveService.Service.HolidaysCalendarService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HolidaysCalendarConfiguration {
    @Bean
    public HolidaysCalendarService holidaysCalendarService()
    {
        return new HolidaysCalendarService();
    }
}
