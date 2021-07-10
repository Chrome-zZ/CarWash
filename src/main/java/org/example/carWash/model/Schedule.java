package org.example.carWash.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "schedules")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime time;
    @Column
    private boolean free;

    @ManyToOne(/*fetch = FetchType.EAGER, cascade = {CascadeType.MERGE}*/)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(/*fetch = FetchType.EAGER,*/cascade = CascadeType.ALL)
    @JoinColumn(name = "facility_id")
    private Facility facility;

    public Long getId() {
        return id;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}