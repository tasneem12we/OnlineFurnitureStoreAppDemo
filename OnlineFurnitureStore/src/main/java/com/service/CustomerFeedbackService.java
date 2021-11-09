package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entity.Review;
import com.exception.CustomerFeedbackException;
import com.repository.FeedbackRepository;
import java.util.List;


@Service

public class CustomerFeedbackService implements ICustomerFeedbackService {

	@Autowired
	FeedbackRepository feedbackRepository;

	//To add Review to the database 
	public Review addReview(Review review) throws CustomerFeedbackException 
	{
		Review addReview = feedbackRepository.save(review);
		return addReview;
		
	}
	
	//To update Review details to the database
	public Review updateReview(int feedBackId, Review review) throws CustomerFeedbackException
	{
		Review updReview;
		Review resultReview = feedbackRepository.findById(review.getFeedBackId()).orElse(null);
		try {

			if (resultReview!=null) {
				updReview = feedbackRepository.save(review);
			} else {
				throw new CustomerFeedbackException("Id no found");
			}
		} catch (Exception e) {
			throw new CustomerFeedbackException("id not found");
		}
		return updReview;
	}
	
	//To fetch Review details from the database
	public Review viewReview(int feedBackId) throws CustomerFeedbackException {

		Review getReview;
		try {
			
			getReview = feedbackRepository.findById(feedBackId).orElse(null);
			if (getReview.getFeedBackId() == feedBackId) {
				getReview = feedbackRepository.findById(feedBackId).orElse(null);
			} else {
				throw new CustomerFeedbackException("Id is not found");
			}
		} catch (Exception e) {
			throw new CustomerFeedbackException("Id is not found");
		}
		return getReview;
	}
	
	//To fetch all Review details from the database 
	public List<Review> viewAllReview() throws CustomerFeedbackException {
		List<Review> getReview;
		try {
			getReview = feedbackRepository.findAll();
			if (!getReview.isEmpty()) {
				return getReview;
			} else {
				throw new CustomerFeedbackException("There is no values in thre review");
			}
		} catch (Exception e) {
			throw new CustomerFeedbackException("There is no value in the review");
		}
	}
	

}
