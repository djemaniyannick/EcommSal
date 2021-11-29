package com.codeimmig.yannick.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeimmig.yannick.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
