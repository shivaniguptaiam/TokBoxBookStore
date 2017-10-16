package com.test.tokbox.testbookstore;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import com.tokbox.bookstore.BookStore;
import com.tokbox.bookstore.BookStoreVO;

public class BookStoreTest {

	@Test
	public void test0() {
		BookStoreVO testVO = new BookStoreVO(new BigDecimal(50), new BigDecimal(4), new BigDecimal(25), new BigDecimal(300));
		BookStore bookStore = new BookStore(testVO);
		testVO = bookStore.purchaseBooks();
		assertEqualsPurshaceCount(8, testVO.getBookPurchaseCount());
		assertEqualsRemainingAmount(new BigDecimal(9), testVO.getRemainingAmount());
		
	}

	@Test
	public void test1() {
		BookStoreVO testVO = new BookStoreVO(new BigDecimal(50), new BigDecimal(4), new BigDecimal(25), new BigDecimal(600));
		BookStore bookStore = new BookStore(testVO);
		testVO = bookStore.purchaseBooks();
		assertEqualsPurshaceCount(20, testVO.getBookPurchaseCount());
		assertEqualsRemainingAmount(new BigDecimal(9.0), testVO.getRemainingAmount());
		
	}

	@Test
	public void test2() {
		BookStoreVO testVO = new BookStoreVO(new BigDecimal(1), new BigDecimal(1), new BigDecimal(1), new BigDecimal(1));
		BookStore bookStore = new BookStore(testVO);
		testVO = bookStore.purchaseBooks();
		assertEqualsPurshaceCount(1, testVO.getBookPurchaseCount());
		assertEqualsRemainingAmount(new BigDecimal(0), testVO.getRemainingAmount());

	}

	@Test
	public void test3() {
		BookStoreVO testVO = new BookStoreVO(new BigDecimal(25), new BigDecimal(1.5), new BigDecimal(10), new BigDecimal(105));
		BookStore bookStore = new BookStore(testVO);
		testVO = bookStore.purchaseBooks();
		assertEqualsPurshaceCount(4, testVO.getBookPurchaseCount());
		assertEqualsRemainingAmount( new BigDecimal(14.0), testVO.getRemainingAmount());
		
	}
	
	@Test
	public void test4() {
		BookStoreVO testVO = new BookStoreVO(new BigDecimal(10), new BigDecimal(1.5), new BigDecimal(10), new BigDecimal(105));
		BookStore bookStore = new BookStore(testVO);
		testVO = bookStore.purchaseBooks();
		assertEqualsPurshaceCount(10, testVO.getBookPurchaseCount());
		assertEqualsRemainingAmount( new BigDecimal(5), testVO.getRemainingAmount());
		
	}
	
	private void assertEqualsPurshaceCount(int expectedvalue, int actualValue){
		assertEquals("Purchase count should be " + expectedvalue,  expectedvalue, actualValue);

	}
	private void assertEqualsRemainingAmount(BigDecimal expectdvalue, BigDecimal actualvalue) {
		assertEquals("Remaining amount should be "+expectdvalue, expectdvalue.compareTo(actualvalue), 0);
	}
	
}
