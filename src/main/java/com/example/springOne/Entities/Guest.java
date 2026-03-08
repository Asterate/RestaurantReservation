package com.example.springOne.Entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "guest")
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int Id;
    public String FirstName;
    public String LastName;
    public String phoneNumber;
    @OneToMany(mappedBy = "guest", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Schedule> schedules = new ArrayList<>();

    public Guest(){}

    public int getId(){return this.Id;}
    public void setId(int Id){this.Id = Id;}

    public String getFirstName(){return this.FirstName;}
    public void setFirstName(String firstName){this.FirstName = firstName;}

    public String getLastName(){return this.LastName;}
    public void setLastName(String lastName){this.LastName = lastName;}

    public String getPhoneNumber(){return this.phoneNumber;}
    public void setId(String phoneNumber){this.phoneNumber = phoneNumber;}
}
