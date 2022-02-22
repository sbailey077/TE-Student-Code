package com.techelevator.dao;

import com.techelevator.model.Park;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcParkDao implements ParkDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcParkDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /*
        1. Determine the query in pgAdmin - determine input (parameters)
            and how many results you can expect (nothing, 0-to-many-rows, a_generated_id)
        2. Call jdbcTemplate
                If 0-to-many-rows as result - queryForRowSet()
                If generated_id result - queryForObject()
                If nothing result - update()
        3a. If calling update(), then we are done.
        3b. If calling queryForObject(), then that Object is returned and we are done
        3c. If calling queryForRowSet(), then SqlRowSet is returned
        4. Call next() if true then map the row to an object, if false we are done
        5. repeat 4 until next() is false


        SELECT - always use queryForRowSet()
        UPDATE/DELETE - always use update()
        INSERT with RETURNING id - use queryForObject()
        INSERT without RETURNING id - use update()
     */


    @Override
    public Park getPark(long parkId) {
        Park selectedPark = null;
        String sql = "SELECT park.park_id, park_name, date_established, area, has_camping " +
                "FROM park " +
                "WHERE park_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, parkId);
        while (results.next()) {
            selectedPark = mapRowToPark(results);
        }
        return selectedPark;
    }

    @Override
    public List<Park> getParksByState(String stateAbbreviation) {
        List<Park> listOfParks = new ArrayList<Park>();

        String sql = "SELECT park.park_id, park_name, date_established, area, has_camping " +
                "FROM park " +
                "JOIN park_state ON park.park_id = park_state.park_id " +
                "WHERE state_abbreviation = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, stateAbbreviation);

        while(results.next()) {
            Park parkFromCurrentRow = mapRowToPark( results );
            listOfParks.add( parkFromCurrentRow );
        }

        return listOfParks;
    }

    @Override
    public Park createPark(Park park) {
        String sql = "INSERT INTO park (park_name, date_established, area, has_camping) " +
                "VALUES (?, ?, ?, ?) RETURNING park_id";
        Long parkId = jdbcTemplate.queryForObject(sql, Long.class, park.getParkName(), park.getDateEstablished(),
                park.getArea(), park.getHasCamping());
        park.setParkId(parkId);
        return park;
    }

    @Override
    public void updatePark(Park park) {
        String sql = "UPDATE park SET park_name=?, date_established=?, area=?, has_camping=? WHERE park_id=?";
        jdbcTemplate.update(sql, park.getParkName(), park.getDateEstablished(),
                park.getArea(), park.getHasCamping(), park.getParkId());
    }

    @Override
    public void deletePark(long parkId) {
        String sql = "DELETE FROM park WHERE park_id = ?";
        jdbcTemplate.update(sql, parkId);
    }

    @Override
    public void addParkToState(long parkId, String stateAbbreviation) {
        String sql = "INSERT INTO park_state (park_id, state_abbreviation) VALUES (?, ?)";
        jdbcTemplate.update(sql, parkId, stateAbbreviation);

    }

    @Override
    public void removeParkFromState(long parkId, String stateAbbreviation) {
        String sql = "DELETE FROM park_state WHERE park_id = ? AND state_abbreviation = ?";
        jdbcTemplate.update(sql, parkId, stateAbbreviation);
    }

    //SELECT park.park_id, park_name, date_established, area, has_camping
    private Park mapRowToPark(SqlRowSet rowSet) {
        Park parkFromCurrentRow =  new Park();

        parkFromCurrentRow.setParkId(  rowSet.getLong("park_id") );
        parkFromCurrentRow.setParkName( rowSet.getString("park_name") );
        if (rowSet.getDate("date_established") != null) {
            parkFromCurrentRow.setDateEstablished(rowSet.getDate("date_established").toLocalDate());
        }
        parkFromCurrentRow.setArea( rowSet.getDouble("area") );
        parkFromCurrentRow.setHasCamping( rowSet.getBoolean("has_camping") );
        return parkFromCurrentRow;
    }
}
