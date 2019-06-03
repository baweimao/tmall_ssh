package com.how2java.tmall.action;

import java.lang.reflect.Method;

import org.apache.commons.lang.xwork.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.how2java.tmall.service.CategoryService;
import com.how2java.tmall.service.OrderItemService;
import com.how2java.tmall.service.OrderService;
import com.how2java.tmall.service.ProductImageService;
import com.how2java.tmall.service.ProductService;
import com.how2java.tmall.service.PropertyService;
import com.how2java.tmall.service.PropertyValueService;
import com.how2java.tmall.service.ReviewService;
import com.how2java.tmall.service.UserService;

public class Action4Service extends Action4Pojo{

	@Autowired
	CategoryService categoryService;
	
	@Autowired
	PropertyService propertyService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	ProductImageService productImageService;
	
	@Autowired
	PropertyValueService propertyValueService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	OrderItemService orderItemService;
	
	@Autowired
	ReviewService reviewService;
	
	/**
	 * transient to persistent
	 *b瞬时对象转换为持久层
	 * @param o
	 */
	public void t2p(Object o) {
		Class clazz = o.getClass();
		try {
			int id = (Integer)clazz.getMethod("getId").invoke(o);
			Object persistentBean = categoryService.get(clazz, id);
			
			String beanName = clazz.getSimpleName();
			Method setMethod = getClass().getMethod("set" + WordUtils.capitalize(beanName), clazz);
			setMethod.invoke(this, persistentBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
