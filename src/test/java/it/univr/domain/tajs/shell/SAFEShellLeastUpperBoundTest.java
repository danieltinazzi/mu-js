package it.univr.domain.tajs.shell;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SAFEShellLeastUpperBoundTest {

	
	@Test
	public void testLub001() throws Exception {

		assertEquals(new SAFEShellStrings("1").leastUpperBound(new SAFEShellStrings("2")), new SAFEShellStrings(SAFEShellStrings.UINT));
		assertEquals(new SAFEShellStrings("1").leastUpperBound(new SAFEShellStrings("2.1")), new SAFEShellStrings(SAFEShellStrings.UNUM));
		assertEquals(new SAFEShellStrings("1").leastUpperBound(new SAFEShellStrings("")), new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON));

	}
}
