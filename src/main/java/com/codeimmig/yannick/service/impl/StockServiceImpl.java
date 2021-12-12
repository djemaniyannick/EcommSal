package com.codeimmig.yannick.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeimmig.yannick.entity.Stock;
import com.codeimmig.yannick.repo.StockRepository;
import com.codeimmig.yannick.service.IStockService;

@Service
public class StockServiceImpl implements IStockService {

	@Autowired
	private StockRepository repo;
	
	public Long createStock(Stock stock) {
		return repo.save(stock).getId();
	}

	@Transactional
	public void updateStock(Long id, Long count) {
		repo.updateStock(id, count);
	}

	public List<Stock> getStockDetails() {
		return repo.findAll();
	}
	
	public Long getStockIdByProduct(Long productId) {
		return repo.getStockIdByProduct(productId);
	}

}

