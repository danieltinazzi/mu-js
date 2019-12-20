package it.univr.domain.tajs.original;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TAJSNumericDiff {
	
	@Test
	public void testTAJSNumericUnsignedInt() throws Exception {
		assertEquals(new TAJSIntegers(TAJSIntegers.UNSIGNED_INT, true).diff(new TAJSIntegers(2)), new TAJSIntegers(TAJSIntegers.UNSIGNED_INT, true));
		assertEquals(new TAJSIntegers(TAJSIntegers.UNSIGNED_INT, true).diff(new TAJSIntegers(1.1)), new TAJSIntegers(TAJSIntegers.NOT_UNSIGNED_INT, true));
		assertEquals(new TAJSIntegers(TAJSIntegers.UNSIGNED_INT, true).diff(new TAJSIntegers(-2.2)), new TAJSIntegers(TAJSIntegers.NOT_UNSIGNED_INT, true));
		assertEquals(new TAJSIntegers(TAJSIntegers.UNSIGNED_INT, true).diff(new TAJSIntegers(TAJSIntegers.UNSIGNED_INT, true)), new TAJSIntegers(TAJSIntegers.UNSIGNED_INT, true));
		assertEquals(new TAJSIntegers(TAJSIntegers.UNSIGNED_INT, true).diff(new TAJSIntegers(TAJSIntegers.NOT_UNSIGNED_INT, true)), new TAJSIntegers(TAJSIntegers.NOT_UNSIGNED_INT, true));
		assertEquals(new TAJSIntegers(TAJSIntegers.UNSIGNED_INT, true).diff(new TAJSIntegers(TAJSIntegers.TOP, true)), new TAJSIntegers(TAJSIntegers.TOP, true));
		assertEquals(new TAJSIntegers(TAJSIntegers.UNSIGNED_INT, true).diff(new TAJSIntegers(TAJSIntegers.BOT, true)), new TAJSIntegers(TAJSIntegers.BOT, true));
	}
	
	@Test
	public void testTAJSNumericNotUnsignedInt() throws Exception {
		assertEquals(new TAJSIntegers(TAJSIntegers.NOT_UNSIGNED_INT, true).diff(new TAJSIntegers(2)), new TAJSIntegers(TAJSIntegers.NOT_UNSIGNED_INT, true));
		assertEquals(new TAJSIntegers(TAJSIntegers.NOT_UNSIGNED_INT, true).diff(new TAJSIntegers(1.1)), new TAJSIntegers(TAJSIntegers.TOP, true));
		assertEquals(new TAJSIntegers(TAJSIntegers.NOT_UNSIGNED_INT, true).diff(new TAJSIntegers(-2.2)), new TAJSIntegers(TAJSIntegers.TOP, true));
		assertEquals(new TAJSIntegers(TAJSIntegers.NOT_UNSIGNED_INT, true).diff(new TAJSIntegers(TAJSIntegers.UNSIGNED_INT, true)), new TAJSIntegers(TAJSIntegers.NOT_UNSIGNED_INT, true));
		assertEquals(new TAJSIntegers(TAJSIntegers.NOT_UNSIGNED_INT, true).diff(new TAJSIntegers(TAJSIntegers.NOT_UNSIGNED_INT, true)), new TAJSIntegers(TAJSIntegers.TOP, true));
		assertEquals(new TAJSIntegers(TAJSIntegers.NOT_UNSIGNED_INT, true).diff(new TAJSIntegers(TAJSIntegers.TOP, true)), new TAJSIntegers(TAJSIntegers.TOP, true));
		assertEquals(new TAJSIntegers(TAJSIntegers.NOT_UNSIGNED_INT, true).diff(new TAJSIntegers(TAJSIntegers.BOT, true)), new TAJSIntegers(TAJSIntegers.BOT, true));
	}
	
	@Test
	public void testTAJSNumericTop() throws Exception {
		assertEquals(new TAJSIntegers(TAJSIntegers.TOP, true).diff(new TAJSIntegers(2)), new TAJSIntegers(TAJSIntegers.TOP, true));
		assertEquals(new TAJSIntegers(TAJSIntegers.TOP, true).diff(new TAJSIntegers(1.1)), new TAJSIntegers(TAJSIntegers.TOP, true));
		assertEquals(new TAJSIntegers(TAJSIntegers.TOP, true).diff(new TAJSIntegers(-2.2)), new TAJSIntegers(TAJSIntegers.TOP, true));
		assertEquals(new TAJSIntegers(TAJSIntegers.TOP, true).diff(new TAJSIntegers(TAJSIntegers.UNSIGNED_INT, true)), new TAJSIntegers(TAJSIntegers.TOP, true));
		assertEquals(new TAJSIntegers(TAJSIntegers.TOP, true).diff(new TAJSIntegers(TAJSIntegers.NOT_UNSIGNED_INT, true)), new TAJSIntegers(TAJSIntegers.TOP, true));
		assertEquals(new TAJSIntegers(TAJSIntegers.TOP, true).diff(new TAJSIntegers(TAJSIntegers.TOP, true)), new TAJSIntegers(TAJSIntegers.TOP, true));
		assertEquals(new TAJSIntegers(TAJSIntegers.TOP, true).diff(new TAJSIntegers(TAJSIntegers.BOT, true)), new TAJSIntegers(TAJSIntegers.BOT, true));
	}
}
