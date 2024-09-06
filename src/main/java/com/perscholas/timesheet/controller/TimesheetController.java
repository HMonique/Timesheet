package com.perscholas.timesheet.controller;

import com.perscholas.timesheet.common.Location;
import com.perscholas.timesheet.common.Timesheet;
import com.perscholas.timesheet.common.TimesheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/timesheets")
@RestController
public class TimesheetController {

    private final TimesheetRepository timesheetRepository;

    @Autowired
    public TimesheetController(TimesheetRepository timesheetRepo) {
        timesheetRepository = timesheetRepo;
    }

    // getting all of our timesheets
    @GetMapping("")
    public List<Timesheet> home(){

        return timesheetRepository.findAll();
    }

    // Post a Timesheet
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void CreateTimesheet(@RequestBody Timesheet timesheet){
        timesheetRepository.create(timesheet);

    }
    //
//    // Get Item by id
    @GetMapping("/{id}")
    Timesheet getTimesheetByID(@PathVariable Integer id){

        Optional<Timesheet> timesheet = timesheetRepository.findByID(id);

        if(timesheet.isEmpty()){
            throw new RuntimeException();
        }

        return timesheet.get();

    }
    //
//    @GetMapping("/locations/{location}")
//    List<Timesheet> getTimesheetByLocation(@PathVariable String location){
//        return timesheetRepository.findByLocation(location);
//    }
//
    // Put a Timesheet
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void updateTimesheet(@RequestBody Timesheet timesheet,
                         @PathVariable Integer id){

        timesheetRepository.update(timesheet,id);
    }
    //
//
//    // Delete a Timesheet
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void deleteTimesheet(@PathVariable Integer id){

        timesheetRepository.delete(id);
    }
}