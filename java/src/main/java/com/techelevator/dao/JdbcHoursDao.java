package com.techelevator.dao;


import com.techelevator.model.Hours;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;


import javax.xml.crypto.Data;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcHoursDao implements HoursDao {

    private JdbcTemplate template;

    public JdbcHoursDao (JdbcTemplate template) {
        this.template = template;
    }
    @Override
    public Hours getHoursByAttractionId(int id) {
        Hours attractionHours = new Hours();

        String sql = "SELECT attractions.name, attraction_id, mon_open, tues_open, wed_open, thurs_open, fri_open, sat_open, sun_open, " +
                " mon_close, tues_close, wed_close, thurs_close, fri_close, sat_close, sun_close FROM hour_day JOIN attractions ON attractions.id = hour_day.attraction_id " +
                "WHERE attraction_id = ? ";

        SqlRowSet results = template.queryForRowSet(sql,id);

        if (results.next()) {
            attractionHours = mapRowToHours(results);
        }

        return attractionHours;

    }



    @Override
    public boolean addHours(Hours addHours) {


        try {
            String checkDB = " SELECT attraction_id FROM hour_day WHERE attraction_id = ?;";
            SqlRowSet results = template.queryForRowSet(checkDB, addHours.getAttractionId());


            if (results == null) {

                String sql = "INSERT INTO hour_day (attraction_id, mon_open, mon_close, tues_open, tues_close, wed_open, wed_close, thurs_open, thurs_close, fri_open, fri_close, sat_open, sat_close, sun_open, sun_close)" +
                        " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) ;";

                int rows = template.update(sql, addHours.getAttractionId(), addHours.getMondayOpen(), addHours.getMondayClose(), addHours.getTuesdayOpen(), addHours.getTuesdayClose(),
                        addHours.getWednesdayOpen(), addHours.getWednesdayClose(), addHours.getThursdayOpen(), addHours.getThursdayClose(), addHours.getFridayOpen(),
                        addHours.getFridayClose(), addHours.getSaturdayOpen(), addHours.getSaturdayClose(), addHours.getSundayOpen(), addHours.getSundayClose());

                if (rows == 1) {
                    return true;
                }

            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Cannot connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Incorrect SQL statement", e);
        }
        return false;
            }


        public boolean updateHours (String day, int id, Hours newHours ){

            if (day.equalsIgnoreCase("monday")) {

                try {

                    String sql = "UPDATE hour_day SET mon_open = ?, mon_close = ? WHERE attraction_id = ?;";
                    template.update(sql, newHours.getMondayOpen(), newHours.getMondayClose(), id);

                    return true;


                } catch (CannotGetJdbcConnectionException e) {
                    throw new DaoException("Cannot connect to server or database", e);
                } catch (DataIntegrityViolationException e) {
                    throw new DaoException("Incorrect SQL statement", e);
                }


            } else if (day.equalsIgnoreCase("tuesday")) {

                try {
                    String sql = "UPDATE hour_day SET tues_open = ?, tues_close = ? WHERE attraction_id = ?;";
                    template.update(sql, newHours.getTuesdayOpen(), newHours.getTuesdayClose(), id);
                    return true;
                } catch (CannotGetJdbcConnectionException e) {
                    throw new DaoException("Cannot connect to server or database", e);

                } catch (DataIntegrityViolationException e) {
                    throw new DaoException("Incorrect SQL statement", e);

                }
            } else if (day.equalsIgnoreCase("wednesday")) {
                try {
                    String sql = "UPDATE hour_day SET wed_open = ?, wed_close = ? WHERE attraction_id = ?;";
                    template.update(sql, newHours.getWednesdayOpen(), newHours.getWednesdayClose(), id);
                    return true;
                } catch (CannotGetJdbcConnectionException e) {
                    throw new DaoException("Cannot connect to server or database", e);
                } catch (DataIntegrityViolationException e) {
                    throw new DaoException("Incorrect SQL statement", e);
                }

            } else if (day.equalsIgnoreCase("thursday")) {

                try {
                    String sql = "UPDATE hour_day SET thurs_open = ?, thurs_close = ? WHERE attraction_id = ?;";
                    template.update(sql, newHours.getThursdayOpen(), newHours.getThursdayClose(), id);
                    return true;
                } catch (CannotGetJdbcConnectionException e) {
                    throw new DaoException("Cannot connect to server or database", e);
                } catch (DataIntegrityViolationException e) {
                    throw new DaoException("Incorrect SQL statement", e);
                }

            } else if (day.equalsIgnoreCase("friday")) {
                try {
                    String sql = "UPDATE hour_day SET fri_open = ?, fri_close = ? WHERE attraction_id = ?;";

                    template.update(sql, newHours.getFridayOpen(), newHours.getFridayClose(), id);
                    return true;
                } catch (CannotGetJdbcConnectionException e) {
                    throw new DaoException("Cannot connect to server or database", e);
                } catch (DataIntegrityViolationException e) {
                    throw new DaoException("Incorrect SQL statement", e);
                }
            } else if (day.equalsIgnoreCase("saturday")) {
                try {
                    String sql = "UPDATE hour_day SET sat_open = ?, sat_close = ? WHERE attraction_id = ?;";
                    template.update(sql, newHours.getSaturdayOpen(), newHours.getSaturdayClose(), id);
                    return true;
                } catch (CannotGetJdbcConnectionException e) {
                    throw new DaoException("Cannot connect to server or database", e);
                } catch (DataIntegrityViolationException e) {
                    throw new DaoException("Incorrect SQL statement", e);
                }
            } else if (day.equalsIgnoreCase("sunday")) {
                try {
                    String sql = "UPDATE hour_day  SET sun_open = ?, sun_close = ? WHERE attraction_id = ?;";
                    template.update(sql, newHours.getSundayOpen(), newHours.getSundayClose(), id);
                    return true;
                } catch (CannotGetJdbcConnectionException e) {
                    throw new DaoException("Cannot connect to server or database", e);
                } catch (DataIntegrityViolationException e) {
                    throw new DaoException("Incorrect SQL statement", e);
                }

            }

            return false;
        }

        @Override
        public int deleteHours ( int id){
            int rows;
            try {
                String sql = "DELETE from hour_day WHERE attraction_id = ?;";
                rows = template.update(sql, id);
            } catch (CannotGetJdbcConnectionException e) {
                throw new DaoException("Cannot connect to database or server", e);
            } catch (DataIntegrityViolationException e) {
                throw new DaoException("Incorrect SQL statement", e);
            }

            return rows;
        }


        public Hours mapRowToHours (SqlRowSet results){
            Hours attractionHours = new Hours();
            attractionHours.setAttractionName(results.getString("name"));
            attractionHours.setAttractionId(results.getInt("attraction_id"));
            attractionHours.setMondayOpen(results.getString("mon_open"));
            attractionHours.setMondayClose(results.getString("mon_close"));
            attractionHours.setTuesdayOpen(results.getString("tues_open"));
            attractionHours.setTuesdayClose(results.getString("tues_close"));
            attractionHours.setWednesdayOpen(results.getString("wed_open"));
            attractionHours.setWednesdayClose(results.getString("wed_close"));
            attractionHours.setThursdayOpen(results.getString("thurs_open"));
            attractionHours.setThursdayClose(results.getString("thurs_close"));
            attractionHours.setFridayOpen(results.getString("fri_open"));
            attractionHours.setFridayClose(results.getString("fri_close"));
            attractionHours.setSaturdayOpen(results.getString("sat_open"));
            attractionHours.setSaturdayClose(results.getString("sat_close"));
            attractionHours.setSundayOpen(results.getString("sun_open"));
            attractionHours.setSundayClose(results.getString("sun_close"));

            return attractionHours;
        }
    }

