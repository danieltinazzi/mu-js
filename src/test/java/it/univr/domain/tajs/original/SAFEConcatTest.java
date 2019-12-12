package it.univr.domain.tajs.original;

import org.junit.Assert;
import org.junit.Test;

import it.univr.main.Analyzer;
import it.univr.state.AbstractMemory;
import it.univr.state.Variable;

public class SAFEConcatTest {
	private SAFEAbstractDomain domain = new SAFEAbstractDomain();

	private String path = "src/test/resources/concat/";
	
	@Test
	public void testConcat001() throws Exception {
		String file = path + "concat001.js";
		AbstractMemory state = Analyzer.analyze(file, domain, true);

		// State size
		Assert.assertEquals(state.size(), 1);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new SAFEStrings("12"));
	}
	
	@Test
	public void testConcat002() throws Exception {
		String file = path + "concat002.js";
		AbstractMemory state = Analyzer.analyze(file, domain, true);

		// State size
		Assert.assertEquals(state.size(), 4);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new SAFEStrings("12"));
		Assert.assertEquals(state.getValue(new Variable("y")), new SAFEStrings("35"));
		Assert.assertEquals(state.getValue(new Variable("z")), SAFEStrings.createNumeric());
		Assert.assertEquals(state.getValue(new Variable("i")), new Interval("0", "+Inf"));
	}
	
	@Test
	public void testConcat003() throws Exception {
		String file = path + "concat003.js";
		AbstractMemory state = Analyzer.analyze(file, domain, true);

		// State size
		Assert.assertEquals(state.size(), 4);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new SAFEStrings("12"));
		Assert.assertEquals(state.getValue(new Variable("y")), new SAFEStrings("g5"));
		Assert.assertEquals(state.getValue(new Variable("z")), SAFEStrings.createTopString());
		Assert.assertEquals(state.getValue(new Variable("i")), new Interval("0", "+Inf"));
	}
	

	@Test
	public void testConcat004() throws Exception {
		String file = path + "concat004.js";
		AbstractMemory state = Analyzer.analyze(file, domain, true);

		// State size
		Assert.assertEquals(state.size(), 4);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new SAFEStrings("d2"));
		Assert.assertEquals(state.getValue(new Variable("y")), new SAFEStrings("g5"));
		Assert.assertEquals(state.getValue(new Variable("z")), SAFEStrings.createNotNumeric());
		Assert.assertEquals(state.getValue(new Variable("i")), new Interval("0", "+Inf"));
	}
}
