package com.techelevator.dao;

import com.techelevator.model.Attractions;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcAttractionsDao implements AttractionsDao{

    private JdbcTemplate template;

    public JdbcAttractionsDao (DataSource source) {
        template = new JdbcTemplate(source);
    }


    @Override
    public List<Attractions> getAllMuseums() {

        List <Attractions> allMuseums = new ArrayList<>();
        try {
            String sql = "SELECT * FROM attractions WHERE type = 'Museum';";
            SqlRowSet results = template.queryForRowSet(sql);
            while (results.next()) {
                Attractions museum = mapRowToAttractions(results);

                allMuseums.add(museum);
            }
        }catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

    return allMuseums;
    }

    @Override
    public List<Attractions> getAllMonuments() {
        List <Attractions> allMonuments = new ArrayList<>();
        try {
            String sql = "SELECT * FROM attractions WHERE type = 'Monument';";
            SqlRowSet results = template.queryForRowSet(sql);

            while (results.next()) {
                Attractions monument = mapRowToAttractions(results);

                allMonuments.add(monument);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return allMonuments;

    }

    @Override

    public Attractions addAttraction (Attractions newAttraction) {
        String sql = "INSERT INTO attractions (name, address, description, type) VALUES (?, ?, ?, ?) RETURNING id;";
        Attractions insert = null;

     try {
         int id = template.queryForObject(sql, Integer.class, newAttraction.getName(), newAttraction.getAddress(), newAttraction.getDescription(), newAttraction.getType());
         insert = getAttractionById(id);

     } catch (CannotGetJdbcConnectionException e) {
         throw new DaoException("Unable to connect to server or database", e);
     }catch (DataIntegrityViolationException e) {
         throw new DaoException("Data integrity violation", e);
     }

     return insert;
    }

    @Override
    public Attractions updateAttraction(Attractions updatedAttraction) {

     try {

        if (updatedAttraction.getName() != null) {

            String sql = "UPDATE attractions SET name = ? WHERE id = ?";
            template.update(sql,updatedAttraction.getName(), updatedAttraction.getId());

        }

        if (updatedAttraction.getAddress() != null) {

            String sql = "UPDATE attractions SET address = ? WHERE id = ?;";
            template.update(sql, updatedAttraction.getAddress(), updatedAttraction.getId());

        }

        if (updatedAttraction.getDescription() != null) {
            String sql = "UPDATE attractions SET description = ? WHERE id = ?;";
            template.update(sql,updatedAttraction.getDescription(), updatedAttraction.getId());

        }

        if (updatedAttraction.getImage() != null) {
            String sql = "UPDATE attractions SET image = ? WHERE id = ? ;";
            template.update(sql,updatedAttraction.getImage(), updatedAttraction.getId());
        }

        if (updatedAttraction.getType() != null) {
            String sql = "UPDATE attractions SET type = ? WHERE id = ?;";
            template.update(sql, updatedAttraction.getType(), updatedAttraction.getId());
        }
        }catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }catch (DataIntegrityViolationException e) {
            throw new DaoException( "Data integrity violation", e);
        }
        return getAttractionById(updatedAttraction.getId());

    }


    @Override
    public int deleteAttraction(int id) {
        String sql = "DELETE FROM attractions WHERE id = ?;";
        int numberOfRows;
        try {
            numberOfRows = template.update(sql, id);

        }catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return numberOfRows;
    }

    public Attractions getAttractionById (int id) {

        Attractions attractionById = new Attractions();
        try {
            String sql = "SELECT * FROM attractions WHERE id = ? ;";
            SqlRowSet result = template.queryForRowSet(sql, id);
            if (result.next()) {
                attractionById = mapRowToAttractions(result);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to database or server", e);
        }

        return attractionById;
    }

    public Attractions mapRowToAttractions (SqlRowSet results) {
        Attractions attraction = new Attractions();
        attraction.setAddress(results.getString("address"));
        attraction.setDescription(results.getString("description"));
        attraction.setImage(results.getString("image"));
        attraction.setName(results.getString("name"));
        attraction.setType(results.getString("type"));
        attraction.setId(results.getInt("id"));

        return attraction;
    }
}
