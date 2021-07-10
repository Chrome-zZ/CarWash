package org.example.carWash.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usr")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;
    @Column
    private String automobile;
    @Column
    private String password;
    @Enumerated(value = EnumType.STRING)
    @Column
    private Role role;
    @Enumerated(value = EnumType.STRING)
    @Column
    private Status status;

    @JsonIgnore
    @OneToMany(/*fetch = FetchType.EAGER,*/ mappedBy = "user"/*, cascade = CascadeType.ALL*/)
    private List<Schedule> schedule;

    public User() {
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAutomobile() {
        return automobile;
    }

    public void setAutomobile(String automobile) {
        this.automobile = automobile;
    }

    public User(Long id, String username, String automobile) {
        this.id = id;
        this.username = username;
        this.automobile = automobile;
    }
}
