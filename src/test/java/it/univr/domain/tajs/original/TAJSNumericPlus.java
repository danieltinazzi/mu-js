package it.univr.domain.tajs.original;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TAJSNumericPlus {
	
	@Test
	public void testTAJSNumericSingleStrings() throws Exception {
		assertEquals(new TAJSIntegers(1).plus(new TAJSIntegers(2)), new TAJSIntegers(3));
		assertEquals(new TAJSIntegers(1).plus(new TAJSIntegers(1.1)), new TAJSIntegers(2.1));
		assertEquals(new TAJSIntegers(1).plus(new TAJSIntegers(-2.2)), new TAJSIntegers(-1.2));
		assertEquals(new TAJSIntegers(2.1).plus(new TAJSIntegers(-2.1)), new TAJSIntegers(0));
		assertEquals(new TAJSIntegers(2.1).plus(new TAJSIntegers(2.1)), new TAJSIntegers(4.2));
		assertEquals(new TAJSIntegers(2.1).plus(new TAJSIntegers(0.9)), new TAJSIntegers(3));
	}

	
	@Test
	public void testTAJSNumericUnsignedInt() throws Exception {
		assertEquals(new TAJSIntegers(TAJSIntegers.UNSIGNED_INT, true).plus(new TAJSIntegers(2)), new TAJSIntegers(TAJSIntegers.UNSIGNED_INT, true));
		assertEquals(new TAJSIntegers(TAJSIntegers.UNSIGNED_INT, true).plus(new TAJSIntegers(1.1)), new TAJSIntegers(TAJSIntegers.NOT_UNSIGNED_INT, true));
		assertEquals(new TAJSIntegers(TAJSIntegers.UNSIGNED_INT, true).plus(new TAJSIntegers(-2.2)), new TAJSIntegers(TAJSIntegers.NOT_UNSIGNED_INT, true));
		assertEquals(new TAJSIntegers(TAJSIntegers.UNSIGNED_INT, true).plus(new TAJSIntegers(TAJSIntegers.UNSIGNED_INT, true)), new TAJSIntegers(TAJSIntegers.UNSIGNED_INT, true));
		assertEquals(new TAJSIntegers(TAJSIntegers.UNSIGNED_INT, true).plus(new TAJSIntegers(TAJSIntegers.NOT_UNSIGNED_INT, true)), new TAJSIntegers(TAJSIntegers.NOT_UNSIGNED_INT, true));
		assertEquals(new TAJSIntegers(TAJSIntegers.UNSIGNED_INT, true).plus(new TAJSIntegers(TAJSIntegers.TOP, true)), new TAJSIntegers(TAJSIntegers.TOP, true));
		assertEquals(new TAJSIntegers(TAJSIntegers.UNSIGNED_INT, true).plus(new TAJSIntegers(TAJSIntegers.BOT, true)), new TAJSIntegers(TAJSIntegers.BOT, true));
	}
	
	@Test
	public void testTAJSNumericNotUnsignedInt() throws Exception {
		assertEquals(new TAJSIntegers(TAJSIntegers.NOT_UNSIGNED_INT, true).plus(new TAJSIntegers(2)), new TAJSIntegers(TAJSIntegers.NOT_UNSIGNED_INT, true));
		assertEquals(new TAJSIntegers(TAJSIntegers.NOT_UNSIGNED_INT, true).plus(new TAJSIntegers(1.1)), new TAJSIntegers(TAJSIntegers.TOP, true));
		assertEquals(new TAJSIntegers(TAJSIntegers.NOT_UNSIGNED_INT, true).plus(new TAJSIntegers(-2.2)), new TAJSIntegers(TAJSIntegers.TOP, true));
		assertEquals(new TAJSIntegers(TAJSIntegers.NOT_UNSIGNED_INT, true).plus(new TAJSIntegers(TAJSIntegers.UNSIGNED_INT, true)), new TAJSIntegers(TAJSIntegers.NOT_UNSIGNED_INT, true));
		assertEquals(new TAJSIntegers(TAJSIntegers.NOT_UNSIGNED_INT, true).plus(new TAJSIntegers(TAJSIntegers.NOT_UNSIGNED_INT, true)), new TAJSIntegers(TAJSIntegers.TOP, true));
		assertEquals(new TAJSIntegers(TAJSIntegers.NOT_UNSIGNED_INT, true).plus(new TAJSIntegers(TAJSIntegers.TOP, true)), new TAJSIntegers(TAJSIntegers.TOP, true));
		assertEquals(new TAJSIntegers(TAJSIntegers.NOT_UNSIGNED_INT, true).plus(new TAJSIntegers(TAJSIntegers.BOT, true)), new TAJSIntegers(TAJSIntegers.BOT, true));
	}
	
	@Test
	public void testTAJSNumericTop() throws Exception {
		assertEquals(new TAJSIntegers(TAJSIntegers.TOP, true).plus(new TAJSIntegers(2)), new TAJSIntegers(TAJSIntegers.TOP, true));
		assertEquals(new TAJSIntegers(TAJSIntegers.TOP, true).plus(new TAJSIntegers(1.1)), new TAJSIntegers(TAJSIntegers.TOP, true));
		assertEquals(new TAJSIntegers(TAJSIntegers.TOP, true).plus(new TAJSIntegers(-2.2)), new TAJSIntegers(TAJSIntegers.TOP, true));
		assertEquals(new TAJSIntegers(TAJSIntegers.TOP, true).plus(new TAJSIntegers(TAJSIntegers.UNSIGNED_INT, true)), new TAJSIntegers(TAJSIntegers.TOP, true));
		assertEquals(new TAJSIntegers(TAJSIntegers.TOP, true).plus(new TAJSIntegers(TAJSIntegers.NOT_UNSIGNED_INT, true)), new TAJSIntegers(TAJSIntegers.TOP, true));
		assertEquals(new TAJSIntegers(TAJSIntegers.TOP, true).plus(new TAJSIntegers(TAJSIntegers.TOP, true)), new TAJSIntegers(TAJSIntegers.TOP, true));
		assertEquals(new TAJSIntegers(TAJSIntegers.TOP, true).plus(new TAJSIntegers(TAJSIntegers.BOT, true)), new TAJSIntegers(TAJSIntegers.BOT, true));
	}
}
