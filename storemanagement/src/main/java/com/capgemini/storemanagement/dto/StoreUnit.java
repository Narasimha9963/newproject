package com.capgemini.storemanagement.dto;

public class StoreUnit {

	private Integer storeId;

	private Integer no_of_items;

	private Integer productId;

	private Integer minimumStockMantain;

	public Integer getMinimumStockMantain() {
		return minimumStockMantain;
	}

	public void setMinimumStockMantain(Integer minimumStockMantain) {
		this.minimumStockMantain = minimumStockMantain;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public Integer getNo_of_items() {
		return no_of_items;
	}

	public void setNo_of_items(Integer no_of_items) {
		this.no_of_items = no_of_items;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "StoreUnit [storeId=" + storeId + ", no_of_items=" + no_of_items + ", productId=" + productId
				+ ", minimumStockMantain=" + minimumStockMantain + "]";
	}

}
