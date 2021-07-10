package org.example.carWash.service;

import org.example.carWash.dto.AddingFacilityDTO;
import org.example.carWash.model.Facility;
import org.example.carWash.model.Schedule;
import org.example.carWash.model.User;
import org.example.carWash.repos.FacilityRepo;
import org.example.carWash.repos.ScheduleRepo;
import org.example.carWash.repos.UserRepo;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleService {

    private final ScheduleRepo scheduleRepo;
    private final FacilityRepo facilityRepo;
    private final UserRepo userRepo;

    public ScheduleService(ScheduleRepo scheduleRepo, FacilityRepo facilityRepo, UserRepo userRepo) {
        this.scheduleRepo = scheduleRepo;
        this.facilityRepo = facilityRepo;
        this.userRepo = userRepo;
    }

    public List<Schedule> getAllByUsername(String username) {
        List<Schedule> result = new ArrayList<>();
        for (Schedule schedule : scheduleRepo.findAll()
        ) {
            if (schedule.getUser() != null && schedule.getUser().getUsername().equals(username)) {
                result.add(schedule);
            }
        }
        return result;
    }

    public String addFacilityInSchedule(AddingFacilityDTO addingFacilityDTO) {
        Facility facility = facilityRepo.findByName(addingFacilityDTO.getFacility()).get();
        User user = userRepo.findByUsername(addingFacilityDTO.getUsername()).get();
        Schedule s = scheduleRepo.findByTime(addingFacilityDTO.getTime());
        if (s.isFree() && addingFacilityDTO.getTime().getHour() >= LocalTime.now().getHour()) {
            s.setFacility(facility);
            s.setUser(user);
            s.setFree(false);
            scheduleRepo.save(s);
            return "Success";
        }
        return "Bad request";
    }

    public String getRemainingTime(String name) {
        int hours = 0;
        int minutes = 0;
        for (Schedule s : scheduleRepo.findAll()) {
            if (s.getUser() != null && s.getUser().getUsername().contains(name)) {
                hours = s.getTime().getHour() - LocalTime.now().getHour() - 1;
                minutes = 60 - LocalTime.now().getMinute();
            }
        }
        return name + ", your remaining time - " + hours + ":" + minutes;
    }
}