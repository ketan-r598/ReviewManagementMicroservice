package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Review;
import com.project.service.ReviewService;

@RestController
public class ReviewController {

	@Autowired
	private ReviewService service;
	
	@PostMapping("/users/reviews/comment")
	public Review addReview(@RequestBody Review review) {
		return service.addReview(review);
	}
	
	@PutMapping("/users/reviews/editRatings/{reviewId}")
	public Review editReview(@PathVariable("reviewId") int reviewId, @RequestBody Review review) {
		return service.editReview(reviewId, review);
		
	}
	
	@DeleteMapping("/users/reviews/remove/{reviewId}")
	public void deleteReview(@PathVariable int reviewId) {
		service.deleteReview(reviewId);
	}
}