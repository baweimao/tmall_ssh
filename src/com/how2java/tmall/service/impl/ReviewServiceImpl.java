package com.how2java.tmall.service.impl;

import org.springframework.stereotype.Service;

import com.how2java.tmall.pojo.Order;
import com.how2java.tmall.pojo.Review;
import com.how2java.tmall.service.ReviewService;

@Service
public class ReviewServiceImpl extends BaseServiceImpl implements ReviewService{

	@Override
	public void saveReviewAndUpdateOrderStatus(Review review, Order order) {
		save(review);
		update(order);
	}
}
