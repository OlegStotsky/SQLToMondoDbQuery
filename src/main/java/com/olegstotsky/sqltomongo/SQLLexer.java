// Generated from /Users/olegstotsky/Desktop/University/sem2/java/DataGripTestTaskFinal/grammar/SQL.g4 by ANTLR 4.8
package com.olegstotsky.sqltomongo;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SQLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, RELATIONAL_OPERATOR=2, LETTER=3, DIGIT=4, SELECT=5, FROM=6, STAR=7, 
		COMMA=8, WHERE=9, OR=10, AND=11, LPAREN=12, RPAREN=13, LIMIT=14, SPACE=15;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
    };

    private static String[] makeRuleNames() {
        return new String[]{
                "T__0", "RELATIONAL_OPERATOR", "LETTER", "DIGIT", "SELECT", "FROM", "STAR",
                "COMMA", "WHERE", "OR", "AND", "LPAREN", "RPAREN", "LIMIT", "SPACE"
        };
    }

    public static final String[] ruleNames = makeRuleNames();

    public static final String _serializedATN =
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\21`\b\1\4\2\t\2\4" +
                    "\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t" +
                    "\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\2\3\2" +
                    "\3\2\3\2\3\3\3\3\3\3\3\3\5\3-\n\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6" +
                    "\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3" +
                    "\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3" +
                    "\17\3\17\3\20\6\20[\n\20\r\20\16\20\\\3\20\3\20\2\2\21\3\3\5\4\7\5\t\6" +
                    "\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21\3\2\5\4\2" +
                    ">>@@\4\2C\\c|\4\2\13\13\"\"\2b\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t" +
                    "\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2" +
                    "\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2" +
                    "\37\3\2\2\2\3!\3\2\2\2\5,\3\2\2\2\7.\3\2\2\2\t\60\3\2\2\2\13\62\3\2\2" +
                    "\2\r9\3\2\2\2\17>\3\2\2\2\21@\3\2\2\2\23B\3\2\2\2\25H\3\2\2\2\27K\3\2" +
                    "\2\2\31O\3\2\2\2\33Q\3\2\2\2\35S\3\2\2\2\37Z\3\2\2\2!\"\7Q\2\2\"#\7H\2" +
                    "\2#$\7H\2\2$%\7U\2\2%&\7G\2\2&\'\7V\2\2\'\4\3\2\2\2(-\t\2\2\2)*\7>\2\2" +
                    "*-\7@\2\2+-\7?\2\2,(\3\2\2\2,)\3\2\2\2,+\3\2\2\2-\6\3\2\2\2./\t\3\2\2" +
                    "/\b\3\2\2\2\60\61\4\62;\2\61\n\3\2\2\2\62\63\7U\2\2\63\64\7G\2\2\64\65" +
                    "\7N\2\2\65\66\7G\2\2\66\67\7E\2\2\678\7V\2\28\f\3\2\2\29:\7H\2\2:;\7T" +
                    "\2\2;<\7Q\2\2<=\7O\2\2=\16\3\2\2\2>?\7,\2\2?\20\3\2\2\2@A\7.\2\2A\22\3" +
                    "\2\2\2BC\7Y\2\2CD\7J\2\2DE\7G\2\2EF\7T\2\2FG\7G\2\2G\24\3\2\2\2HI\7Q\2" +
                    "\2IJ\7T\2\2J\26\3\2\2\2KL\7C\2\2LM\7P\2\2MN\7F\2\2N\30\3\2\2\2OP\7*\2" +
                    "\2P\32\3\2\2\2QR\7+\2\2R\34\3\2\2\2ST\7N\2\2TU\7K\2\2UV\7O\2\2VW\7K\2" +
                    "\2WX\7V\2\2X\36\3\2\2\2Y[\t\4\2\2ZY\3\2\2\2[\\\3\2\2\2\\Z\3\2\2\2\\]\3" +
                    "\2\2\2]^\3\2\2\2^_\b\20\2\2_ \3\2\2\2\5\2,\\\3\b\2\2";
    private static final String[] _LITERAL_NAMES = makeLiteralNames();

    private static String[] makeSymbolicNames() {
        return new String[]{
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


	public SQLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SQL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

    @Override
    public String[] getChannelNames() {
        return channelNames;
    }

    @Override
    public String[] getModeNames() {
        return modeNames;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    private static String[] makeLiteralNames() {
        return new String[]{
                null, "'OFFSET'", null, null, null, "'SELECT'", "'FROM'", "'*'", "','",
                "'WHERE'", "'OR'", "'AND'", "'('", "')'", "'LIMIT'"
        };
    }

    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}