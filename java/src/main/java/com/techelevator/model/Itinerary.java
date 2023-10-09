package com.techelevator.model;

import java.util.Date;
import java.util.List;

public class Itinerary {
    private int id;
    private int startingPoint;
    private List<Attractions> locations;
    private String date;
    private int userId;
    private String name;

    public Itinerary() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(int startingPoint) {
        this.startingPoint = startingPoint;
    }

    public List<Attractions> getLocations() {
        return locations;
    }

    public void setLocations(List<Attractions> locations) {
        this.locations = locations;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
