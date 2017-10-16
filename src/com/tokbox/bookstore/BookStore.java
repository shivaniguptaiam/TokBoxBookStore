package com.tokbox.bookstore;

import java.math.BigDecimal;

/**
 * This class has a core logic of book purchase calculation
 * @author shivani
 *
 */
public class BookStore {

	BookStoreVO bookStoreVO;


	public BookStore(BookStoreVO bookStoreVO) {
		this.bookStoreVO = bookStoreVO;
	}

	/**
	 * Method to calculate number of books can be purchased with in given budget
	 * @return bookStoreVO
	 */
	public BookStoreVO purchaseBooks() {
		//Validate inputs
		validateInputs();
		int bookPurchaseCount = 0;
		BigDecimal remainingAmount = bookStoreVO.getBudget();
		BigDecimal currentBookPrice = bookStoreVO.getInitialPrice();
		BigDecimal discount = bookStoreVO.getDiscount();
		BigDecimal floorPrice = bookStoreVO.getFloorPrice();
		
		/*
		 * This loop will run until remaining amount is less than the current book price
		 */
		
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
	
	private void validateInputs(){
		//Validations
		if (bookStoreVO.getBudget() ==null || bookStoreVO.getBudget().compareTo(BigDecimal.ZERO) < 0){
			throw new RuntimeException("Incorrect budget amount");
		}
		if (bookStoreVO.getInitialPrice() ==null || bookStoreVO.getInitialPrice().compareTo(BigDecimal.ZERO) < 0){
			throw new RuntimeException("Incorrect initial amount");
		}
		if (bookStoreVO.getDiscount() ==null || bookStoreVO.getDiscount().compareTo(BigDecimal.ZERO) < 0){
			throw new RuntimeException("Incorrect discount amount");
		}
		if (bookStoreVO.getFloorPrice() ==null || bookStoreVO.getFloorPrice().compareTo(BigDecimal.ZERO) < 0){
			throw new RuntimeException("Incorrect floor amount");
		}
		
	}
}
