package org.example.carWash.model;

import javax.persistence.*;

@Entity
@Table(name = "facilities")
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private int price;

//    @OneToOne(mappedBy = "facility"/*fetch = FetchType.EAGER,cascade = CascadeType.ALL*/)
////    @JoinColumn(name = "schedule_id")
//    private Schedule schedule;
//
//    public Schedule getSchedule() {
//        return schedule;
//    }
//
//    public void setSchedule(Schedule schedule) {
//        this.schedule = schedule;
//    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
