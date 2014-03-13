package com.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.service.ProductsService;
@Controller
@Scope("prototype")
public class ProductsAction{
	@Resource
	ProductsService productsService;

	public String findProductInfo(){
		productsService.findProductsInfo();
		return "success";
	}
	
	
	public ProductsService getProductsService() {
		return productsService;
	}

	public void setProductsService(ProductsService productsService) {
		this.productsService = productsService;
	}
}
