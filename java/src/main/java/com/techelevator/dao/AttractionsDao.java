package com.techelevator.dao;

import com.techelevator.model.Attractions;

import java.util.List;

public interface AttractionsDao {

    public List<Attractions> getAllMuseums ();
    public List<Attractions> getAllMonuments ();

    public Attractions addAttraction (Attractions newAttraction);
    public Attractions updateAttraction(Attractions updatedAttraction);
    public int deleteAttraction(int id);
    public Attractions getAttractionById (int id);

}
