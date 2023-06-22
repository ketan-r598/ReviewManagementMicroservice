package com.project.service;

import java.util.List;

import com.project.model.Review;

public interface ReviewService {
	public Review addReview(Review review);
	public Review editReview(int reviewId, Review review);
	public void deleteReview(int reviewId);
	public List<Review> getAllReviews();
}