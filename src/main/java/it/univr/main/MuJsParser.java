// Generated from MuJs.g4 by ANTLR 4.7

    package it.univr.main;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MuJsParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, ASG=19, NAN=20, BOOL=21, SEMICOLON=22, ID=23, SIGN=24, INT=25, 
		STRING=26, LESS=27, WS=28;
	public static final int
		RULE_program = 0, RULE_aexp = 1, RULE_bexp = 2, RULE_sexp = 3, RULE_exp = 4, 
		RULE_stmt = 5, RULE_block = 6;
	public static final String[] ruleNames = {
		"program", "aexp", "bexp", "sexp", "exp", "stmt", "block"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'+'", "'-'", "'*'", "'/'", "'toNum'", "'('", "')'", "'=='", "'&&'", 
		"'||'", "'!'", "'concat('", "','", "'if'", "'else'", "'while'", "'{'", 
		"'}'", "'='", "'NaN'", null, "';'", null, null, null, null, "'<'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, "ASG", "NAN", "BOOL", "SEMICOLON", 
		"ID", "SIGN", "INT", "STRING", "LESS", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "MuJs.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MuJsParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	 
		public ProgramContext() { }
		public void copyFrom(ProgramContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ProgramExecutionContext extends ProgramContext {
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public TerminalNode EOF() { return getToken(MuJsParser.EOF, 0); }
		public ProgramExecutionContext(ProgramContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterProgramExecution(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitProgramExecution(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitProgramExecution(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			_localctx = new ProgramExecutionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			stmt(0);
			setState(15);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AexpContext extends ParserRuleContext {
		public AexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aexp; }
	 
		public AexpContext() { }
		public void copyFrom(AexpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DivContext extends AexpContext {
		public List<AexpContext> aexp() {
			return getRuleContexts(AexpContext.class);
		}
		public AexpContext aexp(int i) {
			return getRuleContext(AexpContext.class,i);
		}
		public DivContext(AexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitDiv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DiffContext extends AexpContext {
		public List<AexpContext> aexp() {
			return getRuleContexts(AexpContext.class);
		}
		public AexpContext aexp(int i) {
			return getRuleContext(AexpContext.class,i);
		}
		public DiffContext(AexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterDiff(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitDiff(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitDiff(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MulContext extends AexpContext {
		public List<AexpContext> aexp() {
			return getRuleContexts(AexpContext.class);
		}
		public AexpContext aexp(int i) {
			return getRuleContext(AexpContext.class,i);
		}
		public MulContext(AexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterMul(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitMul(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitMul(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdAExpContext extends AexpContext {
		public TerminalNode ID() { return getToken(MuJsParser.ID, 0); }
		public IdAExpContext(AexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterIdAExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitIdAExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitIdAExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AExpParContext extends AexpContext {
		public AexpContext aexp() {
			return getRuleContext(AexpContext.class,0);
		}
		public AExpParContext(AexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterAExpPar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitAExpPar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitAExpPar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ToNumContext extends AexpContext {
		public SexpContext sexp() {
			return getRuleContext(SexpContext.class,0);
		}
		public ToNumContext(AexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterToNum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitToNum(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitToNum(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SumContext extends AexpContext {
		public List<AexpContext> aexp() {
			return getRuleContexts(AexpContext.class);
		}
		public AexpContext aexp(int i) {
			return getRuleContext(AexpContext.class,i);
		}
		public SumContext(AexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterSum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitSum(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitSum(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntContext extends AexpContext {
		public TerminalNode INT() { return getToken(MuJsParser.INT, 0); }
		public IntContext(AexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitInt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AexpContext aexp() throws RecognitionException {
		return aexp(0);
	}

	private AexpContext aexp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AexpContext _localctx = new AexpContext(_ctx, _parentState);
		AexpContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_aexp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(18);
				match(INT);
				}
				break;
			case ID:
				{
				_localctx = new IdAExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(19);
				match(ID);
				}
				break;
			case T__4:
				{
				_localctx = new ToNumContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(20);
				match(T__4);
				setState(21);
				match(T__5);
				setState(22);
				sexp();
				setState(23);
				match(T__6);
				}
				break;
			case T__5:
				{
				_localctx = new AExpParContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(25);
				match(T__5);
				setState(26);
				aexp(0);
				setState(27);
				match(T__6);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(45);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(43);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new SumContext(new AexpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_aexp);
						setState(31);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(32);
						match(T__0);
						setState(33);
						aexp(7);
						}
						break;
					case 2:
						{
						_localctx = new DiffContext(new AexpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_aexp);
						setState(34);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(35);
						match(T__1);
						setState(36);
						aexp(6);
						}
						break;
					case 3:
						{
						_localctx = new MulContext(new AexpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_aexp);
						setState(37);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(38);
						match(T__2);
						setState(39);
						aexp(5);
						}
						break;
					case 4:
						{
						_localctx = new DivContext(new AexpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_aexp);
						setState(40);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(41);
						match(T__3);
						setState(42);
						aexp(4);
						}
						break;
					}
					} 
				}
				setState(47);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class BexpContext extends ParserRuleContext {
		public BexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bexp; }
	 
		public BexpContext() { }
		public void copyFrom(BexpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EqualsContext extends BexpContext {
		public List<AexpContext> aexp() {
			return getRuleContexts(AexpContext.class);
		}
		public AexpContext aexp(int i) {
			return getRuleContext(AexpContext.class,i);
		}
		public EqualsContext(BexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterEquals(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitEquals(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitEquals(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotContext extends BexpContext {
		public BexpContext bexp() {
			return getRuleContext(BexpContext.class,0);
		}
		public NotContext(BexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrContext extends BexpContext {
		public List<BexpContext> bexp() {
			return getRuleContexts(BexpContext.class);
		}
		public BexpContext bexp(int i) {
			return getRuleContext(BexpContext.class,i);
		}
		public OrContext(BexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdBExpContext extends BexpContext {
		public TerminalNode ID() { return getToken(MuJsParser.ID, 0); }
		public IdBExpContext(BexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterIdBExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitIdBExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitIdBExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolContext extends BexpContext {
		public TerminalNode BOOL() { return getToken(MuJsParser.BOOL, 0); }
		public BoolContext(BexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndContext extends BexpContext {
		public List<BexpContext> bexp() {
			return getRuleContexts(BexpContext.class);
		}
		public BexpContext bexp(int i) {
			return getRuleContext(BexpContext.class,i);
		}
		public AndContext(BexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LessContext extends BexpContext {
		public List<AexpContext> aexp() {
			return getRuleContexts(AexpContext.class);
		}
		public AexpContext aexp(int i) {
			return getRuleContext(AexpContext.class,i);
		}
		public LessContext(BexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterLess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitLess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitLess(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BExpParContext extends BexpContext {
		public BexpContext bexp() {
			return getRuleContext(BexpContext.class,0);
		}
		public BExpParContext(BexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterBExpPar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitBExpPar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitBExpPar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BexpContext bexp() throws RecognitionException {
		return bexp(0);
	}

	private BexpContext bexp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BexpContext _localctx = new BexpContext(_ctx, _parentState);
		BexpContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_bexp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				_localctx = new BoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(49);
				match(BOOL);
				}
				break;
			case 2:
				{
				_localctx = new IdBExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(50);
				match(ID);
				}
				break;
			case 3:
				{
				_localctx = new LessContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(51);
				aexp(0);
				setState(52);
				match(LESS);
				setState(53);
				aexp(0);
				}
				break;
			case 4:
				{
				_localctx = new EqualsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(55);
				aexp(0);
				setState(56);
				match(T__7);
				setState(57);
				aexp(0);
				}
				break;
			case 5:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(59);
				match(T__10);
				setState(60);
				bexp(2);
				}
				break;
			case 6:
				{
				_localctx = new BExpParContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(61);
				match(T__5);
				setState(62);
				bexp(0);
				setState(63);
				match(T__6);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(75);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(73);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new AndContext(new BexpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_bexp);
						setState(67);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(68);
						match(T__8);
						setState(69);
						bexp(5);
						}
						break;
					case 2:
						{
						_localctx = new OrContext(new BexpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_bexp);
						setState(70);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(71);
						match(T__9);
						setState(72);
						bexp(4);
						}
						break;
					}
					} 
				}
				setState(77);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class SexpContext extends ParserRuleContext {
		public SexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sexp; }
	 
		public SexpContext() { }
		public void copyFrom(SexpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StrContext extends SexpContext {
		public TerminalNode STRING() { return getToken(MuJsParser.STRING, 0); }
		public StrContext(SexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterStr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitStr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitStr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConcatContext extends SexpContext {
		public List<SexpContext> sexp() {
			return getRuleContexts(SexpContext.class);
		}
		public SexpContext sexp(int i) {
			return getRuleContext(SexpContext.class,i);
		}
		public ConcatContext(SexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterConcat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitConcat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitConcat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SExpParContext extends SexpContext {
		public SexpContext sexp() {
			return getRuleContext(SexpContext.class,0);
		}
		public SExpParContext(SexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterSExpPar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitSExpPar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitSExpPar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdSExpContext extends SexpContext {
		public TerminalNode ID() { return getToken(MuJsParser.ID, 0); }
		public IdSExpContext(SexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterIdSExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitIdSExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitIdSExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SexpContext sexp() throws RecognitionException {
		SexpContext _localctx = new SexpContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_sexp);
		try {
			setState(90);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				_localctx = new StrContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				match(STRING);
				}
				break;
			case ID:
				_localctx = new IdSExpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(79);
				match(ID);
				}
				break;
			case T__11:
				_localctx = new ConcatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(80);
				match(T__11);
				setState(81);
				sexp();
				setState(82);
				match(T__12);
				setState(83);
				sexp();
				setState(84);
				match(T__6);
				}
				break;
			case T__5:
				_localctx = new SExpParContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(86);
				match(T__5);
				setState(87);
				sexp();
				setState(88);
				match(T__6);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpContext extends ParserRuleContext {
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	 
		public ExpContext() { }
		public void copyFrom(ExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AeExpContext extends ExpContext {
		public AexpContext aexp() {
			return getRuleContext(AexpContext.class,0);
		}
		public AeExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterAeExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitAeExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitAeExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SeExpContext extends ExpContext {
		public SexpContext sexp() {
			return getRuleContext(SexpContext.class,0);
		}
		public SeExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterSeExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitSeExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitSeExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BeExpContext extends ExpContext {
		public BexpContext bexp() {
			return getRuleContext(BexpContext.class,0);
		}
		public BeExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterBeExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitBeExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitBeExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_exp);
		try {
			setState(95);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new AeExpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(92);
				aexp(0);
				}
				break;
			case 2:
				_localctx = new SeExpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(93);
				sexp();
				}
				break;
			case 3:
				_localctx = new BeExpContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(94);
				bexp(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
	 
		public StmtContext() { }
		public void copyFrom(StmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CompositionContext extends StmtContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public CompositionContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterComposition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitComposition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitComposition(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfStmtContext extends StmtContext {
		public BexpContext bexp() {
			return getRuleContext(BexpContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public IfStmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitIfStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileStmtContext extends StmtContext {
		public BexpContext bexp() {
			return getRuleContext(BexpContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhileStmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterWhileStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitWhileStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitWhileStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockStmtContext extends StmtContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public BlockStmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterBlockStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitBlockStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitBlockStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignmentStmtContext extends StmtContext {
		public TerminalNode ID() { return getToken(MuJsParser.ID, 0); }
		public TerminalNode ASG() { return getToken(MuJsParser.ASG, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(MuJsParser.SEMICOLON, 0); }
		public AssignmentStmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterAssignmentStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitAssignmentStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitAssignmentStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		return stmt(0);
	}

	private StmtContext stmt(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StmtContext _localctx = new StmtContext(_ctx, _parentState);
		StmtContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_stmt, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				_localctx = new AssignmentStmtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(98);
				match(ID);
				setState(99);
				match(ASG);
				setState(100);
				exp();
				setState(101);
				match(SEMICOLON);
				}
				break;
			case T__13:
				{
				_localctx = new IfStmtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(103);
				match(T__13);
				setState(104);
				match(T__5);
				setState(105);
				bexp(0);
				setState(106);
				match(T__6);
				setState(107);
				block();
				setState(108);
				match(T__14);
				setState(109);
				block();
				}
				break;
			case T__15:
				{
				_localctx = new WhileStmtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(111);
				match(T__15);
				setState(112);
				match(T__5);
				setState(113);
				bexp(0);
				setState(114);
				match(T__6);
				setState(115);
				block();
				}
				break;
			case T__16:
				{
				_localctx = new BlockStmtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(117);
				block();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(124);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new CompositionContext(new StmtContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_stmt);
					setState(120);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(121);
					stmt(2);
					}
					} 
				}
				setState(126);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_block);
		try {
			setState(133);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(127);
				match(T__16);
				setState(128);
				match(T__17);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(129);
				match(T__16);
				setState(130);
				stmt(0);
				setState(131);
				match(T__17);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return aexp_sempred((AexpContext)_localctx, predIndex);
		case 2:
			return bexp_sempred((BexpContext)_localctx, predIndex);
		case 5:
			return stmt_sempred((StmtContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean aexp_sempred(AexpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		case 3:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean bexp_sempred(BexpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 4);
		case 5:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean stmt_sempred(StmtContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\36\u008a\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3 \n\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3.\n\3\f\3\16\3\61\13\3\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4D\n\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\7\4L\n\4\f\4\16\4O\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\5\5]\n\5\3\6\3\6\3\6\5\6b\n\6\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7y\n\7"+
		"\3\7\3\7\7\7}\n\7\f\7\16\7\u0080\13\7\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0088"+
		"\n\b\3\b\2\5\4\6\f\t\2\4\6\b\n\f\16\2\2\2\u009a\2\20\3\2\2\2\4\37\3\2"+
		"\2\2\6C\3\2\2\2\b\\\3\2\2\2\na\3\2\2\2\fx\3\2\2\2\16\u0087\3\2\2\2\20"+
		"\21\5\f\7\2\21\22\7\2\2\3\22\3\3\2\2\2\23\24\b\3\1\2\24 \7\33\2\2\25 "+
		"\7\31\2\2\26\27\7\7\2\2\27\30\7\b\2\2\30\31\5\b\5\2\31\32\7\t\2\2\32 "+
		"\3\2\2\2\33\34\7\b\2\2\34\35\5\4\3\2\35\36\7\t\2\2\36 \3\2\2\2\37\23\3"+
		"\2\2\2\37\25\3\2\2\2\37\26\3\2\2\2\37\33\3\2\2\2 /\3\2\2\2!\"\f\b\2\2"+
		"\"#\7\3\2\2#.\5\4\3\t$%\f\7\2\2%&\7\4\2\2&.\5\4\3\b\'(\f\6\2\2()\7\5\2"+
		"\2).\5\4\3\7*+\f\5\2\2+,\7\6\2\2,.\5\4\3\6-!\3\2\2\2-$\3\2\2\2-\'\3\2"+
		"\2\2-*\3\2\2\2.\61\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\5\3\2\2\2\61/\3\2"+
		"\2\2\62\63\b\4\1\2\63D\7\27\2\2\64D\7\31\2\2\65\66\5\4\3\2\66\67\7\35"+
		"\2\2\678\5\4\3\28D\3\2\2\29:\5\4\3\2:;\7\n\2\2;<\5\4\3\2<D\3\2\2\2=>\7"+
		"\r\2\2>D\5\6\4\4?@\7\b\2\2@A\5\6\4\2AB\7\t\2\2BD\3\2\2\2C\62\3\2\2\2C"+
		"\64\3\2\2\2C\65\3\2\2\2C9\3\2\2\2C=\3\2\2\2C?\3\2\2\2DM\3\2\2\2EF\f\6"+
		"\2\2FG\7\13\2\2GL\5\6\4\7HI\f\5\2\2IJ\7\f\2\2JL\5\6\4\6KE\3\2\2\2KH\3"+
		"\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2\2\2N\7\3\2\2\2OM\3\2\2\2P]\7\34\2\2Q"+
		"]\7\31\2\2RS\7\16\2\2ST\5\b\5\2TU\7\17\2\2UV\5\b\5\2VW\7\t\2\2W]\3\2\2"+
		"\2XY\7\b\2\2YZ\5\b\5\2Z[\7\t\2\2[]\3\2\2\2\\P\3\2\2\2\\Q\3\2\2\2\\R\3"+
		"\2\2\2\\X\3\2\2\2]\t\3\2\2\2^b\5\4\3\2_b\5\b\5\2`b\5\6\4\2a^\3\2\2\2a"+
		"_\3\2\2\2a`\3\2\2\2b\13\3\2\2\2cd\b\7\1\2de\7\31\2\2ef\7\25\2\2fg\5\n"+
		"\6\2gh\7\30\2\2hy\3\2\2\2ij\7\20\2\2jk\7\b\2\2kl\5\6\4\2lm\7\t\2\2mn\5"+
		"\16\b\2no\7\21\2\2op\5\16\b\2py\3\2\2\2qr\7\22\2\2rs\7\b\2\2st\5\6\4\2"+
		"tu\7\t\2\2uv\5\16\b\2vy\3\2\2\2wy\5\16\b\2xc\3\2\2\2xi\3\2\2\2xq\3\2\2"+
		"\2xw\3\2\2\2y~\3\2\2\2z{\f\3\2\2{}\5\f\7\4|z\3\2\2\2}\u0080\3\2\2\2~|"+
		"\3\2\2\2~\177\3\2\2\2\177\r\3\2\2\2\u0080~\3\2\2\2\u0081\u0082\7\23\2"+
		"\2\u0082\u0088\7\24\2\2\u0083\u0084\7\23\2\2\u0084\u0085\5\f\7\2\u0085"+
		"\u0086\7\24\2\2\u0086\u0088\3\2\2\2\u0087\u0081\3\2\2\2\u0087\u0083\3"+
		"\2\2\2\u0088\17\3\2\2\2\r\37-/CKM\\ax~\u0087";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}