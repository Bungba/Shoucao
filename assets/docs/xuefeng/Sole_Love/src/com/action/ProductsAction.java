package com.action;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.model.Products;
import com.service.ProductsService;

@Controller
@Scope("prototype")
public class ProductsAction {
	@Resource
	ProductsService productsService;

	// 返回数据
	
	private String result;
	private String error;

	public String findProductInfo() {
		List<Products> list = productsService.findProductsInfo();
		JSONArray ja = JSONArray.fromObject(list);
		result = ja.toString();
		error = "{\"message\":\"无错误\"}";
		return "success";
	}

	public ProductsService getProductsService() {
		return productsService;
	}

	public void setProductsService(ProductsService productsService) {
		this.productsService = productsService;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}
