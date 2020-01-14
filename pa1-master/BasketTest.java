package cse12pa1student;

import java.util.Collection;
import java.util.Arrays;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BasketTest {

	public static Collection<Object[]> BAGNUMS =
			Arrays.asList(new Object[][] { {0}, {1}, {2}, {3}, {4}, {5}, {6}, {7}, {8}, {9}, {10}, {11}, {12} });
	private int bagType;

	public BasketTest(int bagType) {
		super();
		this.bagType = bagType;
	}

	@Parameterized.Parameters(name = "Basket{index}")
	public static Collection<Object[]> bags() {
		return BAGNUMS;
	}
	
	private Basket makeBasket() {
		switch(this.bagType) {
			case 0: return new Basket0();
			case 1: return new Basket1();
			case 2: return new Basket2();
			case 3: return new Basket3();
			case 4: return new Basket4();
			case 5: return new Basket5();
			case 6: return new Basket6();
			case 7: return new Basket7();
			case 8: return new Basket8();
			case 9: return new Basket9();
			case 10: return new Basket10();
			case 11: return new Basket11();
			case 12: return new Basket12();
		}
		return null;
	}
	
	@Test
	public void addedHasCount1() {
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		basketToTest.addToBasket(i);
		assertEquals(1, basketToTest.count());
	}
	@Test
	public void totalPriceCorrect() {
		Basket basketToTest = makeBasket();
		Item shamp = new Item("Shampoo", 5);
		Item chicken = new Item("Chicken", 10);
		Item cup = new Item("Cup", 15);
		basketToTest.addToBasket(shamp);
		basketToTest.addToBasket(chicken);
		basketToTest.addToBasket(cup);
		assertEquals(30, basketToTest.totalCost());
	}
	@Test
	public void countItemWithDuplicate2() {
		Basket basketToTest = makeBasket();
		Item shamp = new Item("Shampoo", 5);
		Item chicken = new Item("Chicken", 10);
		Item cup = new Item("Cup", 15);
		basketToTest.addToBasket(shamp);
		basketToTest.addToBasket(shamp);
		basketToTest.addToBasket(chicken);
		basketToTest.addToBasket(cup);
		assertEquals(2, basketToTest.countItem(new Item("Shampoo", 5)));
	}
	@Test
	public void countBasketCapacity() {
		Basket basketToTest = makeBasket();
		for (int i = 0; i < 20; i++) {
			Item shamp = new Item("Shampoo", 5);
			basketToTest.addToBasket(shamp);
		}
		assertEquals(20, basketToTest.count());
	}
	
	@Test 
	public void RemoveNonexistingItems() {
		Basket basketToTest = makeBasket();
		Item shamp = new Item("Shampoo", 5);
		basketToTest.addToBasket(shamp);
		basketToTest.removeFromBasket(shamp);
		assertFalse(basketToTest.removeFromBasket(shamp));
	}
	@Test 
	public void countAfterRemoving() {
		Basket basketToTest = makeBasket();
		Item shamp0 = new Item("Shampoo", 5);
		Item shamp1 = new Item("Shampoo", 10);
		Item shamp2 = new Item("Shampoo", 15);
		basketToTest.addToBasket(shamp0);
		basketToTest.addToBasket(shamp1);
		basketToTest.addToBasket(shamp2);		
		assertTrue(basketToTest.removeFromBasket(shamp0));
		assertEquals(2, basketToTest.count());
		assertTrue(basketToTest.removeFromBasket(shamp1));
		assertEquals(1, basketToTest.count());
		assertTrue(basketToTest.removeFromBasket(shamp2));
		assertEquals(0, basketToTest.count());
		assertFalse(basketToTest.removeFromBasket(shamp0));
		assertEquals(0, basketToTest.count());
	}
	@Test 
	public void totalCostForDuplicateItems() {
		Basket basketToTest = makeBasket();
		Item shamp = new Item("Shampoo", 5);
		basketToTest.addToBasket(shamp);
		basketToTest.addToBasket(shamp);
		basketToTest.addToBasket(shamp);	
		assertEquals(15, basketToTest.totalCost());
		//basket11
	}
	@Test
	public void removeAllDuplicates() {
		Basket basketToTest = makeBasket();
		Item shamp = new Item("Shampoo", 5);
		for (int i = 0; i < 100; i++) {
			basketToTest.addToBasket(shamp);
		}
		assertTrue(basketToTest.removeAllFromBasket(shamp));
		assertEquals(0, basketToTest.count());
	}
	@Test
	public void removeAllWithOtherItems() {
		Basket basketToTest = makeBasket();
		Item shamp = new Item("Shampoo", 5);
		for (int i = 0; i < 100; i++) {
			basketToTest.addToBasket(shamp);
		}
		Item chicken = new Item("Chicken", 10);
		Item cup = new Item("Cup", 15);
		basketToTest.addToBasket(chicken);
		basketToTest.addToBasket(cup);
		basketToTest.removeAllFromBasket(shamp);
		assertEquals(2, basketToTest.count());
	}
	@Test
	public void superLargeBasket() {
		Basket basketToTest = makeBasket();
		Item shamp = new Item("Shampoo", 5);
		for (int i = 0; i < 100000; i++) {
			basketToTest.addToBasket(shamp);
		}
		assertEquals(100000, basketToTest.count());
	}
	@Test
	public void addNull() {
		Basket basketToTest = makeBasket();
		Item nullItem = null;
		basketToTest.addToBasket(nullItem);
		assertEquals(0, basketToTest.count());
		
	}
	@Test
	public void removeNull() {
		Basket basketToTest = makeBasket();
		Item nullItem = null;
		basketToTest.addToBasket(nullItem);
		assertTrue(basketToTest.removeFromBasket(nullItem));
	}
	@Test
	public void addWithMultipleDuplicatesDiffOrder() {
		Basket basketToTest = makeBasket();
		Item shamp = new Item("shamp", 5);
		Item soup = new Item("soup", 10);
		Item chicken = new Item("chicken", 15);
		basketToTest.addToBasket(shamp);
		basketToTest.addToBasket(shamp);
		basketToTest.addToBasket(shamp);
		basketToTest.addToBasket(soup);
		basketToTest.addToBasket(soup);
		basketToTest.addToBasket(soup);
		basketToTest.addToBasket(chicken);
		basketToTest.addToBasket(chicken);
		basketToTest.addToBasket(shamp);
		basketToTest.addToBasket(shamp);
		assertEquals(5, basketToTest.countItem(shamp));
		assertEquals(3, basketToTest.countItem(soup));
		assertEquals(2, basketToTest.countItem(chicken));
	}
	
}