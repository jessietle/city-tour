package com.techelevator.controller;

import com.techelevator.dao.AttractionsDao;
import com.techelevator.dao.ItineraryDao;
import com.techelevator.model.Attractions;
import com.techelevator.model.Itinerary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class UserController {
    @Autowired
    ItineraryDao dao;

    @RequestMapping(path = "/allItineraries", method = RequestMethod.GET)
    public List<Itinerary> getAllItineraries(int id) {
        return dao.getAllItineraries(id);
    }

}
