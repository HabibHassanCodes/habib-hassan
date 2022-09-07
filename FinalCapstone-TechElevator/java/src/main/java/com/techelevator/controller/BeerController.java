package com.techelevator.controller;

import com.techelevator.dao.BeerDao;
import com.techelevator.model.Beer;
import com.techelevator.model.Brewery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class BeerController {
    @Autowired
    private BeerDao beerDao;
    @Autowired
    public BeerController(BeerDao beerDao){
        this.beerDao = beerDao;
    }

    @RequestMapping(path="/allBeer", method= RequestMethod.GET)
    public List<Beer> getAllBeer(){
        List<Beer> output = beerDao.getAllBeer();
        return output;
    }
    @RequestMapping(path="/beer/{beerName}", method= RequestMethod.GET)
    public Beer getBeerByName(@PathVariable String beerName){
        Beer output = beerDao.getBeerByName(beerName);
        return output;
    }

    @RequestMapping(path="/beerInfo/{brewerId}", method= RequestMethod.GET)
    public List<Beer> getBeerByBreweryId(@PathVariable int brewerId){
        List<Beer> output = beerDao.getBeerByBreweryId(brewerId);
        return output;
    }
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path="/newBeer", method= RequestMethod.POST)
    public Beer create(@Valid @RequestBody Beer newBeer) {
            return beerDao.createBeer(newBeer);
        }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/delete/{beerID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int beerID) {
        beerDao.deleteBeer(beerID);
    }


    @ResponseBody
    @RequestMapping(path = "/beer/createBeer", method = RequestMethod.POST)
    public  String beerInformation(@RequestBody Beer beer) {
        return  beerDao.addBeerInfo(beer.getBeerName(), beer.getBeerDescription(), beer.getBeerPrice(), beer.getBeerType());
    }




}
