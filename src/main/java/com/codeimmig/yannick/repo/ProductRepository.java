package com.codeimmig.yannick.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.codeimmig.yannick.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	@Query("SELECT id,name FROM Product ")
	//@Query("SELECT id,name FROM Product WHERE status='ACTIVE'")
	List<Object[]> getProductIdAndNames();


}
