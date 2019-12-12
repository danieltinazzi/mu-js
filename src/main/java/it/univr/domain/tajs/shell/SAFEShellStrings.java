package it.univr.domain.tajs.shell;

import static org.junit.Assert.assertTrue;

import java.util.regex.Pattern;

import it.univr.domain.AbstractValue;

public class SAFEShellStrings implements AbstractValue {

	static private final Pattern NUMBER = Pattern.compile("-?(([0-9]+(\\.[0-9]*)?|\\.[0-9]+)([eE][-+][0-9]+)?)"); 
	static private final Pattern UNSIGNED_FLOAT = Pattern.compile("[0-9]+(\\.[0-9]*)?"); 

	public final static int BOT = 0x00000001; 
	public final static int SINGLE_STRING = 0x00000002;
	public final static int NUMERIC = 0x00000003;
	public final static int NOT_NUMERIC = 0x00000004;
	public final static int TOP = 0x00000005;
	public final static int UINT = 0x00000006;
	public final static int UFLOAT = 0x00000007;
	public final static int SIGNED_NUM = 0x00000008;
	public final static int NOTNUM_NOTEMPTY = 0x00000009;
	public final static int UINT_EPSILON = 0x00000010;
	public final static int UNUM = 0x00000011;
	public final static int UNUM_EPSILON = 0x00000012;
	public final static int NOTUNSIGNED_NOTEMPTY = 0x00000013;
	public final static int NOTUINT_NOTEMPTY = 0x00000013;

	private String str;
	private int v;


	public SAFEShellStrings(String str) {
		this.str = str;
		this.v = SINGLE_STRING;
	}

	public SAFEShellStrings(int v) {
		this.str = null;
		this.v = v;
	}

	public static SAFEShellStrings createNotNumeric() {
		return new SAFEShellStrings(NOT_NUMERIC);
	}

	public static SAFEShellStrings createNumeric() {
		return new SAFEShellStrings(NUMERIC);
	}

	public int getAbstractValue() {
		return v;
	}

	public static SAFEShellStrings createTopString() {
		return new SAFEShellStrings(TOP);
	}

	public static SAFEShellStrings createBotString() {
		return new SAFEShellStrings(BOT);
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
		if (other instanceof SAFEShellStrings) { 
			SAFEShellStrings that = ((SAFEShellStrings) other).clone();

			if (isTop() || that.isTop())
				return createTopString();
			else if (isBot()) // if this is bot return that
				return that; 
			else if (that.isBot()) // if that is bot return this
				return clone();
			else if (isString() && that.isString())	{ // both abstract value are single strings
				if (getSingleString().equals(that.getSingleString())) // if strings are equals returns this
					return clone();
				else if (isUnsignedInteger()) {

					if (that.isUnsignedInteger()) 
						return new SAFEShellStrings(SAFEShellStrings.UINT);					
					else if (that.isEmptyString())
						return new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON);	
					else if (that.isUnsignedFloat())
						return new SAFEShellStrings(SAFEShellStrings.UNUM);	
					else if (!that.isNumeric() && !that.getSingleString().isEmpty())
						return createTopString();
					else
						return new SAFEShellStrings(SAFEShellStrings.NUMERIC);	
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


				/*
				 * SAFE complete shell least upper bound
				 */
			} 
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
	public SAFEShellStrings clone() {
		return isString() ?  new SAFEShellStrings(str) :  new SAFEShellStrings(v);
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
		if (other instanceof SAFEShellStrings) {
			return isString() && ((SAFEShellStrings) other).isString() ? getSingleString().equals(((SAFEShellStrings) other).getSingleString()) : v == ((SAFEShellStrings) other).getAbstractValue();
		}

		return false;
	}

	public SAFEShellStrings concat(SAFEShellStrings that) {
		if (isBot() || that.isBot()) // bottom cases
			return new SAFEShellStrings(BOT);

		else if (isString()) { // second row

			if (that.isString())
				return new SAFEShellStrings(getSingleString() + that.getSingleString());
			else if (that.isNumeric()) {
				if (isUnsignedInteger() || getSingleString().isEmpty())
					return new SAFEShellStrings(NUMERIC);
				else
					return new SAFEShellStrings(NOT_NUMERIC);
			}
			else if (that.isNotNumeric()) 
				return that.clone();
			else
				return new SAFEShellStrings(TOP);
		} 

		else if (isNumeric()) { // third row

			if (that.isString()) {
				if (that.isUnsignedInteger() || that.getSingleString().isEmpty())
					return new SAFEShellStrings(NUMERIC);
				else
					return new SAFEShellStrings(NOT_NUMERIC);
			} else if (that.isNumeric())
				return new SAFEShellStrings(TOP);
			else if (that.isNotNumeric())
				return new SAFEShellStrings(NOT_NUMERIC);
			else
				return new SAFEShellStrings(TOP);
		}

		else if (isNotNumeric()) { // forth row
			if (that.isString() || that.isNumeric() || that.isNotNumeric())
				return new SAFEShellStrings(NOT_NUMERIC);
			else
				return new SAFEShellStrings(TOP);
		}

		else // fifth row
			return new SAFEShellStrings(TOP);
	}

	private boolean isUnsignedInteger() {
		assertTrue(isString());
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

	private boolean isSignedNumber() {
		assertTrue(isString());
		return !getSingleString().isEmpty() 
				&& isNumericString() 
				&& (getSingleString().charAt(0) == '-'
				|| getSingleString().charAt(0) == '+');
	}

	private boolean isEmptyString() {
		assertTrue(isString());
		return getSingleString().isEmpty();
	}

	private boolean isUnsignedFloat() {
		assertTrue(isString());
		return UNSIGNED_FLOAT.matcher(str).matches();
	}

}
