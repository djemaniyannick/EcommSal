package com.codeimmig.yannick.service;

import java.util.List;

import com.codeimmig.yannick.entity.Shipping;

public interface IShippingService {
	Long saveShipping(Shipping shipping);

	void updateShipping(Shipping shipping);

	void deleteShipping(Long id);

	Shipping getOneShipping(Long id);

	List<Shipping> getAllShippings();


}
