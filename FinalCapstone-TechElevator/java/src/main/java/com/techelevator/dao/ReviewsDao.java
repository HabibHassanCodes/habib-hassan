package com.techelevator.dao;

import com.techelevator.model.Brewery;
import com.techelevator.model.Reviews;

import java.util.List;

public interface ReviewsDao {

    //need to confirm list or object
    Reviews getReviewsByBeerId(int beer_id);
    Reviews getReviewsByStarRating(int stars);
   // String addReviewsByBeerId(int beerId, String reviewText, int rating);

//    void addReview(Reviews formData);
//    void addReview(Reviews newReview);
    String addReviewsByBeerId(String reviewText, int rating,int beerId);

}








