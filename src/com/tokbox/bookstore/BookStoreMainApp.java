package com.tokbox.bookstore;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main method for application
 * @author shivani
 *
 */
public class BookStoreMainApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigDecimal initialPrice = BigDecimal.ZERO;
		BigDecimal discount = BigDecimal.ZERO;
		BigDecimal floorPrice = BigDecimal.ZERO;
		BigDecimal budget = BigDecimal.ZERO;
		try {
			System.out.print("Enter initial book price:> ");
			initialPrice = sc.nextBigDecimal();
			System.out.print("Enter discount amount:> ");
			discount = sc.nextBigDecimal();
			System.out.print("Enter floor price :> ");
			floorPrice = sc.nextBigDecimal();
			System.out.print("Enter budget amount:> ");
			budget = sc.nextBigDecimal();
		} catch (InputMismatchException e) {
			throw new RuntimeException(
					"Incorrect input. Please enter <initialPrice> <discount> <floorPrice> <budget> ");
		}
		if (initialPrice.compareTo(floorPrice) < 0) {
			throw new RuntimeException(
					"Initial amount cannot be less than floor price");
		}

		BookStoreVO bookStoreVO = new BookStoreVO(initialPrice, discount,
				floorPrice, budget);
		BookStore bookStore = new BookStore(bookStoreVO);
		bookStoreVO = bookStore.purchaseBooks();
		System.out.println("\n\nNumber of books can be purchased: "
				+ bookStoreVO.getBookPurchaseCount());
		System.out.println("Remaining amount: "
				+ bookStoreVO.getRemainingAmount());

	}

	/**
	 * This method is to calculate number of books and remaining amount based on
	 * input values <b>This can be exposed to outside world</b>
	 * @param initialPrice
	 * @param discount
	 * @param floorPrice
	 * @param budget
	 */
	public void purchaseBooks(BigDecimal initialPrice, BigDecimal discount,
			BigDecimal floorPrice, BigDecimal budget) {

		BookStoreVO bookStoreVO = new BookStoreVO(initialPrice, discount,
				floorPrice, budget);
		BookStore bookStore = new BookStore(bookStoreVO);
		bookStoreVO = bookStore.purchaseBooks();
		System.out.println("Number of books sold: "
				+ bookStoreVO.getBookPurchaseCount());
		System.out.println("Remaining amount: "
				+ bookStoreVO.getRemainingAmount());

	}

}
