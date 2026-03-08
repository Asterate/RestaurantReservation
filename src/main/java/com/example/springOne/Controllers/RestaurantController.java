package com.example.springOne.Controllers;
import com.example.springOne.BLL.Reservation;
import com.example.springOne.Entities.RestaurantTable;
import com.example.springOne.Repositories.RestaurantTableRepository;
import com.example.springOne.Repositories.RestaurantTableTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.springOne.Entities.Schedule;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;


@Controller
public class RestaurantController {
    @Autowired
    private Reservation reservation;
    @Autowired
    private RestaurantTableTypeRepository restaurantTableTypeRepository;
    @Autowired
    private View view;
    @Autowired
    private RestaurantTableRepository restaurantTableRepository;

    @GetMapping("/")
    public String MainPage() { return "MainPage"; }

    @PostMapping("/search")
    public String Search(
            @RequestParam String startTime,
            @RequestParam String endTime,
            @RequestParam int peopleCount
    ) {
        Schedule saved = reservation.MakeNewSchedule(startTime, endTime, peopleCount);

        return "redirect:/tableplan?scheduleId=" + saved.getId();
    }

    @GetMapping("/tableplan")
    public String TablePage(
            @RequestParam(required = false) Integer scheduleId,
            @RequestParam(required = false) Integer selectedTableId,
            Model model) {
        model.addAttribute("scheduleId", scheduleId);
        model.addAttribute("selectedTableId", selectedTableId);
        model.addAttribute("tableTypes", restaurantTableTypeRepository.findAll());
        if (selectedTableId != null) {
            model.addAttribute("selectedTable", reservation.FindTable(selectedTableId));
            model.addAttribute("selectedTableSchedules", reservation.FindTableSchedules(selectedTableId));
        }
        return "TablePage";
    }

    @GetMapping("/confirmation")
    public String ConfirmationPage(
            @RequestParam Integer tableId,
            @RequestParam int scheduleId,
            Model model) {
        if (tableId == null) {
            return "redirect:/tableplan?scheduleId=" + scheduleId + "&error=Please select a table first";
        }
        RestaurantTable table = restaurantTableRepository.findById(tableId)
                .orElseThrow(() -> new RuntimeException("Table not found"));
        model.addAttribute("table", table);
        model.addAttribute("scheduleId", scheduleId);
        return "ConfirmationPage";
    }

}