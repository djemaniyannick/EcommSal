package com.codeimmig.yannick.service;

import java.util.List;
import com.codeimmig.yannick.entity.Coupon;

public interface ICoupon {
	Long saveCoupon(Coupon c);
	void deleteCoupon(Long id );
	void updateCoupon(Coupon c);
	Coupon getOneCoupon(Long id);
	List<Coupon> getAllCoupons();

}
