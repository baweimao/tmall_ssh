package com.how2java.tmall.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.pojo.ProductImage;
import com.how2java.tmall.service.ProductImageService;

@Service
public class ProductImageServiceImpl extends BaseServiceImpl implements ProductImageService{

	@Override
	public void setFirstProductImage(Product product) {
		if(null!=product.getFirstProductImage())
			return;
		List<ProductImage> pis = list("product", product, "type", ProductImageService.type_single);
		if(!pis.isEmpty())
			product.setFirstProductImage(pis.get(0));
	}

}
