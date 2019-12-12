package it.univr.domain.tajs.original;

import org.junit.Assert;
import org.junit.Test;

import it.univr.main.Analyzer;
import it.univr.state.AbstractMemory;
import it.univr.state.Variable;

public class SAFEWhileTest {

	private SAFEAbstractDomain domain = new SAFEAbstractDomain();

	@Test
	public void testWhile001() throws Exception {
		String file = "src/test/resources/while/while001.js";
		AbstractMemory state = Analyzer.analyze(file, domain, true);

		// State size
		Assert.assertEquals(state.size(), 1);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("0", "+Inf"));
	}

	@Test
	public void testWhile002() throws Exception {
		String file = "src/test/resources/while/while002.js";
		AbstractMemory state = Analyzer.analyze(file, domain, true);

		// State size
		Assert.assertEquals(state.size(), 1);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), SAFEStrings.createNotNumeric());
	}

	@Test
	public void testWhile003() throws Exception {
		String file = "src/test/resources/while/while003.js";
		AbstractMemory state = Analyzer.analyze(file, domain, true);

		// State size
		Assert.assertEquals(state.size(), 1);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new SAFEStrings(""));
	}

	@Test
	public void testWhile004() throws Exception {
		String file = "src/test/resources/while/while004.js";
		AbstractMemory state = Analyzer.analyze(file, domain, true);

		// State size
		Assert.assertEquals(state.size(), 1);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("-Inf", "100"));
	}	

	@Test
	public void testWhile005() throws Exception {
		String file = "src/test/resources/while/while005.js";
		AbstractMemory state = Analyzer.analyze(file, domain, true);

		// State size
		Assert.assertEquals(state.size(), 2);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("0", "+Inf"));
		Assert.assertEquals(state.getValue(new Variable("y")), new Interval("0", "+Inf"));
	}


	@Test
	public void testWhile006() throws Exception {
		String file = "src/test/resources/while/while006.js";
		AbstractMemory state = Analyzer.analyze(file, domain, true);

		// State size
		Assert.assertEquals(state.size(), 2);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("0", "+Inf"));
		Assert.assertEquals(state.getValue(new Variable("y")), new Interval("0", "+Inf"));
	}
}
