package com.techelevator.controller;

import com.techelevator.dao.BeerDao;
import com.techelevator.dao.ReviewsDao;
import com.techelevator.model.Beer;
import com.techelevator.model.Brewery;
import com.techelevator.model.Reviews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@CrossOrigin
public class ReviewsController {
    @Autowired
    private ReviewsDao reviewsDao;

    @Autowired
    public ReviewsController(ReviewsDao reviewsDao) {
        this.reviewsDao = reviewsDao;
    }

    @RequestMapping(path = "/reviews/{beer_id}", method = RequestMethod.GET)
    public Reviews getReviewsByBeerId(@PathVariable int beer_id) {
        Reviews output = reviewsDao.getReviewsByBeerId(beer_id);
        return output;
    }

    @RequestMapping(path = "/rev/{stars}", method = RequestMethod.GET)
    public Reviews getReviewsByStarRating(@PathVariable int stars) {
        Reviews output = reviewsDao.getReviewsByStarRating(stars);
        return output;
    }

    @ResponseBody
    @RequestMapping(path = "/beer/reviews/{beerId}", method = RequestMethod.POST)
    public String  addReviewsByBeerId(@RequestBody Reviews reviews,@PathVariable int beerId) {
        return reviewsDao.addReviewsByBeerId(reviews.getReviewsText(), reviews.getStarRating(),beerId);
    }
    }
