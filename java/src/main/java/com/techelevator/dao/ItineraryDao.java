package com.techelevator.dao;

import com.techelevator.model.Attractions;
import com.techelevator.model.Itinerary;
import com.techelevator.model.ItineraryDto.CreateItineraryDto;
import com.techelevator.model.ItineraryDto.UpdateItineraryDto;

import java.security.Principal;
import java.util.List;

public interface ItineraryDao {

    public List<Itinerary> getAllItineraries (int userId);
    public Itinerary getItineraryById (int id, int userId);
    public Itinerary createItinerary (CreateItineraryDto itinerary, int userId);
    public Itinerary updateItinerary (UpdateItineraryDto itinerary, int userId);
    public int deleteItinerary (int id, int userId);

    public void addAttraction (int itineraryId, int attractionId);
    public void removeAttraction (int itineraryId, int attractionId);
}
