package com.perscholas.timesheet.controller;

import com.perscholas.timesheet.common.TimeSheetRepository;
import com.perscholas.timesheet.common.Timesheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/api/timesheets")
@RestController
public class TimesheetController {

    private final TimeSheetRepository timeSheetRepository;

    @Autowired
    public TimesheetController(TimeSheetRepository timesheetRepo) {
        timeSheetRepository= timesheetRepo;
    }

    //  getting all of our timesheets
    @GetMapping("")
    public List<Timesheet> home(){

        return timeSheetRepository.findAll();
    }

    //    Post a Timesheet
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
   void CreateTimesheet(@RequestBody Timesheet timesheet){
        timeSheetRepository.create(timesheet);

    }

    //Get Item by id
    @GetMapping("/{id}")
    Timesheet getTimesheetByID(@PathVariable Integer id) {
        Optional<Timesheet> timesheet = timeSheetRepository.findByID(id);

        if(timesheet.isEmpty()){
            throw new RuntimeException();

        }
        return timesheet.get();
    }

    //Put a Timesheet@
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void updateTimesheet(@RequestBody Timesheet timesheet,
                         @PathVariable Integer id){

        timeSheetRepository.update(timesheet,id);
    }
    //Delete a Timesheet
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void deleteTimesheet(@PathVariable Integer id){

    }
}
