package com.perscholas.timesheet.common;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class TimeSheetRepository {

    private final List<Timesheet> timesheets = new ArrayList<>();

    @PostConstruct
    private void init(){
        System.out.println("Timesheet Repository is created");
        Timesheet timesheet1 = new Timesheet(
                1,"August 19th",
                LocalDateTime.now(), LocalDateTime.now().plus(8, ChronoUnit.HOURS),
                8, Location.OFFICE, 30.0
        );
        Timesheet timesheet2 = new Timesheet(
                2,"August 20th",
                LocalDateTime.now(), LocalDateTime.now().plus(8, ChronoUnit.HOURS),
                8, Location.OFFICE, 30.0
        );
        Timesheet timesheet3 = new Timesheet(
                3,"August 21st",
                LocalDateTime.now(), LocalDateTime.now().plus(8, ChronoUnit.HOURS),
                8, Location.OFFICE, 30.0
        );

        timesheets.add(timesheet1);
        timesheets.add(timesheet2);
        timesheets.add(timesheet3);

        System.out.println(" Finished creating timesheets");
    }
    public List<Timesheet> findAll(){
        return timesheets;
    }
    public Optional<Timesheet> find
    public void create(Timesheet timesheet){
        timesheets.add(timesheet);
    }

    public void update(Timesheet timesheet, Integer id){
        Optional<Timesheet> existingTimesheet = findByID(id);
        if(existingTimesheet.isPresent()){
            timesheets.remove(existingTimesheet.get()), timesheet);
        }
    }

    public void
}
