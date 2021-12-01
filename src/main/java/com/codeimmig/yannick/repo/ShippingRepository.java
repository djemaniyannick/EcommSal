package com.codeimmig.yannick.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeimmig.yannick.entity.Shipping;

public interface ShippingRepository extends JpaRepository<Shipping, Long> {

}
