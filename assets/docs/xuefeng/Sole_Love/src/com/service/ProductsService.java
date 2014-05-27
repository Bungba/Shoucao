package com.service;

import java.util.List;

import javax.annotation.Resource;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.springframework.stereotype.Service;

import com.dao.ProductsDao;
import com.model.Orderdetails;
import com.model.Products;

@Service
public class ProductsService {
	@Resource
	ProductsDao productsDao;

	public List<Products> findProductsInfo() {
		return productsDao.findProductsInfo();
	}

	public List<Products> findProductsInfo(List<Orderdetails> detailsList) {
		return productsDao.findProductsInfo(detailsList);
	}
}
