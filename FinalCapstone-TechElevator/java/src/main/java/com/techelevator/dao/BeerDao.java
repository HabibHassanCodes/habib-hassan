package com.techelevator.dao;

import com.techelevator.model.Beer;
import com.techelevator.model.Brewery;

import java.util.List;

public interface BeerDao {
    List<Beer>getAllBeer();
    Beer getBeerByName(String beerName);
    List<Beer> getBeerByBreweryId(int breweryId);
    String addBeerInfo(String beerName, String beerDescription, int beerPrice, String beerType);
    Beer createBeer(Beer newBeer);
   // void deleteBeer(String beerName);
    void deleteBeer(int beerID);

}
