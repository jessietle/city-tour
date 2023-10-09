package com.techelevator.controller;

import com.techelevator.dao.ItineraryDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Attractions;
import com.techelevator.model.Itinerary;
import com.techelevator.model.ItineraryDto.CreateItineraryDto;
import com.techelevator.model.ItineraryDto.UpdateItineraryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")

public class ItineraryController {
    @Autowired
    ItineraryDao dao;

    @Autowired
    UserDao userDao;
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @RequestMapping(path = "/itinerary/getAll", method = RequestMethod.GET)
    public List<Itinerary> getAllItineraries( Principal principal) {
        int userId = userDao.findIdByUsername(principal.getName());
        return dao.getAllItineraries(userId);
    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @RequestMapping(path = "/itinerary/{id}", method = RequestMethod.GET)
    public Itinerary getItineraryById(@PathVariable int id, Principal principal) {
        int userId = userDao.findIdByUsername(principal.getName());
        return dao.getItineraryById(id, userId);
    }
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @RequestMapping(path = "/itinerary/create", method = RequestMethod.POST)
    public Itinerary createItinerary( @Valid @RequestBody CreateItineraryDto itinerary, Principal principal) {
        int userId = userDao.findIdByUsername(principal.getName());
        return dao.createItinerary(itinerary, userId);
    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @RequestMapping(path = "/itinerary/edit", method = RequestMethod.PUT)
    public Itinerary editItinerary(@Valid @RequestBody UpdateItineraryDto itinerary, Principal principal) {
        int userId = userDao.findIdByUsername(principal.getName());
        return dao.updateItinerary(itinerary, userId);
    }
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @RequestMapping(path = "/itinerary/delete/{id}", method = RequestMethod.DELETE)
    public int deleteItinerary(@PathVariable int id, Principal principal) {
        int userId = userDao.findIdByUsername(principal.getName());
        return dao.deleteItinerary(id, userId);
    }

    // FOR Attractions AND Itinerary communicate

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @RequestMapping(path = "/itinerary/{itineraryId}/addAttraction/{attractionId}", method = RequestMethod.POST)
    public void addAttraction(@PathVariable int itineraryId, @PathVariable int attractionId) {
        dao.addAttraction(itineraryId, attractionId);
    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @RequestMapping(path = "/itinerary/{itineraryId}/removeAttraction/{attractionId}", method = RequestMethod.DELETE)
    public void removeAttraction(@PathVariable int itineraryId, @PathVariable int attractionId) {
        dao.removeAttraction(itineraryId, attractionId);
    }
}
