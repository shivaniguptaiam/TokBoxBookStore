package com.tokbox.bookstore;

import java.math.BigDecimal;

public class BookStore {

	BookStoreVO bookStoreVO;


	public BookStore(BookStoreVO bookStoreVO) {
		this.bookStoreVO = bookStoreVO;
	}

	public BookStoreVO purchaseBooks() {
		int bookPurchaseCount = 0;
		BigDecimal remainingAmount = bookStoreVO.getBudget();
		BigDecimal currentBookPrice = bookStoreVO.getInitialPrice();
		BigDecimal discount = bookStoreVO.getDiscount();
		BigDecimal floorPrice = bookStoreVO.getFloorPrice();
		
		while (remainingAmount.compareTo(currentBookPrice) >= 0) {
			bookPurchaseCount++;
			remainingAmount = remainingAmount.subtract(currentBookPrice);
			currentBookPrice = currentBookPrice.subtract(discount);
			if (currentBookPrice.compareTo(floorPrice) < 0) {
				currentBookPrice = floorPrice;
			}
		}
		bookStoreVO.setRemainingAmount(remainingAmount);
		bookStoreVO.setBookPurchaseCount(bookPurchaseCount);
		return bookStoreVO;
	}
}
