package com.techelevator.dao;

import com.techelevator.model.Hours;

import java.util.List;

public interface HoursDao {

    public Hours getHoursByAttractionId (int id);

    public boolean addHours (Hours addHours);

    public boolean updateHours (String day, int id, Hours newHours);
    public int deleteHours (int id);

}
