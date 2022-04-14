package com.product.DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.product.pojo.Product;
@Repository
public interface ProductDAO extends JpaRepository<Product, String>{
	
	@Query(value="SELECT * from Product  WHERE productID=?1",  nativeQuery = true)
	Optional<Product> getByProductID(int productID);
	
	@Modifying
	 @Query(value="delete from Product  WHERE productID=?1",  nativeQuery = true)
    void deleteProductID(@Param("productID") int productID);

}
