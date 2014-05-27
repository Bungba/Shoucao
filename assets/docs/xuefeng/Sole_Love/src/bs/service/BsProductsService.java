package bs.service;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.model.Products;


import bs.dao.BsProductsDao;

@Service
public class BsProductsService {
	@Resource
	BsProductsDao bsProductsDao;
	public Products findProductsName(int id){
		return bsProductsDao.findProductsName(id);
	}
	public List<Products> findProducts(){
		return bsProductsDao.findProducts();
	}
	public boolean updateProducts(Products products){
		return bsProductsDao.updateProducts(products);
	}
	public boolean delproducts(Products p){
		return bsProductsDao.delproducts(p);
	}
}
