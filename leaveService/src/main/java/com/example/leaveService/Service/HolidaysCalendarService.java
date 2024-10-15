package com.example.leaveService.Service;

import com.example.leaveService.Dto.HolidaysCalendarDto;
import com.example.leaveService.Entites.HolidaysCalendar;
import com.example.leaveService.Repository.HolidaysCalendarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

public class HolidaysCalendarService {

        @Autowired
        HolidaysCalendarRepo holidaysCalendarRepo;


    public HolidaysCalendarDto addHolidays(@RequestBody HolidaysCalendar holidaysCalendar) {
        holidaysCalendarRepo.save(holidaysCalendar);
        return
                convertToDto(holidaysCalendar);
    }

    public List<HolidaysCalendarDto> getHolidaysCalendar() {
        List<HolidaysCalendar> getAll = holidaysCalendarRepo.findAll();
        List<HolidaysCalendarDto> dtos = new ArrayList<>();
        for (HolidaysCalendar holidaysCalendar : getAll) {
            dtos.add(convertToDto(holidaysCalendar));
        }
        return dtos;
    }

    public HolidaysCalendarDto convertToDto(HolidaysCalendar holidaysCalendar) {
        return new HolidaysCalendarDto(
                holidaysCalendar.getHolidayName(),
                holidaysCalendar.getHolidayDate()
        );
    }

}
