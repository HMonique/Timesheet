package com.perscholas.timesheet.common;
import jakarta.annotation.PostConstruct;
import org.springframework.jdbc.core.simple.JdbcClient;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;


import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TimesheetRepository {


    private final JdbcClient jdbcClient;

    public TimesheetRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }
    public List<Timesheet> findAll() {
        return jdbcClient.sql("SELECT * FROM Timsheet").query(Timesheet.class).list();
    }
    public void create(Timsheet timesheet){
        jdbcClient.sql("INSERT INTO timesheet (id, name, punchInTime, punchOutTime, hoursWorked, location, payRate) VALUES (?, ?, ?, ?, ?, ?, ?)")
                .params(timesheet.id())
                .params(timesheet.name())
                .params(timesheet.punchInTime())
                .params(timesheet.punchOutTime())
                .params(timesheet.hoursWorked())
                .params(timesheet.location().name())
                .params(timesheet.payRate())
                .update();
    }
    public void update(Timesheet timesheet, Integer id){
        jdbcClient.sql("UPDATE timesheet SET name = :name," + "punchInTime = :punchInTime, punchOutTime = :punchOutTime, hoursWorked" +
                "= :hoursWorked, location = :location, payRate = :payRate WHERE id = :id")
                .param("id", id)
                .param("name", timesheet.name())
                .param("punchInTime", timesheet.punchInTime())
                .param("punchOutTime", timesheet.punchOutTime())
                .param("hoursWorked", timesheet.hoursWorked())
                .param("location", timesheet.location().name())
                .param("payRate", timesheet.payRate())
                .update();
    }
    public void delete(Integer id){
        jdbcClient.sql("DELETE FROM timesheet WHERE id = :id")
                .param("id", id)
                .update();
    }
    public Optional<Timesheet> findByID(Integer id){
        return jdbcClient.sql("SELECT * FROM timehseet WHERE id = : id")
                .param("id", id)
                .query(Timesheet.class)
                .optional();
    }
}


//private final List<Timesheet> timesheets = new ArrayList<>();
//
//@PostConstruct
//private void init(){
//    System.out.println("Timesheet Repository is created");
//    Timesheet timesheet1 = new Timesheet(
//            1,"August 19th",
//            LocalDateTime.now(), LocalDateTime.now().plus(8, ChronoUnit.HOURS),
//            8, Location.OFFICE, 30.0
//    );
//    Timesheet timesheet2 = new Timesheet(
//            2,"August 20th",
//            LocalDateTime.now(), LocalDateTime.now().plus(8, ChronoUnit.HOURS),
//            8, Location.OFFICE, 30.0
//    );
//    Timesheet timesheet3 = new Timesheet(
//            3,"August 21th",
//            LocalDateTime.now(), LocalDateTime.now().plus(8, ChronoUnit.HOURS),
//            8, Location.REMOTE, 30.0
//    );
//    timesheets.add(timesheet1);
//    timesheets.add(timesheet2);
//    timesheets.add(timesheet3);
//
//    System.out.println(" Finished creating timesheets");
//}
//
//public List<Timesheet> findAll(){
//    return timesheets;
//}
//public Optional<Timesheet> findByID(Integer id){
//    return timesheets.stream().filter(timesheet -> timesheet.id().equals(id))
//            .findFirst();
//}
////    public List<Timesheet> findByLocation(Location location) {
////        return timesheets.stream()
////                .filter(timesheet -> timesheet.location() == location)
////                .collect(Collectors.toList());
////    }
//public List<Timesheet> findByLocation(String location) {
//    String locationStr = location.toLowerCase();
//    return timesheets.stream()
//            .filter(timesheet -> timesheet.location().name().toLowerCase().equals(locationStr))
//            .collect(Collectors.toList());
//}
//public void create(Timesheet timesheet){
//    timesheets.add(timesheet);
//}
//
//public void update(Timesheet timesheet, Integer id){
//    Optional<Timesheet> existingTimesheet = findByID(id);
//    if(existingTimesheet.isPresent()){
//        timesheets.set(timesheets.indexOf(existingTimesheet.get()), timesheet);
//    }
//}
//
//public void delete(Integer id){
//    Optional<Timesheet> existingTimesheet = findByID(id);
//    if(existingTimesheet.isPresent()){
//        timesheets.remove(existingTimesheet.get());
//    }
//}