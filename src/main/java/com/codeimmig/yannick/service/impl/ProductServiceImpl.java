package com.codeimmig.yannick.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeimmig.yannick.entity.Product;
import com.codeimmig.yannick.exception.ProductNotFoundException;
import com.codeimmig.yannick.repo.ProductRepository;
import com.codeimmig.yannick.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ProductRepository repo;

	public Long saveProduct(Product p) {
		return repo.save(p).getId();
	}

	public void updateProduct(Product p) {
		if(p.getId()==null || !repo.existsById(p.getId()))
			throw new ProductNotFoundException("Product Not Found");
		else
			repo.save(p);
	}

	public void deleteProduct(Long id) {
		repo.delete(getOneProduct(id));
	}

	public Product getOneProduct(Long id) {
		return repo.findById(id)
				.orElseThrow(()->new ProductNotFoundException("Product Not Found"));
	}

	public List<Product> getAllProducts() {
		return repo.findAll();
	}

}
