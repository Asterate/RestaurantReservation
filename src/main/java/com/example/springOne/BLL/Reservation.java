package com.example.springOne.BLL;

import com.example.springOne.Entities.RestaurantTable;
import com.example.springOne.Entities.Schedule;
import com.example.springOne.Repositories.RestaurantTableRepository;
import com.example.springOne.Repositories.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Date;
import java.util.List;

@Service
public class Reservation {
    @Autowired
    private ScheduleRepository scheduleRepository;
    @Autowired
    private RestaurantTableRepository restaurantTableRepository;

    public Schedule MakeNewSchedule(String startTime, String endTime, int peopleCount){
        if (startTime == null) throw new RuntimeException("Start time is missing");
        if (endTime == null) throw new RuntimeException("End time is missing");
        if (peopleCount < 1) throw new RuntimeException("No people");

        Date start = java.sql.Timestamp.valueOf(startTime.replace("T", " ") + ":00");
        Date end = java.sql.Timestamp.valueOf(endTime.replace("T", " ") + ":00");

        if (start.getTime() > end.getTime()) {
            throw new RuntimeException("Start time cannot be after end time");
        }

        Schedule schedule = new Schedule();
        schedule.setStartTime(start);
        schedule.setEndTime(end);
        schedule.setScheduleName("Reservation for " + peopleCount + " people");

        return scheduleRepository.save(schedule);
    }
    public Schedule AssignTable(int scheduleId, int tableId) {
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new RuntimeException("Schedule not found"));

        OverlappingCheck(tableId, schedule.getStartTime(), schedule.getEndTime());

        RestaurantTable table = restaurantTableRepository.findById(tableId)
                .orElseThrow(() -> new RuntimeException("Table not found"));

        schedule.setTable(table);
        return scheduleRepository.save(schedule);
    }
    public void OverlappingCheck(int tableId, Date start, Date end) {
        List<Schedule> overlapping = scheduleRepository.findOverlapping(tableId, start, end);
        if (!overlapping.isEmpty()) {
            throw new RuntimeException("Table is already booked for this time");
        }
    }
    public RestaurantTable FindTable(int tableId) {
        return restaurantTableRepository.findById(tableId)
                .orElseThrow(() -> new RuntimeException("Table not found"));
    }

    public List<Schedule> FindTableSchedules(int tableId) {
        return scheduleRepository.findByTableId(tableId);
    }
}
