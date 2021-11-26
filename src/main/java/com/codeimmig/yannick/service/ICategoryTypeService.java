package com.codeimmig.yannick.service;

import java.util.List;
import java.util.Map;

import com.codeimmig.yannick.entity.CategoryType;

public interface ICategoryTypeService {
	Long saveCategoryType(CategoryType categorytype);
	void updateCategoryType(CategoryType categorytype);
	void deleteCategoryType(Long id);
	CategoryType getOneCategoryType(Long id);
	List<CategoryType> getAllCategoryTypes();
	
	Map<Integer,String> getCategoryTypeIdAndName();
}
