package com.example.springOne.Entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "restaurant_table_type")
public class RestaurantTableType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int Id;
    @Column(unique = true)
    public String Name;

    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RestaurantTable> tables = new ArrayList<>();

    public RestaurantTableType() {}

    public int getId(){return Id;}
    public void setId(int id){this.Id = id; }

    public String getName(){return Name;}
    public void setName(String tableTypeName){this.Name = tableTypeName; }

}
