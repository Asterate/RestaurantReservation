package com.example.springOne.Entities;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "schedule", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"table_id", "start_time"})
})
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int Id;
    public String ScheduleName;
    public Date StartTime;
    public Date EndTime;
    @Enumerated(EnumType.STRING)
    public EScheduleStatus ScheduleStatus = EScheduleStatus.Ongoing;

    @ManyToOne
    @JoinColumn(name = "table_id")
    private RestaurantTable table;

    @ManyToOne
    @JoinColumn(name = "guest_id")
    private Guest guest;

    public Schedule(){}

    public Schedule(EScheduleStatus scheduleStatus) {
        this.ScheduleStatus = scheduleStatus;
    }

    public int getId() { return Id; }
    public void setId(int id) { this.Id = id; }

    public String getScheduleName() { return ScheduleName; }
    public void setScheduleName(String scheduleName) { this.ScheduleName = scheduleName; }

    public Date getStartTime() { return StartTime; }
    public void setStartTime(Date startTime) { this.StartTime = startTime; }

    public Date getEndTime() { return EndTime; }
    public void setEndTime(Date endTime) { this.EndTime = endTime; }

    public EScheduleStatus getScheduleStatus() {return ScheduleStatus;}
    public void setScheduleStatus(EScheduleStatus status) {this.ScheduleStatus = status;}

    public RestaurantTable getTable() { return table; }
    public void setTable(RestaurantTable table) { this.table = table; }
}
