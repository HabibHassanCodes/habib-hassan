package com.techelevator.dao;

import com.techelevator.model.Brewery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcBreweryDao implements BreweryDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private JdbcBreweryDao jdbcBreweryDao;
    public JdbcBreweryDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<Brewery> getAllBrewery() {
        List<Brewery> list = new ArrayList<>();

        String sql = "SELECT brewery_id, review_id,brewery_name, description, street_name,zip_code, phone_number, website_url " +
                "FROM brewery; ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            Brewery brewery = mapRowToBrewery(results);
            list.add(brewery);
        }
        return list;
    }

//    @Override
//    public Brewery getBreweryByStreetName(String streetName) {
//        Brewery brewery = null;
//
//        String sql = "SELECT brewery_id, beer_id, review_id,brewery_name, description, street_name,zip_code, phone_number, website_url "+
//                "FROM brewery WHERE street_name = ?; ";
//        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, streetName);
//        if (results.next()){
//            brewery = mapRowToBrewery(results);
//        }
//        return brewery;
//    }

    @Override
    public Brewery getBreweryByZipCode(String zipCode) {
        Brewery brewery = null;

        String sql = "SELECT brewery_id, review_id,brewery_name, description, street_name,zip_code, phone_number, website_url " +
                "FROM brewery WHERE zip_code = ?; ";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, zipCode);
        if (rowSet.next()) {
            brewery = mapRowToBrewery(rowSet);
        }
        return brewery;
    }

//    @Override
//    public List<Brewery> getBreweryByBeerId(int beerId) {
//        List<Brewery> brewery = new ArrayList<>();
//
//        String sql = "SELECT brewery.brewery_id, beer.beer_id, review_id,brewery_name, beer.description, street_name,zip_code, phone_number, website_url "+
//                    "FROM brewery_specialty_beers as bsb " +
//                    "JOIN brewery ON brewery.brewery_id=bsb.brewery_id "+
//                    "JOIN beer ON beer.beer_id=bsb.beer_id "+
//                    "WHERE beer.beer_id=? ;";
//
//        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, beerId);
//        while(results.next()) {
//            Brewery location = mapRowToBrewery(results);
//            brewery.add(location);
//        }
//        return brewery;
//    }

    @Override
    public Brewery getBreweryByName(String name) {
        Brewery breweryToReturn = new Brewery();

        String sql = "SELECT brewery_id, review_id, brewery_name, description, street_name, zip_code, phone_number, website_url " +
                "FROM brewery WHERE brewery_name = ?; ";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, name);

        if (results.next()) {
            breweryToReturn = mapRowToBrewery(results);
        }

        return breweryToReturn;
    }

    @Override
    public void updateBrewery(Brewery brewery, int id) {
        String sql = "UPDATE brewery " +
                "SET brewery_name = ?, " +
                "description = ?, street_name = ?, zip_code = ?, " +
                "phone_number = ?, website_url = ? " +
                "WHERE brewery_id = ?;";
        jdbcTemplate.update(sql, brewery.getBreweryName(), brewery.getBreweryDescription(), brewery.getStreetName(), brewery.getZipCode(),
                brewery.getPhoneNumber(), brewery.getWebsiteUrl(), id);
     //   return getBreweryByBeerId(id);
    }
    @Override
    public void createBrewery(Brewery newBrewery) {
        String sql = "INSERT INTO brewery (brewery_name, description, street_name, zip_code, phone_number, website_url)"
                + " VALUES (?, ?, ?, ?, ?, ?);";
        try {
            jdbcTemplate.queryForObject(sql, Integer.class, newBrewery.getBreweryName(),
                    newBrewery.getBreweryDescription(), newBrewery.getStreetName(), newBrewery.getZipCode(),
                    newBrewery.getPhoneNumber(), newBrewery.getWebsiteUrl());
        } catch (DataAccessException e) {
            System.out.println(e.getCause());
        }
    }

    private Brewery mapRowToBrewery(SqlRowSet results) {
        Brewery brewery = new Brewery();
        brewery.setBreweryID(results.getInt("brewery_id"));
        brewery.setBreweryName(results.getString("brewery_name"));
        brewery.setBreweryDescription(results.getString("description"));
        brewery.setStreetName(results.getString("street_name"));
        brewery.setZipCode(results.getString("zip_code"));
        brewery.setPhoneNumber(results.getString("phone_number"));
        brewery.setWebsiteUrl(results.getString("website_url"));

        return brewery;
    }





    //INSERT INTO brewery (brewery_id, beer_id, review_id, brewery_name, description, street_name, zip_code, phone_number, website_url)
    //VALUES (1, 1, 1, 'BrewBoys', 'Enjoy a drink on the beach!', 'Wallaby', '76108', '678-999-8212', 'PLACEHOLDER URL');

}
