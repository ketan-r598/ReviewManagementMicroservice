package com.project.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.project.model.Review;
import com.project.repository.ReviewRepository;

class ReviewServiceTests {

    @Mock
    private ReviewRepository reviewRepository;

    @InjectMocks
    private ReviewServiceImpl reviewService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddReview() {
        Review review = new Review();
        review.setReviewId(1);
        review.setHotelId(1);
        review.setUserId(1);
        review.setRating(4.5f);
        review.setComment("Great hotel!");
        review.setDate("2021-12-01");

        when(reviewRepository.save(review)).thenReturn(review);

        Review result = reviewService.addReview(review);

        assertNotNull(result);
//        assertEquals(review, result);
        verify(reviewRepository, times(1)).save(review);
    }

    @Test
    void testEditReview() {
        int reviewId = 1;

        Review review = new Review();
        review.setReviewId(reviewId);
        review.setHotelId(1);
        review.setUserId(1);
        review.setRating(4.5f);
        review.setComment("Great hotel!");
        review.setDate("2021-12-01");

        when(reviewRepository.findById(reviewId)).thenReturn(Optional.of(review));
        when(reviewRepository.save(review)).thenReturn(review);

        Review updatedReview = new Review();
        updatedReview.setReviewId(reviewId);
        updatedReview.setHotelId(1);
        updatedReview.setUserId(1);
        updatedReview.setRating(5.0f);
        updatedReview.setComment("Awesome hotel!");
        updatedReview.setDate("2021-12-01");

        Review result = reviewService.editReview(reviewId, updatedReview);

        assertNotNull(result);
//        assertEquals(updatedReview, result);
        verify(reviewRepository, times(1)).save(review);
    }

    @Test
    void testDeleteReview() {
        int reviewId = 1;

        reviewService.deleteReview(reviewId);

        verify(reviewRepository, times(1)).deleteById(reviewId);
    }

    @Test
    void testGetAllReviews() {
        Review review1 = new Review();
        review1.setReviewId(1);
        review1.setHotelId(1);
        review1.setUserId(1);
        review1.setRating(4.5f);
        review1.setComment("Great hotel!");
        review1.setDate("2021-12-01");

        Review review2 = new Review();
        review2.setReviewId(2);
        review2.setHotelId(2);
        review2.setUserId(2);
        review2.setRating(3.5f);
        review2.setComment("Good hotel!");
        review2.setDate("2021-12-02");

        List<Review> reviews = new ArrayList<>();
        reviews.add(review1);
        reviews.add(review2);

        when(reviewRepository.findAll()).thenReturn(reviews);

        List<Review> result = reviewService.getAllReviews();

        assertNotNull(result);
        assertEquals(reviews, result);
        verify(reviewRepository, times(1)).findAll();
    }
}

