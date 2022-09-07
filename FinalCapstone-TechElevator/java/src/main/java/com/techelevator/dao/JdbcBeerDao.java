package com.techelevator.dao;

import com.techelevator.model.Beer;
import com.techelevator.model.Brewery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcBeerDao implements  BeerDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private JdbcBeerDao jdbcBeerDao;
    @Autowired
    public JdbcBeerDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    List<Beer> allBeers =new ArrayList<>();


    @Override
    public List<Beer> getAllBeer() {
        List<Beer> list = new ArrayList<>();

        String sql = "SELECT beer_id,beer_name, description, beer_prices, beer_type "+
                "FROM beer;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            Beer service = mapRowToBeer(results);
            list.add(service);
        }
        return list;
    }
    @Override
    public Beer getBeerByName(String beerName) {
        Beer beer = null;

        String sql = "SELECT beer_id, beer_name, description, beer_prices, beer_type " +
                "FROM beer "+
                "WHERE beer_name = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, beerName);
        if (rowSet.next()){
            beer = mapRowToBeer(rowSet);
        }

        return beer;
    }
    @Override
    public List<Beer> getBeerByBreweryId(int breweryId) {
        List<Beer> beer = new ArrayList<>();

        String sql = "SELECT beer_id,brewery_id, beer_name,description, beer_prices, beer_type "+
                "FROM beer " +
                "WHERE brewery_id=? ;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, breweryId);
        while(results.next()) {
            Beer item = mapRowToBeer(results);
            beer.add(item);
        }
        return beer;
    }

    @Override
    public String addBeerInfo(String beerName, String beerDescription, int beerPrice, String beerType) {
        String sql = "INSERT INTO beer (beer_name, description, beer_prices, beer_type) " +
                "VALUES (?,?,?, ?) ;";
        jdbcTemplate.update(sql,beerName, beerDescription, beerPrice, beerType);
        return "success fully added beer info";
    }

    public Beer getBeerById(int beerId) {
        Beer beer = null;

        String sql = "SELECT beer_id, beer_name, description, beer_prices, beer_type " +
                "FROM beer "+
                "WHERE beer_id = ? ;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, beerId);
        if (rowSet.next()){
            beer = mapRowToBeer(rowSet);
        }

        return beer;
    }

    @Override
    public Beer createBeer(Beer newBeer) {
        String sql = "INSERT INTO beer (beer_name, description, beer_prices, beer_type) VALUES (?, ?, ?, ?) RETURNING beer_id;";
        Integer newId = jdbcTemplate.queryForObject(sql, Integer.class, newBeer.getBeerName(),
                newBeer.getBeerDescription(), newBeer.getBeerPrice(), newBeer.getBeerType());
        return getBeerById(newId);
    }
    @Override
    public void deleteBeer(int beerID) {
        String sql = "DELETE FROM beer WHERE beer_id = ? ; " +
                     "DELETE FROM brewery WHERE beer_id = ? ; ";
        jdbcTemplate.update(sql, beerID, beerID);
    }


    private Beer mapRowToBeer(SqlRowSet results) {
        Beer beer = new Beer();
        beer.setBeerId(results.getInt("beer_id"));
        beer.setBeerName(results.getString("beer_name"));
        beer.setBeerDescription(results.getString("description"));
        beer.setBeerPrice(results.getInt("beer_prices"));
        beer.setBeerType(results.getString("beer_type"));

        return beer;
    }
}


