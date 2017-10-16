package com.test.tokbox.testbookstore;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import com.tokbox.bookstore.BookStore;
import com.tokbox.bookstore.BookStoreVO;

public class BookStoreTest {

	@Test
	public void test1() {
		BigDecimal initialPrice = new BigDecimal(50);
		BigDecimal discount = new BigDecimal(4);
		BigDecimal floorPrice = new BigDecimal(25);
		BigDecimal budget = new BigDecimal(300);
		int expectedBookCount = 8;
		BigDecimal expectedRemainingAmount = new BigDecimal(9);

		runTest(initialPrice, discount, floorPrice, budget, expectedBookCount,expectedRemainingAmount);
		
	}

	@Test
	public void test2() {
		BigDecimal initialPrice = new BigDecimal(50);
		BigDecimal discount = new BigDecimal(4);
		BigDecimal floorPrice = new BigDecimal(25);
		BigDecimal budget = new BigDecimal(600);
		int expectedBookCount = 20;
		BigDecimal expectedRemainingAmount = new BigDecimal(9);

		runTest(initialPrice, discount, floorPrice, budget, expectedBookCount,expectedRemainingAmount);

	}

	@Test
	public void test3() {
		BigDecimal initialPrice = BigDecimal.ONE;
		BigDecimal discount = BigDecimal.ONE;
		BigDecimal floorPrice = BigDecimal.ONE;
		BigDecimal budget = BigDecimal.ONE;
		int expectedBookCount = 1;
		BigDecimal expectedRemainingAmount = BigDecimal.ZERO;

		runTest(initialPrice, discount, floorPrice, budget, expectedBookCount,expectedRemainingAmount);

	}

	@Test
	public void test4() {
		BigDecimal initialPrice = new BigDecimal(25);
		BigDecimal discount = new BigDecimal(1.5);
		BigDecimal floorPrice = new BigDecimal(10);
		BigDecimal budget = new BigDecimal(105);
		int expectedBookCount = 4;
		BigDecimal expectedRemainingAmount = new BigDecimal(14);
		runTest(initialPrice, discount, floorPrice, budget, expectedBookCount,expectedRemainingAmount);
	}
	
	@Test
	public void test5() {
		BigDecimal initialPrice = new BigDecimal(10);
		BigDecimal discount = new BigDecimal(1.5);
		BigDecimal floorPrice = new BigDecimal(10);
		BigDecimal budget = new BigDecimal(105);
		int expectedBookCount = 10;
		BigDecimal expectedRemainingAmount = new BigDecimal(5);
		runTest(initialPrice, discount, floorPrice, budget, expectedBookCount,expectedRemainingAmount);
	
	}

	@Test
	public void test6() {
		BigDecimal initialPrice = new BigDecimal(60);
		BigDecimal discount = new BigDecimal(3.5);
		BigDecimal floorPrice = new BigDecimal(40);
		BigDecimal budget = new BigDecimal(1000);
		int expectedBookCount = 23;
		BigDecimal expectedRemainingAmount = new BigDecimal(12.5);
		runTest(initialPrice, discount, floorPrice, budget, expectedBookCount,expectedRemainingAmount);
	
	}

	@Test
	public void test7() {
		BigDecimal initialPrice = new BigDecimal(25);
		BigDecimal discount = new BigDecimal(3.5);
		BigDecimal floorPrice = new BigDecimal(20);
		BigDecimal budget = new BigDecimal(250);
		int expectedBookCount = 12;
		BigDecimal expectedRemainingAmount = new BigDecimal(3.5);
		runTest(initialPrice, discount, floorPrice, budget, expectedBookCount,expectedRemainingAmount);
	
	}
	
	@Test
	public void testWithAllZeroes() {
		BigDecimal initialPrice = BigDecimal.ZERO;
		BigDecimal discount = BigDecimal.ZERO;
		BigDecimal floorPrice = BigDecimal.ZERO;
		BigDecimal budget = BigDecimal.ZERO;
		int expectedBookCount = 0;
		BigDecimal expectedRemainingAmount = BigDecimal.ZERO;
		runTest(initialPrice, discount, floorPrice, budget, expectedBookCount,expectedRemainingAmount);
	
	}

	@Test
	public void testExceptionNullInitialPrice() {
		BigDecimal initialPrice = null;
		BigDecimal discount = BigDecimal.ZERO;
		BigDecimal floorPrice = BigDecimal.ZERO;
		BigDecimal budget = BigDecimal.ZERO;
		String expectedMessage = "Incorrect initial amount";
		String actualMessage = null;
		BookStoreVO testVO = new BookStoreVO(initialPrice, discount, floorPrice, budget);
		BookStore bookStore = new BookStore(testVO);
		try {
			testVO = bookStore.purchaseBooks();
		} catch (Exception e) {
			actualMessage = e.getMessage();
			
		}
		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	public void testExceptionInvalidInitialPrice() {
		BigDecimal initialPrice = new BigDecimal(-1);
		BigDecimal discount = BigDecimal.ZERO;
		BigDecimal floorPrice = BigDecimal.ZERO;
		BigDecimal budget = BigDecimal.ZERO;
		String expectedMessage = "Incorrect initial amount";
		String actualMessage = null;
		BookStoreVO testVO = new BookStoreVO(initialPrice, discount, floorPrice, budget);
		BookStore bookStore = new BookStore(testVO);
		try {
			testVO = bookStore.purchaseBooks();
		} catch (Exception e) {
			actualMessage = e.getMessage();
			
		}
		assertEquals(expectedMessage, actualMessage);
	}
	
	private void runTest(BigDecimal initialPrice, BigDecimal discount,
			BigDecimal floorPrice, BigDecimal budget, int expectedBookCount,
			BigDecimal expectedRemainingAmount) {
		BookStoreVO testVO = new BookStoreVO(initialPrice, discount, floorPrice, budget);
		BookStore bookStore = new BookStore(testVO);
		testVO = bookStore.purchaseBooks();
		assertEqualsPurshaceCount(expectedBookCount, testVO.getBookPurchaseCount());
		assertEqualsRemainingAmount(expectedRemainingAmount, testVO.getRemainingAmount());
	}
	
	private void assertEqualsPurshaceCount(int expectedvalue, int actualValue){
		assertEquals("Purchase count should be " + expectedvalue,  expectedvalue, actualValue);

	}
	private void assertEqualsRemainingAmount(BigDecimal expectdvalue, BigDecimal actualvalue) {
		assertEquals("Remaining amount should be "+expectdvalue, expectdvalue.compareTo(actualvalue), 0);
	}
	
}
