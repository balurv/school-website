package com.eazybytes.eazyschool.controller;

import com.eazybytes.eazyschool.model.Holiday;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HolidayController {
    @GetMapping("/holidays")
    public String displayHolidays(@RequestParam(required = false)boolean festival,
                                  @RequestParam(required = false)boolean federal,Model model){
        model.addAttribute("festival", festival);
        model.addAttribute("federal", federal);
        List<Holiday> holidayList = Arrays.asList(
                new Holiday("jan 1", "New year", Holiday.Type.FESTIVAL),
                new Holiday("jan 14", "Sankranthi", Holiday.Type.FESTIVAL),
                new Holiday("jan 26", "Republic Day", Holiday.Type.FEDERAL),
                new Holiday("mar 6", "Ugadi", Holiday.Type.FESTIVAL),
                new Holiday("May 1", "Labour day", Holiday.Type.FEDERAL),
                new Holiday("Aug 15", "Independence day", Holiday.Type.FEDERAL),
                new Holiday("Oct 5", "Dussera", Holiday.Type.FESTIVAL),
                new Holiday("nov 18", "Deepavali", Holiday.Type.FESTIVAL)
        );
        Holiday.Type[] types = Holiday.Type.values();
        for (Holiday.Type type: types
             ) {
            model.addAttribute(type.toString(),
                    (holidayList.stream().filter(holiday -> holiday.getType().equals(type)).collect(Collectors.toList())));
            
        }
        return "holidays.html";
    }
}
