package com.techelevator.dao;

import com.techelevator.model.Beer;
import com.techelevator.model.Brewery;

import java.util.List;

public interface BreweryDao {

    List<Brewery> getAllBrewery();

//    Brewery getBreweryByStreetName(String streetName);


    Brewery getBreweryByZipCode(String zipCode);
//
//    List<Brewery> getBreweryByBeerId(int beerId);

    Brewery getBreweryByName(String name);

    void updateBrewery(Brewery brewery, int id);

    void createBrewery(Brewery newBrewery);
}


