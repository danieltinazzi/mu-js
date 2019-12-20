package it.univr.domain.tajs.original;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;

import it.univr.domain.AbstractValue;
import it.univr.domain.safe.original.SAFEStrings;

/**
 * Interval abstract domain.
 * 
 *  @author <a href="vincenzo.arceri@univr.it">Vincenzo Arceri</a>
 */
public class TAJSIntegers implements AbstractValue {

	private final static int BOT = 0x00000001; 
	private final static int UNSIGNED_INT = 0x00000002;
	private final static int NOT_UNSIGNED_INT = 0x00000003;
	private final static int SINGLE_INT = 0x00000004;
	private final static int TOP = 0x00000005;

	private Integer i;
	private int v;

	public TAJSIntegers(Integer i) {
		this.i = i;
		this.i = SINGLE_INT;
	}

	public TAJSIntegers(int v, boolean b) {
		this.i = null;
		this.v = v;
	}

	public static TAJSIntegers createUnsigned() {
		return new TAJSIntegers(UNSIGNED_INT, true);
	}

	public static TAJSIntegers createNotUnsignedInt() {
		return new TAJSIntegers(NOT_UNSIGNED_INT, true);
	}

	public int getAbstractValue() {
		return v;
	}
	
	public static TAJSIntegers createTopString() {
		return new TAJSIntegers(TOP, true);
	}

	public static TAJSIntegers createBotString() {
		return new TAJSIntegers(BOT, true);
	}

	public boolean isBot() {
		return v == BOT;
	}

	public boolean isTop() {
		return v == TOP;
	}

	public boolean isUnsignedInt() {
		return v == UNSIGNED_INT;
	}

	public boolean isNotUnsignedInt() {
		return v == NOT_UNSIGNED_INT;
	}

	public boolean isString() {
		return v == SINGLE_INT;
	}

	public int getSingleInteger() {
		assertTrue(isString());
		return i;
	}
	
	@Override
	public AbstractValue leastUpperBound(AbstractValue other) {

		if (other instanceof TAJSIntegers) {
			
		} 
		
		return new Top();
	}

	@Override
	public AbstractValue widening(AbstractValue other) {
		return leastUpperBound(other);
	}


	@Override
	public String toString() {
		// TODO
		return null;
	}



	/**
	 * Plus TAJS integers operation.
	 * 
	 * @param other second operand
	 * @return the sum between the intervals, i,e. [l1,h1] + [l2,h2].
	 */
	public TAJSIntegers plus(TAJSIntegers other) {
		// TODO
		return null;
	}

	/**
	 * Minus TAJS integers operation.
	 * 
	 * @param other second operand
	 * @return the minus between the intervals, i,e. [l1,h1] - [l2,h2].
	 */
	public TAJSIntegers diff(TAJSIntegers other) {
		// TODO
		return null;
	}

	/**
	 * Multiplication TAJS integers operation.
	 * 
	 * @param other second operand
	 * @return the multiplication between the intervals, i,e. [l1,h1] * [l2,h2].
	 */
	public TAJSIntegers mul(TAJSIntegers other) {
		// TODO
		return null;
	}

	@Override
	public TAJSIntegers clone() {
		return isString() ? new TAJSIntegers(getSingleInteger()) : new TAJSIntegers(getAbstractValue(), true);
	}

	@Override
	public boolean equals(Object other) {
		// TODO
		return false;
	}

	public Bool greater(TAJSIntegers other) {
		// TODO
		return null;
	}

	@Override
	public AbstractValue greatestLowerBound(AbstractValue o) {
		// TODO
		return null;
	}

	public Bool isEqual(TAJSIntegers other) {
		// TODO
		return null;
	}

	@Override
	public AbstractValue narrowing(AbstractValue value) {
		return greatestLowerBound(value);
	}

}
