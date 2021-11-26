package com.codeimmig.yannick.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeimmig.yannick.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Long>{

}
