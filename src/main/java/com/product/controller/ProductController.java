package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.pojo.Product;
import com.product.service.ProductService;


@RestController
@RequestMapping("/api")
public class ProductController {
	@Autowired
	ProductService productService;
	@PostMapping("/add/product")
	public Product productAdd(@RequestBody Product product) {
		return productService.productAdd(product);
		
	}
	
	@GetMapping("/all/product")
	public List<Product> showAllProduct() {
		return productService.showAllProduct();
	}
	@GetMapping("/show/id/{productID}")
	public Product getByProductID(@PathVariable("productID")int productID) {
		
		
		return productService.getByProductID(productID);
	}
		
	
	
	@DeleteMapping("/delete/id/{productID}")
	public String deleteProductID(@PathVariable("productID")int productID) {
		 
		productService.deleteProductID(productID);
		return "One record deleted sucssesfully \n  "
				+ "check record \n"
				+ "http://localhost:8888/api/all";
	}
	
	  @PutMapping("update/product/{productID}")
	    public Product updateProductID(@RequestBody Product product, @PathVariable("productID") int productID){
		  Product update= productService.getByProductID(productID);
	        update.setProductName(product.getProductName());
	        update.setProductType(product.getProductType());
	        update.setItem(product.getItem());
	        update.setAmount(product.getAmount());
	        return productService.productAdd(update);
	    }
	  
	 
	
	

}
