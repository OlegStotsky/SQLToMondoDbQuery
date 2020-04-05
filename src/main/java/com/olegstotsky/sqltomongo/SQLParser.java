// Generated from /Users/olegstotsky/Desktop/University/sem2/java/DataGripTestTaskFinal/grammar/SQL.g4 by ANTLR 4.8
package com.olegstotsky.sqltomongo;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SQLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, RELATIONAL_OPERATOR=2, LETTER=3, DIGIT=4, SELECT=5, FROM=6, STAR=7, 
		COMMA=8, WHERE=9, OR=10, AND=11, LPAREN=12, RPAREN=13, LIMIT=14, SPACE=15;
	public static final int
		RULE_sqlQuery = 0, RULE_tableName = 1, RULE_idList = 2, RULE_predicates = 3, 
		RULE_predicateExpr = 4, RULE_predicateTerm = 5, RULE_predicateAtom = 6, 
		RULE_selectors = 7, RULE_identifier = 8, RULE_number = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"sqlQuery", "tableName", "idList", "predicates", "predicateExpr", "predicateTerm", 
			"predicateAtom", "selectors", "identifier", "number"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'SKIP'", null, null, null, "'SELECT'", "'FROM'", "'*'", "','", 
			"'WHERE'", "'OR'", "'AND'", "'('", "')'", "'LIMIT'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "RELATIONAL_OPERATOR", "LETTER", "DIGIT", "SELECT", "FROM", 
			"STAR", "COMMA", "WHERE", "OR", "AND", "LPAREN", "RPAREN", "LIMIT", "SPACE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "SQL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SQLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class SqlQueryContext extends ParserRuleContext {
		public TerminalNode SELECT() { return getToken(SQLParser.SELECT, 0); }
		public IdListContext idList() {
			return getRuleContext(IdListContext.class,0);
		}
		public TerminalNode FROM() { return getToken(SQLParser.FROM, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public PredicatesContext predicates() {
			return getRuleContext(PredicatesContext.class,0);
		}
		public SelectorsContext selectors() {
			return getRuleContext(SelectorsContext.class,0);
		}
		public SqlQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sqlQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterSqlQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitSqlQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitSqlQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SqlQueryContext sqlQuery() throws RecognitionException {
		SqlQueryContext _localctx = new SqlQueryContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_sqlQuery);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			match(SELECT);
			setState(21);
			idList();
			setState(22);
			match(FROM);
			setState(23);
			tableName();
			setState(25);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(24);
				predicates();
				}
			}

			setState(28);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(27);
				selectors();
				}
				break;
			}
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

	public static class TableNameContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TableNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterTableName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitTableName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitTableName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableNameContext tableName() throws RecognitionException {
		TableNameContext _localctx = new TableNameContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_tableName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			identifier();
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

	public static class IdListContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(SQLParser.STAR, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public IdListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterIdList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitIdList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitIdList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdListContext idList() throws RecognitionException {
		IdListContext _localctx = new IdListContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_idList);
		int _la;
		try {
			setState(41);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(32);
				match(STAR);
				}
				break;
			case LETTER:
				enterOuterAlt(_localctx, 2);
				{
				setState(33);
				identifier();
				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(34);
					match(COMMA);
					setState(35);
					identifier();
					}
					}
					setState(40);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class PredicatesContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(SQLParser.WHERE, 0); }
		public PredicateExprContext predicateExpr() {
			return getRuleContext(PredicateExprContext.class,0);
		}
		public PredicatesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicates; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterPredicates(this);
		}
		@Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof SQLListener) ((SQLListener) listener).exitPredicates(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof SQLVisitor) return ((SQLVisitor<? extends T>) visitor).visitPredicates(this);
            else return visitor.visitChildren(this);
        }
    }

    public static final String _serializedATN =
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\21]\4\2\t\2\4\3\t" +
                    "\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\3" +
                    "\2\3\2\3\2\3\2\3\2\5\2\34\n\2\3\2\5\2\37\n\2\3\3\3\3\3\4\3\4\3\4\3\4\7" +
                    "\4\'\n\4\f\4\16\4*\13\4\5\4,\n\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\5\6\66" +
                    "\n\6\3\7\3\7\3\7\3\7\3\7\5\7=\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b" +
                    "G\n\b\3\t\3\t\5\tK\n\t\3\t\3\t\5\tO\n\t\3\n\3\n\7\nS\n\n\f\n\16\nV\13" +
                    "\n\3\13\6\13Y\n\13\r\13\16\13Z\3\13\2\2\f\2\4\6\b\n\f\16\20\22\24\2\3" +
                    "\3\2\5\6\2]\2\26\3\2\2\2\4 \3\2\2\2\6+\3\2\2\2\b-\3\2\2\2\n\65\3\2\2\2" +
                    "\f<\3\2\2\2\16F\3\2\2\2\20J\3\2\2\2\22P\3\2\2\2\24X\3\2\2\2\26\27\7\7" +
                    "\2\2\27\30\5\6\4\2\30\31\7\b\2\2\31\33\5\4\3\2\32\34\5\b\5\2\33\32\3\2" +
                    "\2\2\33\34\3\2\2\2\34\36\3\2\2\2\35\37\5\20\t\2\36\35\3\2\2\2\36\37\3" +
                    "\2\2\2\37\3\3\2\2\2 !\5\22\n\2!\5\3\2\2\2\",\7\t\2\2#(\5\22\n\2$%\7\n" +
                    "\2\2%\'\5\22\n\2&$\3\2\2\2\'*\3\2\2\2(&\3\2\2\2()\3\2\2\2),\3\2\2\2*(" +
                    "\3\2\2\2+\"\3\2\2\2+#\3\2\2\2,\7\3\2\2\2-.\7\13\2\2./\5\n\6\2/\t\3\2\2" +
                    "\2\60\61\5\f\7\2\61\62\7\f\2\2\62\63\5\n\6\2\63\66\3\2\2\2\64\66\5\f\7" +
                    "\2\65\60\3\2\2\2\65\64\3\2\2\2\66\13\3\2\2\2\678\5\16\b\289\7\r\2\29:" +
                    "\5\f\7\2:=\3\2\2\2;=\5\16\b\2<\67\3\2\2\2<;\3\2\2\2=\r\3\2\2\2>?\5\22" +
                    "\n\2?@\7\4\2\2@A\5\24\13\2AG\3\2\2\2BC\7\16\2\2CD\5\n\6\2DE\7\17\2\2E" +
                    "G\3\2\2\2F>\3\2\2\2FB\3\2\2\2G\17\3\2\2\2HI\7\3\2\2IK\5\24\13\2JH\3\2" +
                    "\2\2JK\3\2\2\2KN\3\2\2\2LM\7\20\2\2MO\5\24\13\2NL\3\2\2\2NO\3\2\2\2O\21" +
                    "\3\2\2\2PT\7\5\2\2QS\t\2\2\2RQ\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2U" +
                    "\23\3\2\2\2VT\3\2\2\2WY\7\6\2\2XW\3\2\2\2YZ\3\2\2\2ZX\3\2\2\2Z[\3\2\2" +
                    "\2[\25\3\2\2\2\r\33\36(+\65<FJNTZ";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }

    public final PredicatesContext predicates() throws RecognitionException {
        PredicatesContext _localctx = new PredicatesContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_predicates);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(43);
                match(WHERE);
                setState(44);
                predicateExpr();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final PredicateExprContext predicateExpr() throws RecognitionException {
        PredicateExprContext _localctx = new PredicateExprContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_predicateExpr);
        try {
            setState(51);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 4, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(46);
                    predicateTerm();
                    setState(47);
                    match(OR);
                    setState(48);
                    predicateExpr();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(50);
                    predicateTerm();
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

	public final PredicateTermContext predicateTerm() throws RecognitionException {
		PredicateTermContext _localctx = new PredicateTermContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_predicateTerm);
		try {
            setState(58);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 5, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(53);
                    predicateAtom();
                    setState(54);
                    match(AND);
                    setState(55);
                    predicateTerm();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(57);
                    predicateAtom();
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

	public final PredicateAtomContext predicateAtom() throws RecognitionException {
		PredicateAtomContext _localctx = new PredicateAtomContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_predicateAtom);
		try {
            setState(68);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case LETTER:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(60);
                    identifier();
                    setState(61);
                    match(RELATIONAL_OPERATOR);
                    setState(62);
                    number();
                }
                break;
                case LPAREN:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(64);
                    match(LPAREN);
                    setState(65);
                    predicateExpr();
                    setState(66);
                    match(RPAREN);
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

	public final SelectorsContext selectors() throws RecognitionException {
		SelectorsContext _localctx = new SelectorsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_selectors);
		int _la;
		try {
            enterOuterAlt(_localctx, 1);
            {
                setState(72);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T__0) {
                    {
                        setState(70);
                        match(T__0);
                        setState(71);
                        number();
                    }
                }

                setState(76);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == LIMIT) {
                    {
                        setState(74);
                        match(LIMIT);
                        setState(75);
                        number();
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_identifier);
		int _la;
		try {
            enterOuterAlt(_localctx, 1);
            {
                setState(78);
                match(LETTER);
                setState(82);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == LETTER || _la == DIGIT) {
                    {
                        {
                            setState(79);
                            _la = _input.LA(1);
                            if (!(_la == LETTER || _la == DIGIT)) {
                                _errHandler.recoverInline(this);
                            } else {
                                if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                _errHandler.reportMatch(this);
                                consume();
                            }
                        }
                    }
                    setState(84);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_number);
		int _la;
		try {
            enterOuterAlt(_localctx, 1);
            {
                setState(86);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(85);
                            match(DIGIT);
                        }
                    }
                    setState(88);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while (_la == DIGIT);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class PredicateAtomContext extends ParserRuleContext {
        public PredicateAtomContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public IdentifierContext identifier() {
            return getRuleContext(IdentifierContext.class, 0);
        }

        public TerminalNode RELATIONAL_OPERATOR() {
            return getToken(SQLParser.RELATIONAL_OPERATOR, 0);
        }

        public NumberContext number() {
            return getRuleContext(NumberContext.class, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(SQLParser.LPAREN, 0);
        }

        public PredicateExprContext predicateExpr() {
            return getRuleContext(PredicateExprContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(SQLParser.RPAREN, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_predicateAtom;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof SQLListener) ((SQLListener) listener).enterPredicateAtom(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof SQLListener) ((SQLListener) listener).exitPredicateAtom(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof SQLVisitor) return ((SQLVisitor<? extends T>) visitor).visitPredicateAtom(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class SelectorsContext extends ParserRuleContext {
        public SelectorsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<NumberContext> number() {
            return getRuleContexts(NumberContext.class);
        }

        public NumberContext number(int i) {
            return getRuleContext(NumberContext.class, i);
        }

        public TerminalNode LIMIT() {
            return getToken(SQLParser.LIMIT, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_selectors;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof SQLListener) ((SQLListener) listener).enterSelectors(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof SQLListener) ((SQLListener) listener).exitSelectors(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof SQLVisitor) return ((SQLVisitor<? extends T>) visitor).visitSelectors(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class IdentifierContext extends ParserRuleContext {
        public IdentifierContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<TerminalNode> LETTER() {
            return getTokens(SQLParser.LETTER);
        }

        public TerminalNode LETTER(int i) {
            return getToken(SQLParser.LETTER, i);
        }

        public List<TerminalNode> DIGIT() {
            return getTokens(SQLParser.DIGIT);
        }

        public TerminalNode DIGIT(int i) {
            return getToken(SQLParser.DIGIT, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_identifier;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof SQLListener) ((SQLListener) listener).enterIdentifier(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof SQLListener) ((SQLListener) listener).exitIdentifier(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof SQLVisitor) return ((SQLVisitor<? extends T>) visitor).visitIdentifier(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class NumberContext extends ParserRuleContext {
        public NumberContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<TerminalNode> DIGIT() {
            return getTokens(SQLParser.DIGIT);
        }

        public TerminalNode DIGIT(int i) {
            return getToken(SQLParser.DIGIT, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_number;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof SQLListener) ((SQLListener) listener).enterNumber(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof SQLListener) ((SQLListener) listener).exitNumber(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof SQLVisitor) return ((SQLVisitor<? extends T>) visitor).visitNumber(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class PredicateExprContext extends ParserRuleContext {
        public PredicateExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public PredicateTermContext predicateTerm() {
            return getRuleContext(PredicateTermContext.class, 0);
        }

        public TerminalNode OR() {
            return getToken(SQLParser.OR, 0);
        }

        public PredicateExprContext predicateExpr() {
            return getRuleContext(PredicateExprContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_predicateExpr;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof SQLListener) ((SQLListener) listener).enterPredicateExpr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof SQLListener) ((SQLListener) listener).exitPredicateExpr(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof SQLVisitor) return ((SQLVisitor<? extends T>) visitor).visitPredicateExpr(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class PredicateTermContext extends ParserRuleContext {
        public PredicateTermContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public PredicateAtomContext predicateAtom() {
            return getRuleContext(PredicateAtomContext.class, 0);
        }

        public TerminalNode AND() {
            return getToken(SQLParser.AND, 0);
        }

        public PredicateTermContext predicateTerm() {
            return getRuleContext(PredicateTermContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_predicateTerm;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof SQLListener) ((SQLListener) listener).enterPredicateTerm(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof SQLListener) ((SQLListener) listener).exitPredicateTerm(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof SQLVisitor) return ((SQLVisitor<? extends T>) visitor).visitPredicateTerm(this);
            else return visitor.visitChildren(this);
        }
    }
}