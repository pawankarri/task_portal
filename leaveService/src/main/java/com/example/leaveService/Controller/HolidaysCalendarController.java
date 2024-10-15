package com.example.leaveService.Controller;

import com.example.leaveService.Dto.HolidaysCalendarDto;
import com.example.leaveService.Entites.HolidaysCalendar;
import com.example.leaveService.Service.HolidaysCalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HolidaysCalendarController {

    @Autowired(required = true)
    HolidaysCalendarService holidaysCalendarService;

    @PostMapping("/addHolidays")
    public ResponseEntity<HolidaysCalendarDto> addHolidays(@RequestBody HolidaysCalendar holidaysCalendar)
    {
        return ResponseEntity.ok(holidaysCalendarService.addHolidays(holidaysCalendar));
    }

    @GetMapping("/getAllHolidays")
    public ResponseEntity<List<HolidaysCalendarDto>> getAllHolidays()
    {
        return ResponseEntity.ok(holidaysCalendarService.getHolidaysCalendar());
    }
}
