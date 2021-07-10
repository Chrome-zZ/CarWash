package org.example.carWash.repos;

import org.example.carWash.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalTime;

public interface ScheduleRepo extends JpaRepository<Schedule, Long> {
    Schedule findByTime(LocalTime time);
}