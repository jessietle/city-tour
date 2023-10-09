package com.techelevator.dao;

import com.techelevator.model.Attractions;
import com.techelevator.model.Itinerary;
import com.techelevator.model.ItineraryDto.CreateItineraryDto;
import com.techelevator.model.ItineraryDto.UpdateItineraryDto;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class JdbcItineraryDao implements ItineraryDao {
    private JdbcTemplate template;

    public JdbcItineraryDao (DataSource source) {
        template = new JdbcTemplate(source);
    }

    @Override
    public List<Itinerary> getAllItineraries( int userId) {
        String sql = "SELECT * FROM itinerary WHERE user_id = ?;";
        SqlRowSet res = template.queryForRowSet(sql,userId);
        List <Itinerary> allItineraries = new ArrayList<>();
        try {
            while (res.next()) {
                Itinerary itinerary = mapToRowsetItinerary(res);
                // get list of attractions with itinerary Id
                itinerary.setLocations(getAttractions(itinerary.getId()));

                allItineraries.add(itinerary);
            }
        }catch  (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return allItineraries;
    }


    @Override
    public Itinerary getItineraryById(int id, int userId) {
        Itinerary itinerary = null;
        try {
            String sql = "SELECT * FROM itinerary WHERE user_id = ? AND itinerary_id = ?;";
            SqlRowSet res = template.queryForRowSet(sql, userId, id);
            if (res.next()) {
                itinerary = mapToRowsetItinerary(res);
                // get list of attractions with itinerary Id
                itinerary.setLocations(getAttractions(itinerary.getId()));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return itinerary;
    }

    // Get list of attractions' id associates with target itinerary
    private List<Attractions> getAttractions(int itineraryId) {
        String sql = "SELECT * FROM attractions a JOIN itinerary_attraction b ON a.id = b.attraction_id  WHERE b.itinerary_id = ?";
        SqlRowSet res = template.queryForRowSet(sql, itineraryId);

        List<Attractions> attractionList = new ArrayList<>();
        try {
            while (res.next()) {
                attractionList.add(mapToRowsetAttractions(res));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return attractionList;
    }

    @Override
    public Itinerary createItinerary(CreateItineraryDto itinerary, int userId) {
        Itinerary newItinerary =null;
        try {
            String sql = "INSERT INTO itinerary (date_of_itinerary,itinerary_name, user_id) " +
                    "VALUES (?,?,?) RETURNING itinerary_id;";

            Integer newItineraryId = template.queryForObject(sql, Integer.class,
                    itinerary.getDate(), itinerary.getName(), userId);
            newItinerary = getItineraryById(newItineraryId, userId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return newItinerary;
    }

    @Override
    public Itinerary updateItinerary(UpdateItineraryDto itinerary, int userId) {
        Itinerary target = getItineraryById(itinerary.getId(), userId);

        if (userId == target.getUserId()) {
            Itinerary editItinerary = null;
            String sql = "UPDATE itinerary SET starting_point = ?, date_of_itinerary = ? , itinerary_name = ?" +
                    "WHERE itinerary_id =?;";

            int numberOfRow = template.update(sql, itinerary.getStartingPoint(), itinerary.getDate(), itinerary.getName(), itinerary.getId());
            if (numberOfRow == 0) {
                throw new DaoException("Zero rows affected, expected at least one");
            }else{
                editItinerary = getItineraryById(itinerary.getId(), userId);
            }
            return editItinerary;
        } else {
            throw new DaoException("Unauthorized to edit this object");
        }
    }

    @Override
    public int deleteItinerary(int id, int userId) {
        Itinerary target = getItineraryById(id, userId);

        if (userId == target.getUserId()) {
            String sql = "DELETE FROM itinerary WHERE itinerary_id = ?;";
            String sql2 = "DELETE FROM itinerary_attraction WHERE itinerary_id = ?;";
            template.update(sql2,id);
            int numberOfRows= template.update(sql,id);
            return numberOfRows;
        } else {
            throw new DaoException("Unauthorized to edit this object");
        }
    }

    private Itinerary mapToRowsetItinerary(SqlRowSet res) {

        Itinerary itinerary = new Itinerary();
        itinerary.setId(res.getInt("itinerary_id"));
        itinerary.setStartingPoint(res.getInt("starting_point"));
        itinerary.setDate(res.getString("date_of_itinerary"));
        itinerary.setUserId(res.getInt("user_id"));
        itinerary.setName(res.getString("itinerary_name"));

        return itinerary;
    }

    private Attractions mapToRowsetAttractions(SqlRowSet res) {
        Attractions att = new Attractions();

        att.setAddress(res.getString("address"));
        att.setDescription(res.getString("description"));
        att.setId(res.getInt("id"));
        att.setImage(res.getString("image"));
        att.setName(res.getString("name"));
        att.setRate(res.getInt("rate"));
        att.setType(res.getString("type"));

        return att;
    }

    @Override
    public void addAttraction (int itineraryId, int attractionId){
        String sql = "INSERT INTO itinerary_attraction (attraction_id,  itinerary_id) VALUES (?,?) RETURNING itinerary_id;";
        SqlRowSet res = template.queryForRowSet(sql,attractionId, itineraryId);

        if (!res.next()) {
            throw new DaoException("Failed to add Attraction to Itinerary");
        }
    };

    @Override
    public void removeAttraction (int itineraryId, int attractionId){
        String sql = "DELETE FROM itinerary_attraction WHERE attraction_id = ? AND itinerary_id =?;";
        int res = template.update(sql,attractionId, itineraryId);

        if (res == 0) {
            throw new DaoException("Failed to delete Attraction to Itinerary");
        }
    };
}
