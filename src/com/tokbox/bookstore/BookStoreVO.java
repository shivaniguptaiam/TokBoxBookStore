package com.tokbox.bookstore;

import java.io.Serializable;
import java.math.BigDecimal;

public class BookStoreVO implements Serializable {

	BigDecimal initialPrice;
	BigDecimal discount;
	BigDecimal floorPrice;
	BigDecimal budget;
	
	//results
	int bookPurchaseCount;
	BigDecimal remainingAmount;

	public BookStoreVO(BigDecimal initialPrice, BigDecimal discount, BigDecimal floorPrice,
			BigDecimal budget) {
		super();
		this.initialPrice = initialPrice;
		this.discount = discount;
		this.floorPrice = floorPrice;
		this.budget = budget;
	}
	public BigDecimal getInitialPrice() {
		return initialPrice;
	}
	public void setInitialPrice(BigDecimal initialPrice) {
		this.initialPrice = initialPrice;
	}
	public BigDecimal getDiscount() {
		return discount;
	}
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
	public BigDecimal getFloorPrice() {
		return floorPrice;
	}
	public void setFloorPrice(BigDecimal floorPrice) {
		this.floorPrice = floorPrice;
	}
	public BigDecimal getBudget() {
		return budget;
	}
	public void setBudget(BigDecimal budget) {
		this.budget = budget;
	}
	public int getBookPurchaseCount() {
		return bookPurchaseCount;
	}
	public void setBookPurchaseCount(int bookPurchaseCount) {
		this.bookPurchaseCount = bookPurchaseCount;
	}
	public BigDecimal getRemainingAmount() {
		return remainingAmount;
	}
	public void setRemainingAmount(BigDecimal remainingAmount) {
		this.remainingAmount = remainingAmount;
	}

}
