package com.techelevator.controller;

import com.techelevator.dao.AttractionsDao;
import com.techelevator.model.Attractions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class AttractionsController {
  @Autowired
  AttractionsDao dao;
  @PreAuthorize("permitAll")
  @RequestMapping (path="/allMuseums", method = RequestMethod.GET)
    public List<Attractions> getAllMuseums () {
      return dao.getAllMuseums();
  }
  @PreAuthorize("permitAll")
  @RequestMapping (path="/allMonuments", method = RequestMethod.GET)
  public List<Attractions> getAllMonuments () {
    return dao.getAllMonuments();
  }
  @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
  @RequestMapping (path = "/addAttraction", method = RequestMethod.POST)
  public Attractions addAttraction (@RequestBody Attractions attraction) {
   return dao.addAttraction(attraction);
}
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @RequestMapping (path = "/editAttraction", method = RequestMethod.PUT)
  public boolean editAttraction (@RequestBody Attractions attraction) {

    if ( dao.updateAttraction(attraction) != null) {
      return true;
    }

    return false;
  }
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @RequestMapping (path = "/attractions/{id}", method = RequestMethod.DELETE)
  public int deleteAttraction (@PathVariable int id) {
    return dao.deleteAttraction(id);
  }
  @PreAuthorize("permitAll")
  @RequestMapping (path = "/attractions/{id}", method = RequestMethod.GET)
  public Attractions getAttractionById (@PathVariable int id) {
    return dao.getAttractionById(id);
  }

}
