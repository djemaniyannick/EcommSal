package com.codeimmig.yannick.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.codeimmig.yannick.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Long>{
	@Query("SELECT id, name FROM Category WHERE status=:status")
	List<Object[]> getCategoryIdAndName(String status);

}
