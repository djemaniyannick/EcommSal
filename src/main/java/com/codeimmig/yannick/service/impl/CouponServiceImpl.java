package com.codeimmig.yannick.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeimmig.yannick.entity.Coupon;
import com.codeimmig.yannick.exception.CouponNotFoundException;
import com.codeimmig.yannick.repo.CouponRepository;
import com.codeimmig.yannick.service.ICoupon;

@Service
public class CouponServiceImpl implements ICoupon {
	@Autowired
	CouponRepository repo;

	@Override
	public Long saveCoupon(Coupon c) {
		
		return repo.save(c).getId();
	}

	@Override
	public void deleteCoupon(Long id) {
		repo.delete(getOneCoupon(id));
		
	}

	@Override
	public void updateCoupon(Coupon c) {
		repo.save(c);
		
	}

	@Override
	public Coupon getOneCoupon(Long id) {
		//Optional<Coupon> opt=repo.findById(id);
//		if(opt.isEmpty()) {
//			throw new CouponNotFoundException(" coupon not exist");
//		
//		}
//		return opt.get();
		return repo.findById(id).orElseThrow(()->new CouponNotFoundException("Coupon not found"));
	}

	@Override
	public List<Coupon> getAllCoupons() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
