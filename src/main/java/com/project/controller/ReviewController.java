package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Review;
import com.project.service.ReviewService;

@RestController
@RequestMapping("/reviews/customer/")
public class ReviewController {

	@Autowired
	private ReviewService service;
	
	@PostMapping("comment")
	public Review addReview(@RequestBody Review review) {
		return service.addReview(review);
	}
	
	@PutMapping("editRatings/{reviewId}")
	public Review editReview(@PathVariable("reviewId") int reviewId, @RequestBody Review review) {
		return service.editReview(reviewId, review);
		
	}
	
	@DeleteMapping("remove/{reviewId}")
	public void deleteReview(@PathVariable int reviewId) {
		service.deleteReview(reviewId);
	}
	
	@GetMapping("getAll")
	public List<Review> getAllReview() {
		return service.getAllReviews();
	}
}