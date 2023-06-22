package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Review;
import com.project.service.ReviewService;

@RestController
@RequestMapping("/reviews/")
public class ReviewController {

	@Autowired
	private ReviewService service;
	
	@PostMapping("customer/comment")
	public Review addReview(@RequestBody Review review) {
		return service.addReview(review);
	}
	
	@PutMapping("customer/editRatings/{reviewId}")
	public Review editReview(@PathVariable("reviewId") int reviewId, @RequestBody Review review) {
		return service.editReview(reviewId, review);
		
	}
	
	@DeleteMapping("customer/remove/{reviewId}")
	public void deleteReview(@PathVariable int reviewId) {
		service.deleteReview(reviewId);
	}
}