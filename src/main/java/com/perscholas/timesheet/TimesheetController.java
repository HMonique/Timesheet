package com.perscholas.timesheet;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimesheetController {


    @GetMapping("/")
    public String home() {
        return "Welcome to the Timesheet Application";
    }
}
