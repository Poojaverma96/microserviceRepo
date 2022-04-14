package com.product.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.product.DAO.ProductDAO;
import com.product.pojo.Product;
@Service
public class ProductService implements ProductServiceInterface{
@Autowired
ProductDAO productDAO;
	public Product productAdd(Product product) {
		
		return productDAO.save(product);
	}
	@Override
	public List<Product> showAllProduct(){
		
		return productDAO.findAll();
	}
	
	public Product getByProductID(int productID){
	Optional<Product> data=productDAO.getByProductID(productID);
	return (Product) data.get();
	}
	@Override
	@Transactional
	public void deleteProductID(int productID) {
		productDAO.deleteProductID(productID);
		
	}
}