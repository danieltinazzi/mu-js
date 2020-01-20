package it.univr.domain.tajs.shell;

import org.junit.Assert;
import org.junit.Test;

import it.univr.domain.tajs.original.TAJSAbstractDomain;
import it.univr.domain.tajs.original.TAJSNumbers;
import it.univr.domain.tajs.original.TAJSStrings;
import it.univr.main.Analyzer;
import it.univr.state.AbstractEnvironment;
import it.univr.state.Variable;

public class TAJSComparisonTest {
	private TAJSAbstractDomain original = new TAJSAbstractDomain();
	private TAJSShellAbstractDomain shell = new TAJSShellAbstractDomain();


	@Test
	public void testTAJSComparisong001() throws Exception {
		String file = "src/test/resources/tajs-comp/tajs001.js";
		AbstractEnvironment state = Analyzer.analyze(file, original, false);

		// State size
		Assert.assertEquals(state.sizeStore(), 4);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("str")), new TAJSStrings("12345678"));
		Assert.assertEquals(state.getValue(new Variable("numbers")), TAJSStrings.createTopTAJSString());
		Assert.assertEquals(state.getValue(new Variable("notnumbers")), TAJSStrings.createTopTAJSString());
		Assert.assertEquals(state.getValue(new Variable("i")), new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true));
		
		state = Analyzer.analyze(file, shell, false);

		// State size
		Assert.assertEquals(state.sizeStore(), 4);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("str")), new TAJSShellStrings("12345678"));
		Assert.assertEquals(state.getValue(new Variable("numbers")), new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC));
		Assert.assertEquals(state.getValue(new Variable("notnumbers")), new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC));
		Assert.assertEquals(state.getValue(new Variable("i")), new it.univr.domain.tajs.shell.TAJSNumbers(it.univr.domain.tajs.shell.TAJSNumbers.UNSIGNED_INT, true));
	}
}
