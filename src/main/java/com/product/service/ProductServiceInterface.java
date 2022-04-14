package com.product.service;

import java.util.List;

import com.product.pojo.Product;


public interface ProductServiceInterface {
	public  Product productAdd(Product product);

	public List<Product> showAllProduct();
	public Product getByProductID(int productID);
	public  void deleteProductID(int productID);
	
}
