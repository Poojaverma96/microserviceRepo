package com.product.pojo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product implements Serializable {

/**
	 * 
	 */
	private static final long serialVersionUID = -5697432283659061883L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int productID;
@Column
private String productName;
@Column
private String productType;
@Column
private int item;
@Column
private long amount;
public int getProductID() {
	return productID;
}
public void setProductID(int productID) {
	this.productID = productID;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public String getProductType() {
	return productType;
}
public void setProductType(String productType) {
	this.productType = productType;
}


public int getItem() {
	return item;
}
public void setItem(int item) {
	this.item = item;
}
public long getAmount() {
	return amount;
}
public void setAmount(long amount) {
	this.amount = amount;
}



}
