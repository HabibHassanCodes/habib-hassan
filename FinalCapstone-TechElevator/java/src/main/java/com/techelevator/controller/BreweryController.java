package com.techelevator.controller;

import com.techelevator.dao.BreweryDao;
import com.techelevator.model.Beer;
import com.techelevator.model.Brewery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@CrossOrigin
public class BreweryController {
    @Autowired
    private BreweryDao breweryDao;
    @Autowired
    public BreweryController(BreweryDao breweryDao){
        this.breweryDao = breweryDao;
    }
    @RequestMapping(path="/allBrewery", method= RequestMethod.GET)
    public List<Brewery> getAllBrewery(){
        List<Brewery> output = breweryDao.getAllBrewery();
        return output;
    }
//    @RequestMapping(path="/street/{streetName}", method= RequestMethod.GET)
//    public Brewery getBreweryByStreetName(@PathVariable String streetName){
//        Brewery output = breweryDao.getBreweryByStreetName(streetName);
//        return output;
//    }
    @RequestMapping(path="/brewery/{zipCode}", method= RequestMethod.GET)
    public Brewery getBreweryByZipCode(@PathVariable String zipCode){
        Brewery output = breweryDao.getBreweryByZipCode(zipCode);
        return output;
    }

    @RequestMapping(path="brewery/name/{breweryName}", method = RequestMethod.GET)
    public Brewery getBreweryByName(@PathVariable String breweryName) {
        Brewery output = breweryDao.getBreweryByName(breweryName);
        return output;
    }

//    @RequestMapping(path="/location/{beerId}", method= RequestMethod.GET)
//    public List<Brewery> getBreweryByBeerId(@PathVariable int beerId){
//        List<Brewery> output = breweryDao.getBreweryByBeerId(beerId);
//        return output;
//    }
    //update
    //@PreAuthorize("isAuthenticated")
    @RequestMapping(path = "/brewery/{id}", method = RequestMethod.PUT)
    //this method will throw a reservation not found exception if it cannot update it
    //this exception will have a status code and a message
    public void updateBrewery(@Valid @RequestBody Brewery brewery, @PathVariable int id) {
        breweryDao.updateBrewery(brewery, id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path="/brewery", method= RequestMethod.POST)
    public void create(@Valid @RequestBody Brewery newBrewery) {
        breweryDao.createBrewery(newBrewery);
    }

}
