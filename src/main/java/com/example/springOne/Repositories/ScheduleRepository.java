// RestaurantTableRepository.java
package com.example.springOne.Repositories;

import com.example.springOne.Entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;


public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    List<Schedule> findByTableId(int tableId);
    @Query("SELECT s FROM Schedule s WHERE s.table.Id = :tableId AND s.StartTime < :end AND s.EndTime > :start")
    List<Schedule> findOverlapping(@Param("tableId") int tableId, @Param("start") Date start, @Param("end") Date end);
}
