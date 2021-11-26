package com.codeimmig.yannick.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codeimmig.yannick.entity.CategoryType;
import com.codeimmig.yannick.repo.CategoryTypeRepository;
import com.codeimmig.yannick.service.ICategoryTypeService;
import com.codeimmig.yannick.util.AppUtil;

@Service
public class CategoryTypeServiceImpl implements ICategoryTypeService {
	@Autowired
	private CategoryTypeRepository repo;

	@Override
	@Transactional
	public Long saveCategoryType(CategoryType categorytype) {
		return repo.save(categorytype).getId();
	}

	@Override
	@Transactional
	public void updateCategoryType(CategoryType categorytype) {
		repo.save(categorytype);
	}

	@Override
	@Transactional
	public void deleteCategoryType(Long id) {
		repo.deleteById(id);
	}

	@Override
	@Transactional(
			readOnly = true
			)
	public CategoryType getOneCategoryType(Long id) {
		return repo.findById(id).get();
	}

	@Override
	@Transactional(
			readOnly = true
			)
	public List<CategoryType> getAllCategoryTypes() {
		return repo.findAll();
	}
	
	@Override
	public Map<Integer, String> getCategoryTypeIdAndName() {
		List<Object[]>  list = repo.getCategoryTypeIdAndName();
		return AppUtil.convertListToMap(list);
	}

}
