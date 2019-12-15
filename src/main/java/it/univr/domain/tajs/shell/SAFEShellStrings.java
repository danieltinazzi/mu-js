package it.univr.domain.tajs.shell;

import static org.junit.Assert.assertTrue;

import java.util.regex.Pattern;

import it.univr.domain.AbstractValue;

public class SAFEShellStrings implements AbstractValue {

	static private final Pattern NUMBER = Pattern.compile("((-|\\+)?)(([0-9]+(\\.[0-9]*)?)([eE][-+][0-9]+)?)"); 
	static private final Pattern UNSIGNED_FLOAT = Pattern.compile("[0-9]+\\.([0-9]*)"); 

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
	public final static int NOTUINT_NOTEMPTY = 0x00000014;

	private String str;
	private int v;


	public static void main(String args[]) {
		System.err.println(new SAFEShellStrings("-1.5").isSignedNumber());
	}

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
					else if (that.isNotNumericAndNotEmpty())
						return createTopString();
					else if (that.isSignedNumber())
						return new SAFEShellStrings(SAFEShellStrings.NUMERIC);	

				} else if (isUnsignedFloat()) {
					if (that.isEmptyString()) 
						return new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON);
					else if (that.isUnsignedFloat())
						return new SAFEShellStrings(SAFEShellStrings.UFLOAT);
					else if (that.isUnsignedInteger())
						return new SAFEShellStrings(SAFEShellStrings.UNUM);
					else if (that.isSignedNumber())
						return new SAFEShellStrings(SAFEShellStrings.NUMERIC);
					else if (that.isNotNumericAndNotEmpty())
						return new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY);					
				}

				else if (isSignedNumber()) {
					if (that.isEmptyString()) 
						return new SAFEShellStrings(SAFEShellStrings.TOP);
					else if (that.isUnsignedFloat())
						return new SAFEShellStrings(SAFEShellStrings.NUMERIC);
					else if (that.isUnsignedInteger())
						return new SAFEShellStrings(SAFEShellStrings.NUMERIC);
					else if (that.isSignedNumber())
						return new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM);
					else if (that.isNotNumericAndNotEmpty())
						return new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY);	

				}

				else if (isNotNumericAndNotEmpty()) {
					if (that.isEmptyString()) 
						return new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC);
					else if (that.isUnsignedFloat())
						return new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY);
					else if (that.isUnsignedInteger())
						return new SAFEShellStrings(SAFEShellStrings.TOP);
					else if (that.isSignedNumber())
						return new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY);
					else if (that.isNotNumericAndNotEmpty())
						return new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY);

				} else if (isEmptyString()) {
					if (that.isUnsignedFloat())
						return new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON);
					else if (that.isUnsignedInteger())
						return new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON);
					else if (that.isSignedNumber())
						return new SAFEShellStrings(SAFEShellStrings.TOP);
					else if (that.isNotNumericAndNotEmpty())
						return new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC);	
				}
			}

			else if (isString()) { // first parameter is single string and the second one is not

				if (isEmptyString()) {

					if (that.getAbstractValue() == UINT)
						return new SAFEShellStrings(UINT_EPSILON);
					else if (that.containsEpsilonString())
						return that.clone();
					else if (that.getAbstractValue() == UNUM)
						return new SAFEShellStrings(UNUM_EPSILON);
					else if (that.getAbstractValue() == UFLOAT)
						return new SAFEShellStrings(UNUM_EPSILON);		
					else if (that.getAbstractValue() == SIGNED_NUM)
						return new SAFEShellStrings(TOP);
					else if (that.getAbstractValue() == NOTNUM_NOTEMPTY)
						return new SAFEShellStrings(NOT_NUMERIC);
					else if (that.getAbstractValue() == NOTUNSIGNED_NOTEMPTY)
						return new SAFEShellStrings(TOP);
					else if (that.getAbstractValue() == NOTUINT_NOTEMPTY)
						return new SAFEShellStrings(TOP);
					else if (that.getAbstractValue() == NUMERIC)
						return new SAFEShellStrings(TOP);
				}

				else if (isUnsignedInteger()) {
					if (that.containsUnsignedIntegerStrings())
						return that.clone();
					else if (that.getAbstractValue() == UFLOAT)
						return new SAFEShellStrings(UNUM);		
					else if (that.getAbstractValue() == SIGNED_NUM)
						return new SAFEShellStrings(NUMERIC);
					else if (that.getAbstractValue() == NOTNUM_NOTEMPTY)
						return new SAFEShellStrings(TOP);
					else if (that.getAbstractValue() == NOTUNSIGNED_NOTEMPTY)
						return new SAFEShellStrings(TOP);
					else if (that.getAbstractValue() == NOTUINT_NOTEMPTY)
						return new SAFEShellStrings(TOP);
					else if (that.getAbstractValue() == NOT_NUMERIC)
						return new SAFEShellStrings(TOP);
				}

				else if (isUnsignedFloat()) {
					if (that.containsUnsignedFloats())
						return that.clone();
					else if (that.getAbstractValue() == UINT)
						return new SAFEShellStrings(UNUM);	
					else if (that.getAbstractValue() == UINT_EPSILON)
						return new SAFEShellStrings(UNUM_EPSILON);		
					else if (that.getAbstractValue() == SIGNED_NUM)
						return new SAFEShellStrings(NUMERIC);
					else if (that.getAbstractValue() == NOTNUM_NOTEMPTY)
						return new SAFEShellStrings(NOTUINT_NOTEMPTY);
					else if (that.getAbstractValue() == NOTUNSIGNED_NOTEMPTY)
						return new SAFEShellStrings(NOTUINT_NOTEMPTY);
					else if (that.getAbstractValue() == NOTUINT_NOTEMPTY)
						return new SAFEShellStrings(NOTUINT_NOTEMPTY);
					else if (that.getAbstractValue() == NOT_NUMERIC)
						return new SAFEShellStrings(TOP);

				}

				else if (isSignedNumber()) {
					if (that.containsSignedNumbers()) 
						return that.clone();
					else if (that.getAbstractValue() == UINT)
						return new SAFEShellStrings(NUMERIC);		
					else if (that.getAbstractValue() == UFLOAT)
						return new SAFEShellStrings(NUMERIC);		
					else if (that.getAbstractValue() == UNUM)
						return new SAFEShellStrings(NUMERIC);		
					else if (that.getAbstractValue() == NOTNUM_NOTEMPTY)
						return new SAFEShellStrings(NOTUNSIGNED_NOTEMPTY);
					else if (that.getAbstractValue() == NOT_NUMERIC)
						return new SAFEShellStrings(TOP);	
					else if (that.getAbstractValue() == UNUM_EPSILON)
						return new SAFEShellStrings(TOP);			
					else if (that.getAbstractValue() == UINT_EPSILON)
						return new SAFEShellStrings(TOP);
				}

				else if (isNotNumericAndNotEmpty()) {
					if (that.containsNotNumericNotEmptyStrings())
						return that.clone();
					else if (that.getAbstractValue() == UINT)
						return new SAFEShellStrings(TOP);
					else if (that.getAbstractValue() == UINT_EPSILON)
						return new SAFEShellStrings(TOP);
					else if (that.getAbstractValue() == UNUM)
						return new SAFEShellStrings(TOP);
					else if (that.getAbstractValue() == UNUM_EPSILON)
						return new SAFEShellStrings(TOP);
					else if (that.getAbstractValue() == UFLOAT)
						return new SAFEShellStrings(NOTUINT_NOTEMPTY);
					else if (that.getAbstractValue() == NUMERIC)
						return new SAFEShellStrings(TOP);
					else if (that.getAbstractValue() == NOT_NUMERIC)
						return new SAFEShellStrings(TOP);
					else if (that.getAbstractValue() == SIGNED_NUM)
						return new SAFEShellStrings(NOTUNSIGNED_NOTEMPTY);
				}
			}

			else if (that.isString()) { // first parameter is single string and the second one is not

				if (that.isEmptyString()) {

					if (getAbstractValue() == UINT)
						return new SAFEShellStrings(UINT_EPSILON);
					else if (containsEpsilonString())
						return clone();
					else if (getAbstractValue() == UNUM)
						return new SAFEShellStrings(UNUM_EPSILON);
					else if (getAbstractValue() == UFLOAT)
						return new SAFEShellStrings(UNUM_EPSILON);		
					else if (getAbstractValue() == SIGNED_NUM)
						return new SAFEShellStrings(TOP);
					else if (getAbstractValue() == NOTNUM_NOTEMPTY)
						return new SAFEShellStrings(NOT_NUMERIC);
					else if (getAbstractValue() == NOTUNSIGNED_NOTEMPTY)
						return new SAFEShellStrings(TOP);
					else if (getAbstractValue() == NOTUINT_NOTEMPTY)
						return new SAFEShellStrings(TOP);
					else if (getAbstractValue() == NUMERIC)
						return new SAFEShellStrings(TOP);
				}

				else if (that.isUnsignedInteger()) {
					if (containsUnsignedIntegerStrings())
						return clone();
					else if (getAbstractValue() == UFLOAT)
						return new SAFEShellStrings(UNUM);		
					else if (getAbstractValue() == SIGNED_NUM)
						return new SAFEShellStrings(NUMERIC);
					else if (getAbstractValue() == NOTNUM_NOTEMPTY)
						return new SAFEShellStrings(TOP);
					else if (getAbstractValue() == NOTUNSIGNED_NOTEMPTY)
						return new SAFEShellStrings(TOP);
					else if (getAbstractValue() == NOTUINT_NOTEMPTY)
						return new SAFEShellStrings(TOP);
					else if (getAbstractValue() == NOT_NUMERIC)
						return new SAFEShellStrings(TOP);
				}

				else if (that.isUnsignedFloat()) {
					if (containsUnsignedFloats())
						return clone();
					else if (getAbstractValue() == UINT)
						return new SAFEShellStrings(UNUM);	
					else if (getAbstractValue() == UINT_EPSILON)
						return new SAFEShellStrings(UNUM_EPSILON);		
					else if (getAbstractValue() == SIGNED_NUM)
						return new SAFEShellStrings(NUMERIC);
					else if (getAbstractValue() == NOTNUM_NOTEMPTY)
						return new SAFEShellStrings(NOTUINT_NOTEMPTY);
					else if (getAbstractValue() == NOTUNSIGNED_NOTEMPTY)
						return new SAFEShellStrings(NOTUINT_NOTEMPTY);
					else if (getAbstractValue() == NOTUINT_NOTEMPTY)
						return new SAFEShellStrings(NOTUINT_NOTEMPTY);
					else if (getAbstractValue() == NOT_NUMERIC)
						return new SAFEShellStrings(TOP);

				}

				else if (that.isSignedNumber()) {
					if (containsSignedNumbers()) 
						return clone();
					else if (getAbstractValue() == UINT)
						return new SAFEShellStrings(NUMERIC);		
					else if (getAbstractValue() == UFLOAT)
						return new SAFEShellStrings(NUMERIC);		
					else if (getAbstractValue() == UNUM)
						return new SAFEShellStrings(NUMERIC);		
					else if (getAbstractValue() == NOTNUM_NOTEMPTY)
						return new SAFEShellStrings(NOTUNSIGNED_NOTEMPTY);
					else if (getAbstractValue() == NOT_NUMERIC)
						return new SAFEShellStrings(TOP);	
					else if (getAbstractValue() == UNUM_EPSILON)
						return new SAFEShellStrings(TOP);			
					else if (getAbstractValue() == UINT_EPSILON)
						return new SAFEShellStrings(TOP);
				}

				else if (that.isNotNumericAndNotEmpty()) {
					if (containsNotNumericNotEmptyStrings())
						return clone();
					else if (getAbstractValue() == UINT)
						return new SAFEShellStrings(TOP);
					else if (getAbstractValue() == UINT_EPSILON)
						return new SAFEShellStrings(TOP);
					else if (getAbstractValue() == UNUM)
						return new SAFEShellStrings(TOP);
					else if (getAbstractValue() == UNUM_EPSILON)
						return new SAFEShellStrings(TOP);
					else if (getAbstractValue() == UFLOAT)
						return new SAFEShellStrings(NOTUINT_NOTEMPTY);
					else if (getAbstractValue() == NUMERIC)
						return new SAFEShellStrings(TOP);
					else if (getAbstractValue() == NOT_NUMERIC)
						return new SAFEShellStrings(TOP);
					else if (getAbstractValue() == SIGNED_NUM)
						return new SAFEShellStrings(NOTUNSIGNED_NOTEMPTY);
				}
			}

			// All the cases where one of the two parameter is a single string is handled before

			else if (v == UINT) {
				
				if (that.getAbstractValue() == UINT)
					return new SAFEShellStrings(UINT);
				
				else if (that.getAbstractValue() == UINT_EPSILON)
					return new SAFEShellStrings(UINT_EPSILON);
				
				else if (that.getAbstractValue() == UNUM)
					return new SAFEShellStrings(UNUM);
				
				else if (that.getAbstractValue() == UNUM_EPSILON)
					return new SAFEShellStrings(UNUM_EPSILON);
				
				else if (that.getAbstractValue() == UFLOAT)
					return new SAFEShellStrings(UNUM);
				
				else if (that.getAbstractValue() == NUMERIC)
					return new SAFEShellStrings(NUMERIC);
				
				else if (that.getAbstractValue() == SIGNED_NUM)
					return new SAFEShellStrings(NUMERIC);
				
				else if (that.getAbstractValue() == NOTNUM_NOTEMPTY)
					return new SAFEShellStrings(TOP);
				
				else if (that.getAbstractValue() == NOTUNSIGNED_NOTEMPTY)
					return new SAFEShellStrings(TOP);
				
				else if (that.getAbstractValue() == NOTUINT_NOTEMPTY)
					return new SAFEShellStrings(TOP);
				
				else if (that.getAbstractValue() == NOT_NUMERIC)
					return new SAFEShellStrings(TOP);

			}

			else if (v == UINT_EPSILON) {
				if (that.getAbstractValue() == UINT)
					return new SAFEShellStrings(UINT_EPSILON);
				
				else if (that.getAbstractValue() == UINT_EPSILON)
					return new SAFEShellStrings(UINT_EPSILON);
				
				else if (that.getAbstractValue() == UNUM)
					return new SAFEShellStrings(UNUM_EPSILON);
				
				else if (that.getAbstractValue() == UNUM_EPSILON)
					return new SAFEShellStrings(UNUM_EPSILON);
				
				else if (that.getAbstractValue() == UFLOAT)
					return new SAFEShellStrings(UNUM_EPSILON);
				
				else if (that.getAbstractValue() == NUMERIC)
					return new SAFEShellStrings(TOP);
				
				else if (that.getAbstractValue() == SIGNED_NUM)
					return new SAFEShellStrings(TOP);
				
				else if (that.getAbstractValue() == NOTNUM_NOTEMPTY)
					return new SAFEShellStrings(TOP);
				
				else if (that.getAbstractValue() == NOTUNSIGNED_NOTEMPTY)
					return new SAFEShellStrings(TOP);
				
				else if (that.getAbstractValue() == NOTUINT_NOTEMPTY)
					return new SAFEShellStrings(TOP);
				
				else if (that.getAbstractValue() == NOT_NUMERIC)
					return new SAFEShellStrings(TOP);
			}

			else if (v == UNUM) {
				if (that.getAbstractValue() == UINT)
					return new SAFEShellStrings(UNUM);
				
				else if (that.getAbstractValue() == UINT_EPSILON)
					return new SAFEShellStrings(UNUM_EPSILON);
				
				else if (that.getAbstractValue() == UNUM)
					return new SAFEShellStrings(UNUM);
				
				else if (that.getAbstractValue() == UNUM_EPSILON)
					return new SAFEShellStrings(UNUM_EPSILON);
				
				else if (that.getAbstractValue() == UFLOAT)
					return new SAFEShellStrings(UNUM);
				
				else if (that.getAbstractValue() == NUMERIC)
					return new SAFEShellStrings(NUMERIC);
				
				else if (that.getAbstractValue() == SIGNED_NUM)
					return new SAFEShellStrings(NUMERIC);
				
				else if (that.getAbstractValue() == NOTNUM_NOTEMPTY)
					return new SAFEShellStrings(TOP);
				
				else if (that.getAbstractValue() == NOTUNSIGNED_NOTEMPTY)
					return new SAFEShellStrings(TOP);
				
				else if (that.getAbstractValue() == NOTUINT_NOTEMPTY)
					return new SAFEShellStrings(TOP);
				
				else if (that.getAbstractValue() == NOT_NUMERIC)
					return new SAFEShellStrings(TOP);
			}

			else if (v == UNUM_EPSILON) {
				if (that.getAbstractValue() == UINT)
					return new SAFEShellStrings(UNUM_EPSILON);
				
				else if (that.getAbstractValue() == UINT_EPSILON)
					return new SAFEShellStrings(UNUM_EPSILON);
				
				else if (that.getAbstractValue() == UNUM)
					return new SAFEShellStrings(UNUM_EPSILON);
				
				else if (that.getAbstractValue() == UNUM_EPSILON)
					return new SAFEShellStrings(UNUM_EPSILON);
				
				else if (that.getAbstractValue() == UFLOAT)
					return new SAFEShellStrings(UNUM_EPSILON);
				
				else if (that.getAbstractValue() == NUMERIC)
					return new SAFEShellStrings(TOP);
				
				else if (that.getAbstractValue() == SIGNED_NUM)
					return new SAFEShellStrings(TOP);
				
				else if (that.getAbstractValue() == NOTNUM_NOTEMPTY)
					return new SAFEShellStrings(TOP);
				
				else if (that.getAbstractValue() == NOTUNSIGNED_NOTEMPTY)
					return new SAFEShellStrings(TOP);
				
				else if (that.getAbstractValue() == NOTUINT_NOTEMPTY)
					return new SAFEShellStrings(TOP);
				
				else if (that.getAbstractValue() == NOT_NUMERIC)
					return new SAFEShellStrings(TOP);
			}
			
			else if (v == UFLOAT) {
				if (that.getAbstractValue() == UINT)
					return new SAFEShellStrings(UNUM);
				
				else if (that.getAbstractValue() == UINT_EPSILON)
					return new SAFEShellStrings(UNUM_EPSILON);
				
				else if (that.getAbstractValue() == UNUM)
					return new SAFEShellStrings(UNUM);
				
				else if (that.getAbstractValue() == UNUM_EPSILON)
					return new SAFEShellStrings(UNUM_EPSILON);
				
				else if (that.getAbstractValue() == UFLOAT)
					return new SAFEShellStrings(UFLOAT);
				
				else if (that.getAbstractValue() == NUMERIC)
					return new SAFEShellStrings(NUMERIC);
				
				else if (that.getAbstractValue() == SIGNED_NUM)
					return new SAFEShellStrings(NUMERIC);
				
				else if (that.getAbstractValue() == NOTNUM_NOTEMPTY)
					return new SAFEShellStrings(NOTUINT_NOTEMPTY);
				
				else if (that.getAbstractValue() == NOTUNSIGNED_NOTEMPTY)
					return new SAFEShellStrings(NOTUINT_NOTEMPTY);
				
				else if (that.getAbstractValue() == NOTUINT_NOTEMPTY)
					return new SAFEShellStrings(NOTUINT_NOTEMPTY);
				
				else if (that.getAbstractValue() == NOT_NUMERIC)
					return new SAFEShellStrings(TOP);
			}
			
			else if (v == NUMERIC) {
				if (that.getAbstractValue() == UINT)
					return new SAFEShellStrings(NUMERIC);
				
				else if (that.getAbstractValue() == UINT_EPSILON)
					return new SAFEShellStrings(TOP);
				
				else if (that.getAbstractValue() == UNUM)
					return new SAFEShellStrings(NUMERIC);
				
				else if (that.getAbstractValue() == UNUM_EPSILON)
					return new SAFEShellStrings(TOP);
				
				else if (that.getAbstractValue() == UFLOAT)
					return new SAFEShellStrings(NUMERIC);
				
				else if (that.getAbstractValue() == NUMERIC)
					return new SAFEShellStrings(NUMERIC);
				
				else if (that.getAbstractValue() == SIGNED_NUM)
					return new SAFEShellStrings(NUMERIC);
				
				else if (that.getAbstractValue() == NOTNUM_NOTEMPTY)
					return new SAFEShellStrings(TOP);
				
				else if (that.getAbstractValue() == NOTUNSIGNED_NOTEMPTY)
					return new SAFEShellStrings(TOP);
				
				else if (that.getAbstractValue() == NOTUINT_NOTEMPTY)
					return new SAFEShellStrings(TOP);
				
				else if (that.getAbstractValue() == NOT_NUMERIC)
					return new SAFEShellStrings(TOP);
			}

			else if (v == SIGNED_NUM) {
				if (that.getAbstractValue() == UINT)
					return new SAFEShellStrings(NUMERIC);
				
				else if (that.getAbstractValue() == UINT_EPSILON)
					return new SAFEShellStrings(TOP);
				
				else if (that.getAbstractValue() == UNUM)
					return new SAFEShellStrings(NUMERIC);
				
				else if (that.getAbstractValue() == UNUM_EPSILON)
					return new SAFEShellStrings(TOP);
				
				else if (that.getAbstractValue() == UFLOAT)
					return new SAFEShellStrings(NUMERIC);
				
				else if (that.getAbstractValue() == NUMERIC)
					return new SAFEShellStrings(NUMERIC);
				
				else if (that.getAbstractValue() == SIGNED_NUM)
					return new SAFEShellStrings(NUMERIC);
				
				else if (that.getAbstractValue() == NOTNUM_NOTEMPTY)
					return new SAFEShellStrings(NOTUNSIGNED_NOTEMPTY);
				
				else if (that.getAbstractValue() == NOTUNSIGNED_NOTEMPTY)
					return new SAFEShellStrings(NOTUNSIGNED_NOTEMPTY);
				
				else if (that.getAbstractValue() == NOTUINT_NOTEMPTY)
					return new SAFEShellStrings(NOTUINT_NOTEMPTY);
				
				else if (that.getAbstractValue() == NOT_NUMERIC)
					return new SAFEShellStrings(TOP);
			}

			else if (v == NOTNUM_NOTEMPTY) {
				if (that.getAbstractValue() == UINT)
					return new SAFEShellStrings(TOP);
				
				else if (that.getAbstractValue() == UINT_EPSILON)
					return new SAFEShellStrings(TOP);
				
				else if (that.getAbstractValue() == UNUM)
					return new SAFEShellStrings(TOP);
				
				else if (that.getAbstractValue() == UNUM_EPSILON)
					return new SAFEShellStrings(TOP);
				
				else if (that.getAbstractValue() == UFLOAT)
					return new SAFEShellStrings(NOTUINT_NOTEMPTY);
				
				else if (that.getAbstractValue() == NUMERIC)
					return new SAFEShellStrings(TOP);
				
				else if (that.getAbstractValue() == SIGNED_NUM)
					return new SAFEShellStrings(NOTUNSIGNED_NOTEMPTY);
				
				else if (that.getAbstractValue() == NOTNUM_NOTEMPTY)
					return new SAFEShellStrings(NOTNUM_NOTEMPTY);
				
				else if (that.getAbstractValue() == NOTUNSIGNED_NOTEMPTY)
					return new SAFEShellStrings(NOTUNSIGNED_NOTEMPTY);
				
				else if (that.getAbstractValue() == NOTUINT_NOTEMPTY)
					return new SAFEShellStrings(NOTUINT_NOTEMPTY);
				
				else if (that.getAbstractValue() == NOT_NUMERIC)
					return new SAFEShellStrings(TOP);
			}

			else if (v == NOTUNSIGNED_NOTEMPTY) {
				if (that.getAbstractValue() == UINT)
					return new SAFEShellStrings(TOP);
				
				else if (that.getAbstractValue() == UINT_EPSILON)
					return new SAFEShellStrings(TOP);
				
				else if (that.getAbstractValue() == UNUM)
					return new SAFEShellStrings(TOP);
				
				else if (that.getAbstractValue() == UNUM_EPSILON)
					return new SAFEShellStrings(TOP);
				
				else if (that.getAbstractValue() == UFLOAT)
					return new SAFEShellStrings(NOTUINT_NOTEMPTY);
				
				else if (that.getAbstractValue() == NUMERIC)
					return new SAFEShellStrings(TOP);
				
				else if (that.getAbstractValue() == SIGNED_NUM)
					return new SAFEShellStrings(NOTUNSIGNED_NOTEMPTY);
				
				else if (that.getAbstractValue() == NOTNUM_NOTEMPTY)
					return new SAFEShellStrings(NOTNUM_NOTEMPTY);
				
				else if (that.getAbstractValue() == NOTUNSIGNED_NOTEMPTY)
					return new SAFEShellStrings(NOTUNSIGNED_NOTEMPTY);
				
				else if (that.getAbstractValue() == NOTUINT_NOTEMPTY)
					return new SAFEShellStrings(NOTUINT_NOTEMPTY);
				
				else if (that.getAbstractValue() == NOT_NUMERIC)
					return new SAFEShellStrings(TOP);
			}

			else if (v == NOT_NUMERIC) {
				if (that.getAbstractValue() == UINT)
					return new SAFEShellStrings(TOP);
				
				else if (that.getAbstractValue() == UINT_EPSILON)
					return new SAFEShellStrings(TOP);
				
				else if (that.getAbstractValue() == UNUM)
					return new SAFEShellStrings(TOP);
				
				else if (that.getAbstractValue() == UNUM_EPSILON)
					return new SAFEShellStrings(TOP);
				
				else if (that.getAbstractValue() == UFLOAT)
					return new SAFEShellStrings(TOP);
				
				else if (that.getAbstractValue() == NUMERIC)
					return new SAFEShellStrings(TOP);
				
				else if (that.getAbstractValue() == SIGNED_NUM)
					return new SAFEShellStrings(TOP);
				
				else if (that.getAbstractValue() == NOTNUM_NOTEMPTY)
					return new SAFEShellStrings(NOTNUM_NOTEMPTY);
				
				else if (that.getAbstractValue() == NOTUNSIGNED_NOTEMPTY)
					return new SAFEShellStrings(TOP);
				
				else if (that.getAbstractValue() == NOTUINT_NOTEMPTY)
					return new SAFEShellStrings(TOP);
				
				else if (that.getAbstractValue() == NOT_NUMERIC)
					return new SAFEShellStrings(NOT_NUMERIC);
			}

			else if (v == NOTUINT_NOTEMPTY) {
				if (that.getAbstractValue() == UINT)
					return new SAFEShellStrings(TOP);
				
				else if (that.getAbstractValue() == UINT_EPSILON)
					return new SAFEShellStrings(TOP);
				
				else if (that.getAbstractValue() == UNUM)
					return new SAFEShellStrings(TOP);
				
				else if (that.getAbstractValue() == UNUM_EPSILON)
					return new SAFEShellStrings(TOP);
				
				else if (that.getAbstractValue() == UFLOAT)
					return new SAFEShellStrings(NOTUINT_NOTEMPTY);
				
				else if (that.getAbstractValue() == NUMERIC)
					return new SAFEShellStrings(TOP);
				
				else if (that.getAbstractValue() == SIGNED_NUM)
					return new SAFEShellStrings(NOTUINT_NOTEMPTY);
				
				else if (that.getAbstractValue() == NOTNUM_NOTEMPTY)
					return new SAFEShellStrings(NOTUINT_NOTEMPTY);
				
				else if (that.getAbstractValue() == NOTUNSIGNED_NOTEMPTY)
					return new SAFEShellStrings(NOTUINT_NOTEMPTY);
				
				else if (that.getAbstractValue() == NOTUINT_NOTEMPTY)
					return new SAFEShellStrings(NOTUINT_NOTEMPTY);
				
				else if (that.getAbstractValue() == NOT_NUMERIC)
					return new SAFEShellStrings(NOTUINT_NOTEMPTY);
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
		else if (v == UINT)
			return "UInt";
		else if (v == UFLOAT)
			return "UFloat";
		else if (v == SIGNED_NUM)
			return "SignedNum";
		else if (v == NOTNUM_NOTEMPTY)
			return "NotNumNotEmpty";
		else if (v == UNUM)
			return "UNum";
		else if (v == UINT_EPSILON)
			return "UInt|Empty";
		else if (v == UNUM)
			return "UNum";
		else if (v == NOTUNSIGNED_NOTEMPTY)
			return "NotUnsignedNotEmpty";
		else if (v == UNUM_EPSILON)
			return "UNum|Empty";
		else if (v == NOTUINT_NOTEMPTY)
			return "NotUIntNotEmpty";
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

	private boolean isNotNumericAndNotEmpty() {
		assertTrue(isString());
		return !isNumericString() && !isEmptyString();
	}

	private boolean containsEpsilonString() {
		return v == UINT_EPSILON || v == UNUM_EPSILON || v == NOT_NUMERIC || v == TOP;
	}

	private boolean containsUnsignedIntegerStrings() {
		return v == UINT || v == UINT_EPSILON || v == UNUM || v == UNUM_EPSILON || v == NUMERIC || v == TOP;
	}

	private boolean containsUnsignedFloats() {
		return v == UNUM || v == UNUM_EPSILON || v == UFLOAT || v == NUMERIC || v == NOTUINT_NOTEMPTY || v == TOP;
	}

	private boolean containsSignedNumbers() {
		return v == SIGNED_NUM || v == NUMERIC || v == NOTUNSIGNED_NOTEMPTY || v == NOTUINT_NOTEMPTY || v == TOP;
	}

	private boolean containsNotNumericNotEmptyStrings() {
		return v == NOTNUM_NOTEMPTY || v == NOTUNSIGNED_NOTEMPTY || v == NOTUINT_NOTEMPTY || v == TOP;
	}



}
