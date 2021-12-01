package com.codeimmig.yannick.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeimmig.yannick.entity.Shipping;
import com.codeimmig.yannick.exception.ShippingNotFoundException;
import com.codeimmig.yannick.repo.ShippingRepository;
import com.codeimmig.yannick.service.IShippingService;

@Service
public class ShippingServiceImpl implements IShippingService {
	@Autowired
	private ShippingRepository repo;

	public Long saveShipping(Shipping shipping) {
		return repo.save(shipping).getId();
	}

	public void updateShipping(Shipping shipping) {
		if(shipping.getId()==null || !repo.existsById(shipping.getId()))
			throw new ShippingNotFoundException("Shipping Not exist");
		else
			repo.save(shipping);
	}

	public void deleteShipping(Long id) {
		repo.delete(getOneShipping(id));
	}


	public Shipping getOneShipping(Long id) {
		return repo.findById(id).orElseThrow(()->new ShippingNotFoundException("Shipping Not exist"));
	}

	public List<Shipping> getAllShippings() {
		return repo.findAll();
	}

}
