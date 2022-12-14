package com.eazybytes.eazyschool.controller;

import com.eazybytes.eazyschool.model.Holiday;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HolidayController {
    @GetMapping("/holidays/{display}")
    public String displayHolidays(@PathVariable String display, Model model){
        if(null != display && display.equals("all")){
            model.addAttribute("festival", true);
            model.addAttribute("federal", true);
        }
        else if(null != display && display.equals("festival")){
            model.addAttribute("festival", true);
        }
        else if(null != display && display.equals("federal")){
            model.addAttribute("federal",true);
        }
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
