package it.univr.domain.tajs.original;

import static org.junit.Assert.assertTrue;

import java.util.regex.Pattern;

import it.univr.domain.AbstractValue;

public class TAJSStrings implements AbstractValue {

	static private final Pattern NUMBER = Pattern.compile("-?(([0-9]+(\\.[0-9]*)?|\\.[0-9]+)([eE][-+][0-9]+)?)"); // TODO: check that this over-approximates the possible output of Number.toString


	private final static int BOT = 0x00000001; 
	private final static int SINGLE_STRING = 0x00000002;
	private final static int NUMERIC = 0x00000003;
	private final static int NOT_NUMERIC = 0x00000004;
	private final static int TOP = 0x00000005;


	private String str;
	private int v;


	public static void main(String args[]) {
		System.err.println(NUMBER.matcher("").matches());
		System.err.println("\n\n" + new TAJSStrings("").leastUpperBound(new TAJSStrings("a")));
	}
	
	public TAJSStrings(String str) {
		this.str = str;
		this.v = SINGLE_STRING;
	}

	public TAJSStrings(int v) {
		this.str = null;
		this.v = v;
	}

	public static TAJSStrings createNotNumeric() {
		return new TAJSStrings(NOT_NUMERIC);
	}

	public static TAJSStrings createNumeric() {
		return new TAJSStrings(NUMERIC);
	}

	public int getAbstractValue() {
		return v;
	}
	
	public static TAJSStrings createTopString() {
		return new TAJSStrings(TOP);
	}

	public static TAJSStrings createBotString() {
		return new TAJSStrings(BOT);
	}

	public boolean isBot() {
		return v == BOT;
	}

	public boolean isTop() {
		return v == TOP;
	}

	public boolean isNumeric() {
		return v == NUMERIC;
	}

	public boolean isNotNumeric() {
		return v == NOT_NUMERIC;
	}

	public boolean isString() {
		return v == SINGLE_STRING;
	}

	public String getSingleString() {
		assertTrue(isString());
		return str;
	}

	@Override
	public AbstractValue leastUpperBound(AbstractValue other) {
		if (other instanceof TAJSStrings) { 
			TAJSStrings that = ((TAJSStrings) other).clone();

			if (isTop() || that.isTop())
				return createTopString();
			else if (isBot()) // if this is bot return that
				return that; 
			else if (that.isBot()) // if that is bot return this
				return clone();
			else if (isString() && that.isString())	{ // both abstract value are single strings
				if (getSingleString().equals(that.getSingleString())) // if strings are equals returns this
					return clone();
				else 
					return isNumericString() && that.isNumericString() ? createNumeric() 
							: (!isNumericString() && !that.isNumericString() ? createNotNumeric() : createTopString());
			}

			else if (isString()) {
				// this is single string and it is numeric
				if (isNumericString()) {
					if (that.isNotNumeric())
						return createTopString();

					if (that.isNumeric())
						return that;
				} 
				// this is single string and it is not numeric
				else {
					if (that.isNotNumeric())
						return that;

					if (that.isNumeric())
						return createTopString();

				}	
			}

			else if (that.isString()) {

				// that is single string and it is numeric
				if (that.isNumericString()) {
					if (isNotNumeric())
						return createTopString();

					if (isNumeric())
						return clone();
				} 
				// that is single string and it is not numeric
				else {
					if (isNotNumeric())
						return clone();

					if (isNumeric())
						return createTopString();

				}	
			}

			else if (isNumeric() && that.isNumeric() || isNotNumeric() && that.isNotNumeric())
				return that;
			else if (isNumeric() && that.isNotNumeric() || isNotNumeric() && that.isNumeric())
				return createTopString();
		} 

		return new Top();

	}

	@Override
	public AbstractValue widening(AbstractValue other) {
		return leastUpperBound(other);
	}

	@Override
	public AbstractValue greatestLowerBound(AbstractValue value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractValue narrowing(AbstractValue value) {
		return greatestLowerBound(value);
	}

	@Override
	public TAJSStrings clone() {
		return isString() ?  new TAJSStrings(str) :  new TAJSStrings(v);
	}

	private boolean isNumericString() {
		assertTrue(isString());
		return NUMBER.matcher(str).matches();
	}
	
	@Override
	public String toString() {
		if (isString())
			return "\"" + getSingleString() + "\"";
		else if (isNotNumeric())
			return "NotNumeric";
		else if (isNumeric())
			return "Numeric";
		else
			return "String";
	}
	
	@Override
	public boolean equals(Object other) {
		if (other instanceof TAJSStrings) {
			return isString() && ((TAJSStrings) other).isString() ? getSingleString().equals(((TAJSStrings) other).getSingleString()) : v == ((TAJSStrings) other).getAbstractValue();
		}
		
		return false;
	}

	public TAJSStrings concat(TAJSStrings that) {
		if (isBot() || that.isBot()) // bottom cases
			return new TAJSStrings(BOT);

		else if (isString()) { // second row

			if (that.isString())
				return new TAJSStrings(getSingleString() + that.getSingleString());
			else if (that.isNumeric()) {
				if (isUnsignedInteger() || getSingleString().isEmpty())
					return new TAJSStrings(NUMERIC);
				else
					return new TAJSStrings(NOT_NUMERIC);
			}
			else if (that.isNotNumeric()) 
				return that.clone();
			else
				return new TAJSStrings(TOP);
		} 

		else if (isNumeric()) { // third row

			if (that.isString()) {
				if (that.isUnsignedInteger() || that.getSingleString().isEmpty())
					return new TAJSStrings(NUMERIC);
				else
					return new TAJSStrings(NOT_NUMERIC);
			} else if (that.isNumeric())
				return new TAJSStrings(TOP);
			else if (that.isNotNumeric())
				return new TAJSStrings(NOT_NUMERIC);
			else
				return new TAJSStrings(TOP);
		}

		else if (isNotNumeric()) { // forth row
			if (that.isString() || that.isNumeric() || that.isNotNumeric())
				return new TAJSStrings(NOT_NUMERIC);
			else
				return new TAJSStrings(TOP);
		}

		else // fifth row
			return new TAJSStrings(TOP);
	}

	private  boolean isUnsignedInteger() {
		if (getSingleString().isEmpty())
			return false;
		long val = 0L;
		for (int i = 0; i < getSingleString().length(); i++) {
			char c = getSingleString().charAt(i);
			if (c < '0' || c > '9')
				return false;
			val = 10 * val + Character.digit(c, 10);
			if (val > 2 * (long) Integer.MAX_VALUE)
				return false;
		}
		return true;
	}

}
