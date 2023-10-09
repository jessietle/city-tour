package com.techelevator.model;

public class Review {
    private int reviewId;
    private int attractionId;
    private String reviewNote;

    public Review () {}

    public Review(int reviewId, int attractionId, String reviewNote) {
        this.reviewId = reviewId;
        this.attractionId = attractionId;
        this.reviewNote = reviewNote;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getAttractionId() {
        return attractionId;
    }

    public void setAttractionId(int attractionId) {
        this.attractionId = attractionId;
    }

    public String getReviewNote() {
        return reviewNote;
    }

    public void setReviewNote(String reviewNote) {
        this.reviewNote = reviewNote;
    }
}
