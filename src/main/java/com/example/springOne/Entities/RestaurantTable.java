package com.example.springOne.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "restaurant_table")
public class RestaurantTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private int tableNumber;

    private int peopleCount;

    @ManyToOne
    @JoinColumn(name = "type_id") // foreign key column
    private RestaurantTableType type;

    public RestaurantTable() {}

    public RestaurantTable(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    // Getters and setters
    public int getId() { return Id; }
    public void setId(int id) { this.Id = id; }

    public int getTableNumber() { return tableNumber; }
    public void setTableNumber(int tableNumber) { this.tableNumber = tableNumber; }

    public int getPeopleCount() { return peopleCount; }
    public void setPeopleCount(int peopleCount) { this.peopleCount = peopleCount; }

}
