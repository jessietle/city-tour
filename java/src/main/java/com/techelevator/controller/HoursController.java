package com.techelevator.controller;

import com.techelevator.dao.HoursDao;
import com.techelevator.model.Hours;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;

import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin

@PreAuthorize("isAuthenticated()")
public class HoursController {
    @Autowired
    HoursDao dao;
    @PreAuthorize("permitAll")
    @RequestMapping(path = "/{id}/hours", method = RequestMethod.GET)
    public Hours getHoursById (@PathVariable int id) {
        return dao.getHoursByAttractionId(id);
    }

    @PreAuthorize("permitAll")
    @RequestMapping (path ="/{id}/{day}", method = RequestMethod.PUT)
    public boolean updateHours (@PathVariable int id, @PathVariable String day, @RequestBody Hours newHours ) {
        return dao.updateHours(day,id, newHours);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping (path = "/addHours", method = RequestMethod.POST)
    public boolean addHours (@RequestBody Hours addHours) {
       return dao.addHours(addHours);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping (path = "/deleteHours/{id}", method = RequestMethod.DELETE)
    public int deleteHours (@PathVariable int id) {
        return dao.deleteHours(id);
    }

}
