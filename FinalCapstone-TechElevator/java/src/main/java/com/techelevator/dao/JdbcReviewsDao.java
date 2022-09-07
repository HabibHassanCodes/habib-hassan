package com.techelevator.dao;

import com.techelevator.model.Brewery;
import com.techelevator.model.Reviews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcReviewsDao implements ReviewsDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private JdbcReviewsDao jdbcReviewsDao;
    public JdbcReviewsDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Reviews getReviewsByBeerId(int beer_id) {
        //List<Reviews> list = new ArrayList<>();
        Reviews reviews = null;

        String sql = "SELECT review_id, beer_id, review_text, star_rating "+
                "FROM reviews WHERE beer_id = ?; ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, beer_id);
        if(results.next()) {
            reviews = mapRowToReviews(results);

        }
        return reviews;
    }


    @Override
    public Reviews getReviewsByStarRating(int stars) {
        //List<Reviews> list = new ArrayList<>();
        Reviews reviews = null;
        String sql = "SELECT review_id, beer_id, review_text, star_rating "+
                "FROM reviews WHERE star_rating = ?; ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, stars);
        if(results.next()) {
            reviews = mapRowToReviews(results);

        }
        return reviews;
    }

    @Override
    public String addReviewsByBeerId( String reviewText, int rating,int beerId) {
        String sql = "INSERT INTO reviews ( review_text, star_rating, beer_id) " +
                "VALUES (?,?, ?) ;";
        jdbcTemplate.update(sql,reviewText,rating,beerId);

        return "Reviews successfully added";
    }

//    @Override
//    public void addReview(Reviews formData) {
//
//    }
//    public void addReview(Reviews aReview) {
//        String newReview = "INSERT INTO reviews (beer_id, review_text, star_rating, username) " +
//                "VALUES (?, ?, ?, ?)";
//        jdbcTemplate.update(newReview, aReview.getBeer_id(), aReview.getReview_text(), aReview.getStar_rating(), aReview.getUsername());
//
//    }




    private Reviews mapRowToReviews(SqlRowSet results) {
        Reviews reviews = new Reviews();
        reviews.setReviewsId(results.getInt("review_id"));
        reviews.setReviewsText(results.getString("review_text"));
        reviews.setStarRating(results.getInt("star_rating"));
        return reviews;
    }

}
