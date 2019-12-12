package it.univr.main;

import it.univr.domain.AbstractDomain;
import it.univr.domain.AbstractValue;

import it.univr.state.AbstractMemory;
import it.univr.state.AbstractState;
import it.univr.state.KeyAbstractState;
import it.univr.state.Variable;

public class AbstractInterpreter extends MuJsBaseVisitor<AbstractValue> {

	private AbstractMemory memory;
	private AbstractDomain domain;
	private AbstractState state;

	private boolean printInvariants;

	public AbstractInterpreter(AbstractDomain domain, boolean narrowing, boolean invariants) {
		this.memory = new AbstractMemory(domain);
		this.state = new AbstractState();
		this.printInvariants = invariants;
	}

	public AbstractMemory getFinalAbstractMemory() {
		return memory;
	}

	public AbstractState getAbstractState() {
		return state;
	}

	public void setAbstractState(AbstractMemory state) {
		this.memory = state;
	}

	public AbstractDomain getAbstractDomain() {
		return domain;
	}

	public void setAbstractDomain(AbstractDomain domain) {
		this.domain = domain;
	}

	

	@Override 
	public AbstractValue visitBlock(MuJsParser.BlockContext ctx) { 
		if (ctx.stmt() != null)
			visit(ctx.stmt());
		return domain.makeBottom();
	}

	@Override 
	public AbstractValue visitComposition(MuJsParser.CompositionContext ctx) { 
		visit(ctx.stmt(0));	
		visit(ctx.stmt(1));
		return domain.makeBottom();
	}

	@Override 
	public AbstractValue visitIfStmt(MuJsParser.IfStmtContext ctx) { 
		if (domain.isTrue(visit(ctx.bexp()))) 
			return visit(ctx.block(0));

		if (domain.isFalse(visit(ctx.bexp())))
			return visit(ctx.block(1));

		AbstractMemory previous = (AbstractMemory) memory.clone();

		visit(ctx.block(0));

		AbstractMemory trueBranch = (AbstractMemory) memory.clone();
		memory = previous;

		visit(ctx.block(1));

		memory = memory.leastUpperBound(trueBranch);

		if (printInvariants) {
			KeyAbstractState key = new KeyAbstractState(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
			state.add(key, memory.clone());
		}		

		return domain.makeBottom();
	}

	@Override 
	public AbstractValue visitProgramExecution(MuJsParser.ProgramExecutionContext ctx) {
		return visit(ctx.stmt()); 
	}


	@Override public AbstractValue visitEquals(MuJsParser.EqualsContext ctx) { 
		AbstractValue left = visit(ctx.aexp(0));
		AbstractValue right = visit(ctx.aexp(1));

		return domain.equals(left, right);
	}

	@Override 
	public AbstractValue visitLess(MuJsParser.LessContext ctx) { 
		AbstractValue left = visit(ctx.aexp(0));
		AbstractValue right = visit(ctx.aexp(1));

		return domain.less(left, right);
	}

	@Override 
	public AbstractValue visitDiff(MuJsParser.DiffContext ctx) { 
		AbstractValue left = visit(ctx.aexp(0));
		AbstractValue right = visit(ctx.aexp(1));

		return domain.diff(left, right);
	}

	@Override 
	public AbstractValue visitMul(MuJsParser.MulContext ctx) {
		AbstractValue left = visit(ctx.aexp(0));
		AbstractValue right = visit(ctx.aexp(1));

		return domain.mul(left, right);
	}


	@Override 
	public AbstractValue visitSum(MuJsParser.SumContext ctx) { 
		AbstractValue left = visit(ctx.aexp(0));
		AbstractValue right = visit(ctx.aexp(1));

		return domain.sum(left, right);
	}

	//TODO: division
	@Override 
	public AbstractValue visitDiv(MuJsParser.DivContext ctx) { 
		AbstractValue left = visit(ctx.aexp(0));
		AbstractValue right = visit(ctx.aexp(1));

		return domain.div(left, right);
	}

	@Override 
	public AbstractValue visitNot(MuJsParser.NotContext ctx) { 
		AbstractValue v = visit(ctx.bexp());
		return domain.not(v);		
	}


	@Override 
	public AbstractValue visitConcat(MuJsParser.ConcatContext ctx) { 
		AbstractValue first = visit(ctx.sexp(0));
		AbstractValue second = visit(ctx.sexp(1));

		return domain.concat(first, second);
	}

	@Override 
	public AbstractValue visitAnd(MuJsParser.AndContext ctx) { 
		AbstractValue first = visit(ctx.bexp(0));
		AbstractValue second = visit(ctx.bexp(1));

		return domain.and(first, second);
	}

	@Override 
	public AbstractValue visitOr(MuJsParser.OrContext ctx) { 
		AbstractValue first = visit(ctx.bexp(0));
		AbstractValue second = visit(ctx.bexp(1));

		return domain.or(first, second);
	}
	
	@Override
	public AbstractValue visitIdBExp(MuJsParser.IdBExpContext ctx) { 
		Variable v = new Variable(ctx.ID().getText());

		if (memory.containsKey(v))
			return memory.get(v);
		else
			return domain.makeBottom();
	}
	
	@Override 
	public AbstractValue visitInt(MuJsParser.IntContext ctx) { 
		return domain.makeIntegerAbstractValue(Integer.valueOf(ctx.INT().getText()));
	}
	@Override 
	public AbstractValue visitStr(MuJsParser.StrContext ctx) { 
		return domain.makeStringAbstractValue(ctx.STRING().getText().substring(0, ctx.STRING().getText().length()-1).substring(1));
	}	
	
	@Override public AbstractValue visitBool(MuJsParser.BoolContext ctx) { 
		return domain.makeBooleanAbstractValue(ctx.BOOL().getText().equals("true") ? 1 : 0);
	}
	
	@Override 
	public AbstractValue visitParenthesis(MuJsParser.ParenthesisContext ctx) {
		return visit(ctx.exp()); 
	}
	
	@Override 
	public AbstractValue visitWhileStmt(MuJsParser.WhileStmtContext ctx) { 

		AbstractMemory previous = (AbstractMemory) memory.clone();

		do {
			AbstractValue guard =  visit(ctx.bexp());

			/**
			 * True
			 */
			if (domain.isTrue(guard)) {
				visit(ctx.block());
				memory = previous.widening(memory);
			} 

			/**
			 * False
			 */
			else if (domain.isFalse(guard)) {
				break;
			} 

			/**
			 * Top
			 */
			else {
				visit(ctx.block());
				memory = previous.widening(previous.leastUpperBound(memory));
			}

			AbstractMemory s =  memory.clone();


			if (previous.equals(s))
				break;
			else
				previous = s.clone();
		} while (true);


		if (printInvariants) {
			KeyAbstractState key = new KeyAbstractState(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
			state.add(key, memory.clone());
		}

		return domain.makeBottom();
	}

	@Override 
	public AbstractValue visitIdAExp(MuJsParser.IdAExpContext ctx) { 
		Variable v = new Variable(ctx.ID().getText());

		if (memory.containsKey(v))
			return memory.get(v);
		else
			return domain.makeBottom();
	}
	
	@Override 
	public AbstractValue visitBlockStmt(MuJsParser.BlockStmtContext ctx) { 
		if (ctx.block() != null)
			visit(ctx.block());

		return domain.makeBottom();
	}
	
	@Override 
	public AbstractValue visitToNum(MuJsParser.ToNumContext ctx) { 
		return visitChildren(ctx); 
	}

	@Override 
	public AbstractValue visitAssignmentStmt(MuJsParser.AssignmentStmtContext ctx) { 
		Variable v = new Variable(ctx.getChild(0).getText());
		memory.put(v, visit(ctx.exp()));

		if (printInvariants) {
			KeyAbstractState key = new KeyAbstractState(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
			state.add(key, memory.clone());
		}
		return domain.makeBottom();
	}

	@Override 
	public AbstractValue visitIdSExp(MuJsParser.IdSExpContext ctx) {
		Variable v = new Variable(ctx.ID().getText());

		if (memory.containsKey(v))
			return memory.get(v);
		else
			return domain.makeBottom();
	}
	
	@Override 
	public AbstractValue visitBExp(MuJsParser.BExpContext ctx) { 
		return visit(ctx.bexp()); 
	}
	
	@Override 
	public AbstractValue visitAExp( MuJsParser.AExpContext ctx) { 
		return visit(ctx.aexp()); 
	}
	
	@Override 
	public AbstractValue visitSExp( MuJsParser.SExpContext ctx) { 
		return visit(ctx.sexp()); 
	}
}
