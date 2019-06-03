package com.how2java.tmall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.how2java.tmall.pojo.Order;
import com.how2java.tmall.pojo.OrderItem;
import com.how2java.tmall.service.OrderItemService;
import com.how2java.tmall.service.OrderService;
import com.how2java.tmall.service.ProductImageService;
@Service
public class OrderItemServiceImpl extends BaseServiceImpl implements OrderItemService{

	@Autowired
	ProductImageService productImageService;
	
	@Override
	public void fill(List<Order> orders) {
		for(Order order:orders)
			fill(order);
		
	}
	@Override
	public void fill(Order order) {
		List<OrderItem> orderItems = listByParent(order);
		order.setOrderItems(orderItems);
		
		float total = 0;
		int totalNumber = 0;
		for(OrderItem oi : orderItems) {
			total += oi.getNumber()*oi.getProduct().getPromotePrice();
			totalNumber += oi.getNumber();
			productImageService.setFirstProductImage(oi.getProduct());
		}
		order.setTotal(total);
		order.setOrderItems(orderItems);
		order.setTotalNumber(totalNumber);
	}
}
