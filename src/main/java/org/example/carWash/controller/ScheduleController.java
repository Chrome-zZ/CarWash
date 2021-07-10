package org.example.carWash.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.carWash.dto.AddingFacilityDTO;
import org.example.carWash.model.Schedule;
import org.example.carWash.service.ScheduleService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schedules")
@Api
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/{username}")
    @PreAuthorize("hasAuthority('users:read')")
    @ApiOperation("Показать все записи на мойку конкретного пользователя из БД")
    public List<Schedule> getAllByUsername(@PathVariable String username) {
        return scheduleService.getAllByUsername(username);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('users:read')")
    @ApiOperation("Записаться на услугу")
    public String addFacilityInSchedule(@RequestBody AddingFacilityDTO addingFacilityDTO) {
        return scheduleService.addFacilityInSchedule(addingFacilityDTO);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('users:read')")
    @ApiOperation("Посмотреть сколько времени осталось до очереди клиента")
    public String getRemainingTime(@RequestBody String name) {
        return scheduleService.getRemainingTime(name);
    }
}