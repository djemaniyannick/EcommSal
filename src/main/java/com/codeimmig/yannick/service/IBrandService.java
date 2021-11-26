package com.codeimmig.yannick.service;

import java.util.List;
import java.util.Map;
import com.codeimmig.yannick.entity.Brand;

public interface IBrandService {
		Long saveBrand(Brand b);
		void updateBrand(Brand b);
		void deleteBrand(Long id);
		Brand getOneBrand(Long id);
		List<Brand> getAllBrands();
		Map<Long,String> getBrandIdAndName();
	


}
