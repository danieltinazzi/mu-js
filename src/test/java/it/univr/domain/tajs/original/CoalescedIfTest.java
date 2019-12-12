package it.univr.domain.tajs.original;

import org.junit.Assert;
import org.junit.Test;

import it.univr.domain.tajs.original.Interval;
import it.univr.domain.tajs.original.SAFEAbstractDomain;
import it.univr.domain.tajs.original.SAFEStrings;
import it.univr.domain.tajs.original.Top;
import it.univr.main.Analyzer;
import it.univr.state.AbstractMemory;
import it.univr.state.Variable;

public class CoalescedIfTest {

	private SAFEAbstractDomain domain = new SAFEAbstractDomain();


	@Test
	public void testIf001() throws Exception {
		String file = "src/test/resources/if/if001.js";
		AbstractMemory state = Analyzer.analyze(file, domain, false);

		// State size
		Assert.assertEquals(state.size(), 1);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("1", "1"));
	}

	@Test
	public void testIf002() throws Exception {
		String file = "src/test/resources/if/if002.js";
		AbstractMemory state = Analyzer.analyze(file, domain, false);

		// State size
		Assert.assertEquals(state.size(), 2);

		// State values
		Assert.assertEquals(state.getValue(new Variable("a")), new Interval("0", "+Inf"));
		Assert.assertEquals(state.getValue(new Variable("x")), new Top());
	}

	@Test
	public void testIf003() throws Exception {
		String file = "src/test/resources/if/if003.js";
		AbstractMemory state = Analyzer.analyze(file, domain, false);

		// State size
		Assert.assertEquals(state.size(), 2);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), SAFEStrings.createNotNumeric());
		Assert.assertEquals(state.getValue(new Variable("y")), new Interval("0", "+Inf"));
	}

	@Test
	public void testIf004() throws Exception {
		String file = "src/test/resources/if/if004.js";
		AbstractMemory state = Analyzer.analyze(file, domain, false);

		// State size
		Assert.assertEquals(state.size(), 1);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("2", "2"));
	}

	@Test
	public void testIf005() throws Exception {
		String file = "src/test/resources/if/if005.js";
		AbstractMemory state = Analyzer.analyze(file, domain, false);

		// State size
		Assert.assertEquals(state.size(), 1);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("2", "2"));
	}	

	@Test
	public void testIf006() throws Exception {
		String file = "src/test/resources/if/if006.js";
		AbstractMemory state = Analyzer.analyze(file, domain, false);

		// State size
		Assert.assertEquals(state.size(), 1);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("0", "0"));
	}	

	@Test
	public void testIf007() throws Exception {
		String file = "src/test/resources/if/if007.js";
		AbstractMemory state = Analyzer.analyze(file, domain, false);

		// State size
		Assert.assertEquals(state.size(), 1);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("1", "1"));
	}

	@Test
	public void testIf008() throws Exception {
		String file = "src/test/resources/if/if008.js";
		AbstractMemory state = Analyzer.analyze(file, domain, false);

		// State size
		Assert.assertEquals(state.size(), 3);

		// State values
		Assert.assertEquals(state.getValue(new Variable("a")), new Interval("0", "+Inf"));
		Assert.assertEquals(state.getValue(new Variable("str")), new SAFEStrings("helloworld"));
		Assert.assertEquals(state.getValue(new Variable("c")), SAFEStrings.createNotNumeric());
	}

	@Test
	public void testIf009() throws Exception {
		String file = "src/test/resources/if/if009.js";
		AbstractMemory state = Analyzer.analyze(file, domain, false);

		// State size
		Assert.assertEquals(state.size(), 2);

		// State values
		Assert.assertEquals(state.getValue(new Variable("a")), new Interval("0", "+Inf"));
		Assert.assertEquals(state.getValue(new Variable("str")), SAFEStrings.createNotNumeric());
	}

	@Test
	public void testIf010() throws Exception {
		String file = "src/test/resources/if/if010.js";
		AbstractMemory state = Analyzer.analyze(file, domain, false);

		// State size
		Assert.assertEquals(state.size(), 2);
				
		// State values
		Assert.assertEquals(state.getValue(new Variable("i")), new Interval("0", "+Inf"));
		Assert.assertEquals(state.getValue(new Variable("str")),  SAFEStrings.createNotNumeric());
	}
}
