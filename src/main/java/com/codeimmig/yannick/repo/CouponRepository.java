package com.codeimmig.yannick.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeimmig.yannick.entity.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Long> {

}
