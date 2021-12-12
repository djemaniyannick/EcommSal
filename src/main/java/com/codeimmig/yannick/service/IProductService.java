package com.codeimmig.yannick.service;

import java.util.List;
import java.util.Map;

import com.codeimmig.yannick.entity.Product;

public interface IProductService {
	Long saveProduct(Product p);
	void updateProduct(Product p);
	void deleteProduct(Long id);
	Product getOneProduct(Long id);
	List<Product> getAllProducts();
	Map<Long,String> getProductIdAndName();
}
