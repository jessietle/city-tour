package com.techelevator.model.ItineraryDto;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

public class UpdateItineraryDto {
    private int id;
    private Date date;
    private String name;
    private int startingPoint;
    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(int startingPoint) {
        this.startingPoint = startingPoint;
    }
}
