package com.techelevator.model;

public class Reviews {
    private int reviewsId;
    private String reviewsText;
    private int starRating;

    public Reviews(int reviewsId, String reviewsText, int starRating) {
        this.reviewsId = reviewsId;
        this.reviewsText = reviewsText;
        this.starRating = starRating;
    }

    public Reviews() {
    }

    public int getReviewsId() {
        return reviewsId;
    }

    public void setReviewsId(int reviewsId) {
        this.reviewsId = reviewsId;
    }

    public String getReviewsText() {
        return reviewsText;
    }

    public void setReviewsText(String reviewsText) {
        this.reviewsText = reviewsText;
    }

    public int getStarRating() {
        return starRating;
    }

    public void setStarRating(int starRating) {
        this.starRating = starRating;
    }
}
