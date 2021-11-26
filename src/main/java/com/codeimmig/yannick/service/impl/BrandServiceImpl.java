package com.codeimmig.yannick.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeimmig.yannick.entity.Brand;
import com.codeimmig.yannick.repo.BrandRepository;
import com.codeimmig.yannick.service.IBrandService;
import com.codeimmig.yannick.util.AppUtil;

@Service
public class BrandServiceImpl implements IBrandService {

	@Autowired
	private BrandRepository repo;
	
	public Long saveBrand(Brand b) {
		return repo.save(b).getId();
	}

	public void updateBrand(Brand b) {
		repo.save(b);
	}

	public void deleteBrand(Long id) {
		repo.deleteById(id);
	}

	public Brand getOneBrand(Long id) {
		Optional<Brand>  opt = repo.findById(id);
		if(opt.isPresent()) return opt.get();
		return null;
	}

	public List<Brand> getAllBrands() {
		return repo.findAll();
	}
	
	public Map<Long, String> getBrandIdAndName() {
		List<Object[]> list = repo.getBrandIdAndName();
		return AppUtil.convertListToMapLong(list);
	}

}

