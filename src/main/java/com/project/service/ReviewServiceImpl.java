package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Review;
import com.project.repository.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewRepository repo;

	@Override
	public Review addReview(Review review) {

		return repo.save(review);
	}

	@Override
	public Review editReview(int reviewId, Review review) {
		Review r = repo.findById(reviewId).get();

		if (review.getRating() != 0) {
			r.setRating(review.getRating());
		}
		if ((review.getComment() != null) && (!"".equalsIgnoreCase(review.getComment()))) {
			r.setComment(review.getComment());
		}
		return repo.save(r);
	}

	@Override
	public void deleteReview(int reviewId) {
		repo.deleteById(reviewId);
	}

	@Override
	public List<Review> getAllReviews() {
		return repo.findAll();
	}

}
