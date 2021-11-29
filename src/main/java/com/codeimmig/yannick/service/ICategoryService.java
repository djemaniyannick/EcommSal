package com.codeimmig.yannick.service;

import java.util.List;
import java.util.Map;

import com.codeimmig.yannick.entity.Category;

public interface ICategoryService {
	Long saveCategory(Category category);
	void updateCategory(Category category);
	void deleteCategory(Long id);
	Category getOneCategory(Long id);
	List<Category> getAllCategorys();
	Map<Long,String> getCategoryIdAndName(String status);

}
