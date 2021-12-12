package com.codeimmig.yannick.service;

import java.util.List;

import com.codeimmig.yannick.entity.Stock;

public interface IStockService {
	Long createStock(Stock stock);
	void updateStock(Long id, Long count);
	Long getStockIdByProduct(Long productId);
	List<Stock> getStockDetails();
}
