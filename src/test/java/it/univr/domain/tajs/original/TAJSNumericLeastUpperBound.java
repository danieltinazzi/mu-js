package it.univr.domain.tajs.original;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TAJSNumericLeastUpperBound {
	
	@Test
	public void testTAJSNumericSingleUnsignedInteger() throws Exception {

		/*
		 * First parameter single unsigned integer
		 */
		assertEquals(new TAJSIntegers( 1).leastUpperBound(new TAJSIntegers( 2)), new TAJSIntegers(TAJSIntegers.UNSIGNED_INT, true));
		assertEquals(new TAJSIntegers( 1).leastUpperBound(new TAJSIntegers( 1)), new TAJSIntegers( 1));
		assertEquals(new TAJSIntegers( 1).leastUpperBound(new TAJSIntegers( 2.2)), new TAJSIntegers(TAJSIntegers.TOP, true));
		assertEquals(new TAJSIntegers( 1).leastUpperBound(new TAJSIntegers(TAJSIntegers.UNSIGNED_INT, true)), new TAJSIntegers(TAJSIntegers.UNSIGNED_INT, true));
		assertEquals(new TAJSIntegers( 1).leastUpperBound(new TAJSIntegers(TAJSIntegers.NOT_UNSIGNED_INT, true)), new TAJSIntegers(TAJSIntegers.TOP, true));
		assertEquals(new TAJSIntegers( 1).leastUpperBound(new TAJSIntegers(TAJSIntegers.TOP, true)), new TAJSIntegers(TAJSIntegers.TOP, true));

		
		/*
		 * Second parameter single unsigned integer
		 */
		assertEquals(new TAJSIntegers( 2).leastUpperBound(new TAJSIntegers( 1)), new TAJSIntegers(TAJSIntegers.UNSIGNED_INT, true));
		assertEquals(new TAJSIntegers( 1).leastUpperBound(new TAJSIntegers( 1)), new TAJSIntegers( 1));
		assertEquals(new TAJSIntegers( 2.2).leastUpperBound(new TAJSIntegers( 1)), new TAJSIntegers(TAJSIntegers.TOP, true));
		assertEquals(new TAJSIntegers(TAJSIntegers.UNSIGNED_INT, true).leastUpperBound(new TAJSIntegers( 1)), new TAJSIntegers(TAJSIntegers.UNSIGNED_INT, true));
		assertEquals(new TAJSIntegers(TAJSIntegers.NOT_UNSIGNED_INT, true).leastUpperBound(new TAJSIntegers( 1)), new TAJSIntegers(TAJSIntegers.TOP, true));
		assertEquals(new TAJSIntegers(TAJSIntegers.TOP, true).leastUpperBound(new TAJSIntegers( 1)), new TAJSIntegers(TAJSIntegers.TOP, true));
	}
	
	@Test
	public void testTAJSNumericSingleNotUnsignedInteger() throws Exception {

		/*
		 * First parameter single unsigned integer
		 */
		assertEquals(new TAJSIntegers( 1.1).leastUpperBound(new TAJSIntegers( 2)), new TAJSIntegers(TAJSIntegers.TOP, true));
		assertEquals(new TAJSIntegers( 1.1).leastUpperBound(new TAJSIntegers( 1.1)), new TAJSIntegers( 1.1));
		assertEquals(new TAJSIntegers( 1.1).leastUpperBound(new TAJSIntegers( -2.2)), new TAJSIntegers(TAJSIntegers.NOT_UNSIGNED_INT, true));
		assertEquals(new TAJSIntegers( 1.1).leastUpperBound(new TAJSIntegers(TAJSIntegers.UNSIGNED_INT, true)), new TAJSIntegers(TAJSIntegers.TOP, true));
		assertEquals(new TAJSIntegers( 1.1).leastUpperBound(new TAJSIntegers(TAJSIntegers.NOT_UNSIGNED_INT, true)), new TAJSIntegers(TAJSIntegers.NOT_UNSIGNED_INT, true));
		assertEquals(new TAJSIntegers( 1.1).leastUpperBound(new TAJSIntegers(TAJSIntegers.TOP, true)), new TAJSIntegers(TAJSIntegers.TOP, true));

		/*
		 * Second parameter single unsigned integer
		 */
		assertEquals(new TAJSIntegers( 2).leastUpperBound(new TAJSIntegers( 1.1)), new TAJSIntegers(TAJSIntegers.TOP, true));
		assertEquals(new TAJSIntegers( -1.1).leastUpperBound(new TAJSIntegers( -1.1)), new TAJSIntegers( -1.1));
		assertEquals(new TAJSIntegers( 2.2).leastUpperBound(new TAJSIntegers( -1.1)), new TAJSIntegers(TAJSIntegers.NOT_UNSIGNED_INT, true));
		assertEquals(new TAJSIntegers(TAJSIntegers.UNSIGNED_INT, true).leastUpperBound(new TAJSIntegers( 1.1)), new TAJSIntegers(TAJSIntegers.TOP, true));
		assertEquals(new TAJSIntegers(TAJSIntegers.NOT_UNSIGNED_INT, true).leastUpperBound(new TAJSIntegers( 1.1)), new TAJSIntegers(TAJSIntegers.NOT_UNSIGNED_INT, true));
		assertEquals(new TAJSIntegers(TAJSIntegers.TOP, true).leastUpperBound(new TAJSIntegers( 1.1)), new TAJSIntegers(TAJSIntegers.TOP, true));
	}
	
	@Test
	public void testTAJSNumericUnsignedInteger() throws Exception {

		/*
		 * First parameter unsigned integer
		 */
		assertEquals(new TAJSIntegers(TAJSIntegers.UNSIGNED_INT, true).leastUpperBound(new TAJSIntegers(TAJSIntegers.UNSIGNED_INT, true)), new TAJSIntegers(TAJSIntegers.UNSIGNED_INT, true));
		assertEquals(new TAJSIntegers(TAJSIntegers.UNSIGNED_INT, true).leastUpperBound(new TAJSIntegers(TAJSIntegers.NOT_UNSIGNED_INT, true)),  new TAJSIntegers(TAJSIntegers.TOP, true));
		assertEquals(new TAJSIntegers(TAJSIntegers.UNSIGNED_INT, true).leastUpperBound(new TAJSIntegers(TAJSIntegers.BOT, true)), new TAJSIntegers(TAJSIntegers.UNSIGNED_INT, true));
		assertEquals(new TAJSIntegers(TAJSIntegers.UNSIGNED_INT, true).leastUpperBound(new TAJSIntegers(TAJSIntegers.TOP, true)), new TAJSIntegers(TAJSIntegers.TOP, true));
	}	
	
	@Test
	public void testTAJSNumericNotUnsignedInteger() throws Exception {

		/*
		 * First parameter not unsigned integer
		 */
		assertEquals(new TAJSIntegers(TAJSIntegers.NOT_UNSIGNED_INT, true).leastUpperBound(new TAJSIntegers(TAJSIntegers.UNSIGNED_INT, true)), new TAJSIntegers(TAJSIntegers.TOP, true));
		assertEquals(new TAJSIntegers(TAJSIntegers.NOT_UNSIGNED_INT, true).leastUpperBound(new TAJSIntegers(TAJSIntegers.NOT_UNSIGNED_INT, true)),  new TAJSIntegers(TAJSIntegers.NOT_UNSIGNED_INT, true));
		assertEquals(new TAJSIntegers(TAJSIntegers.NOT_UNSIGNED_INT, true).leastUpperBound(new TAJSIntegers(TAJSIntegers.BOT, true)), new TAJSIntegers(TAJSIntegers.NOT_UNSIGNED_INT, true));
		assertEquals(new TAJSIntegers(TAJSIntegers.NOT_UNSIGNED_INT, true).leastUpperBound(new TAJSIntegers(TAJSIntegers.TOP, true)), new TAJSIntegers(TAJSIntegers.TOP, true));
	}
	
	@Test
	public void testTAJSNumericTop() throws Exception {

		/*
		 * First parameter not unsigned integer
		 */
		assertEquals(new TAJSIntegers(TAJSIntegers.TOP, true).leastUpperBound(new TAJSIntegers(TAJSIntegers.UNSIGNED_INT, true)), new TAJSIntegers(TAJSIntegers.TOP, true));
		assertEquals(new TAJSIntegers(TAJSIntegers.TOP, true).leastUpperBound(new TAJSIntegers(TAJSIntegers.NOT_UNSIGNED_INT, true)),  new TAJSIntegers(TAJSIntegers.TOP, true));
		assertEquals(new TAJSIntegers(TAJSIntegers.TOP, true).leastUpperBound(new TAJSIntegers(TAJSIntegers.BOT, true)), new TAJSIntegers(TAJSIntegers.TOP, true));
		assertEquals(new TAJSIntegers(TAJSIntegers.TOP, true).leastUpperBound(new TAJSIntegers(TAJSIntegers.TOP, true)), new TAJSIntegers(TAJSIntegers.TOP, true));
	}
	
	@Test
	public void testTAJSNumericBot() throws Exception {

		/*
		 * First parameter not unsigned integer
		 */
		assertEquals(new TAJSIntegers(TAJSIntegers.BOT, true).leastUpperBound(new TAJSIntegers(TAJSIntegers.UNSIGNED_INT, true)), new TAJSIntegers(TAJSIntegers.UNSIGNED_INT, true));
		assertEquals(new TAJSIntegers(TAJSIntegers.BOT, true).leastUpperBound(new TAJSIntegers(TAJSIntegers.NOT_UNSIGNED_INT, true)),  new TAJSIntegers(TAJSIntegers.NOT_UNSIGNED_INT, true));
		assertEquals(new TAJSIntegers(TAJSIntegers.BOT, true).leastUpperBound(new TAJSIntegers(TAJSIntegers.BOT, true)), new TAJSIntegers(TAJSIntegers.BOT, true));
		assertEquals(new TAJSIntegers(TAJSIntegers.BOT, true).leastUpperBound(new TAJSIntegers(TAJSIntegers.TOP, true)), new TAJSIntegers(TAJSIntegers.TOP, true));
	}
	
}
