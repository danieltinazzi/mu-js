package it.univr.main.lifted;

import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;

import it.univr.domain.coalasced.FA;
import it.univr.domain.coalasced.Interval;
import it.univr.domain.lifted.LiftedUnionAbstractDomain;
import it.univr.domain.lifted.LiftedUnionAbstractValue;
import it.univr.fsm.machine.Automaton;
import it.univr.fsm.machine.State;
import it.univr.fsm.machine.Transition;
import it.univr.main.Analyzer;
import it.univr.state.AbstractMemory;
import it.univr.state.Variable;

public class LiftedUnionWhileTest {

	private LiftedUnionAbstractDomain domain = new LiftedUnionAbstractDomain();

	@Test
	public void testWhile001() throws Exception {
		String file = "src/test/resources/while/while001.js";
		AbstractMemory state = Analyzer.analyze(file, domain, true);

		// State size
		Assert.assertEquals(state.size(), 1);
		
		LiftedUnionAbstractValue x = new LiftedUnionAbstractValue();
		x.setInterval(new Interval("100", "100"));
		
		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), x);
	}

	@Test
	public void testWhile002() throws Exception {
		String file = "src/test/resources/while/while002.js";
		AbstractMemory state = Analyzer.analyze(file, domain, true);

		HashSet<State> states = new HashSet<State>();
		HashSet<Transition> delta = new HashSet<Transition>();

		State q0 = new State("q0", true, true);

		states.add(q0);

		delta.add(new Transition(q0, q0, "a"));

		// a^* 
		Automaton a = new Automaton(delta, states);

		// State size
		Assert.assertEquals(state.size(), 1);

		
		LiftedUnionAbstractValue x = new LiftedUnionAbstractValue();
		x.setFA(new FA(a));
		
		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), x);
	}

	@Test
	public void testWhile003() throws Exception {
		String file = "src/test/resources/while/while003.js";
		AbstractMemory state = Analyzer.analyze(file, domain, true);

		// State size
		Assert.assertEquals(state.size(), 1);

		LiftedUnionAbstractValue x = new LiftedUnionAbstractValue();
		x.setFA(new FA(Automaton.makeEmptyString()));
		
		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), x);
	}

	@Test
	public void testWhile004() throws Exception {
		String file = "src/test/resources/while/while004.js";
		AbstractMemory state = Analyzer.analyze(file, domain, true);

		// State size
		Assert.assertEquals(state.size(), 1);
		
		LiftedUnionAbstractValue x = new LiftedUnionAbstractValue();
		x.setInterval(new Interval("0", "0"));
		
		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), x);
	}	

	@Test
	public void testWhile005() throws Exception {
		String file = "src/test/resources/while/while005.js";
		AbstractMemory state = Analyzer.analyze(file, domain, true);

		// State size
		Assert.assertEquals(state.size(), 2);

		
		LiftedUnionAbstractValue x = new LiftedUnionAbstractValue();
		x.setInterval(new Interval("0", "+Inf"));
		
		LiftedUnionAbstractValue y = new LiftedUnionAbstractValue();
		y.setInterval(new Interval("100", "100"));
		
		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), x);
		Assert.assertEquals(state.getValue(new Variable("y")), y);
	}


	@Test
	public void testWhile006() throws Exception {
		String file = "src/test/resources/while/while006.js";
		AbstractMemory state = Analyzer.analyze(file, domain, true);

		// State size
		Assert.assertEquals(state.size(), 2);

		LiftedUnionAbstractValue x = new LiftedUnionAbstractValue();
		x.setInterval(new Interval("0", "+Inf"));
		
		LiftedUnionAbstractValue y = new LiftedUnionAbstractValue();
		y.setInterval(new Interval("100", "101"));
		
		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), x);
		Assert.assertEquals(state.getValue(new Variable("y")), y);
	}
}
