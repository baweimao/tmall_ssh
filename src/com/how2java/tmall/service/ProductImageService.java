package com.how2java.tmall.service;

import java.util.List;

import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.pojo.ProductImage;

public interface ProductImageService extends BaseService{

	public static final String type_single = "type_single";
	public static final String type_detail = "type_detail";
		
	public void setFirstProductImage(Product product);
}
