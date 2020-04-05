// Generated from /Users/olegstotsky/Desktop/University/sem2/java/DataGripTestTaskFinal/grammar/SQL.g4 by ANTLR 4.8
package com.olegstotsky.sqltomongo;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SQLParser}.
 */
public interface SQLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SQLParser#sqlQuery}.
	 * @param ctx the parse tree
	 */
	void enterSqlQuery(SQLParser.SqlQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#sqlQuery}.
	 * @param ctx the parse tree
	 */
	void exitSqlQuery(SQLParser.SqlQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#tableName}.
	 * @param ctx the parse tree
	 */
	void enterTableName(SQLParser.TableNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#tableName}.
	 * @param ctx the parse tree
	 */
	void exitTableName(SQLParser.TableNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#idList}.
	 * @param ctx the parse tree
	 */
	void enterIdList(SQLParser.IdListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#idList}.
	 * @param ctx the parse tree
	 */
	void exitIdList(SQLParser.IdListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#predicates}.
	 * @param ctx the parse tree
	 */
	void enterPredicates(SQLParser.PredicatesContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#predicates}.
	 * @param ctx the parse tree
	 */
	void exitPredicates(SQLParser.PredicatesContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#predicateExpr}.
	 * @param ctx the parse tree
	 */
	void enterPredicateExpr(SQLParser.PredicateExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#predicateExpr}.
	 * @param ctx the parse tree
	 */
	void exitPredicateExpr(SQLParser.PredicateExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#predicateTerm}.
	 * @param ctx the parse tree
	 */
	void enterPredicateTerm(SQLParser.PredicateTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#predicateTerm}.
	 * @param ctx the parse tree
	 */
	void exitPredicateTerm(SQLParser.PredicateTermContext ctx);
	/**
     * Enter a parse tree produced by {@link SQLParser#predicateAtom}.
     * @param ctx the parse tree
     */
    void enterPredicateAtom(SQLParser.PredicateAtomContext ctx);

    /**
     * Exit a parse tree produced by {@link SQLParser#predicateAtom}.
     *
     * @param ctx the parse tree
     */
    void exitPredicateAtom(SQLParser.PredicateAtomContext ctx);

    /**
     * Enter a parse tree produced by {@link SQLParser#selectors}.
     *
     * @param ctx the parse tree
     */
    void enterSelectors(SQLParser.SelectorsContext ctx);

    /**
     * Exit a parse tree produced by {@link SQLParser#selectors}.
     *
     * @param ctx the parse tree
     */
    void exitSelectors(SQLParser.SelectorsContext ctx);

    /**
     * Enter a parse tree produced by {@link SQLParser#limitSelector}.
     *
     * @param ctx the parse tree
     */
    void enterLimitSelector(SQLParser.LimitSelectorContext ctx);

    /**
     * Exit a parse tree produced by {@link SQLParser#limitSelector}.
     *
     * @param ctx the parse tree
     */
    void exitLimitSelector(SQLParser.LimitSelectorContext ctx);

    /**
     * Enter a parse tree produced by {@link SQLParser#skipSelector}.
     *
     * @param ctx the parse tree
     */
    void enterSkipSelector(SQLParser.SkipSelectorContext ctx);

    /**
     * Exit a parse tree produced by {@link SQLParser#skipSelector}.
     *
     * @param ctx the parse tree
     */
    void exitSkipSelector(SQLParser.SkipSelectorContext ctx);

    /**
     * Enter a parse tree produced by {@link SQLParser#identifier}.
     *
     * @param ctx the parse tree
     */
    void enterIdentifier(SQLParser.IdentifierContext ctx);

    /**
     * Exit a parse tree produced by {@link SQLParser#identifier}.
     *
     * @param ctx the parse tree
     */
    void exitIdentifier(SQLParser.IdentifierContext ctx);

    /**
     * Enter a parse tree produced by {@link SQLParser#number}.
     *
     * @param ctx the parse tree
     */
    void enterNumber(SQLParser.NumberContext ctx);

    /**
     * Exit a parse tree produced by {@link SQLParser#number}.
     *
     * @param ctx the parse tree
     */
    void exitNumber(SQLParser.NumberContext ctx);
}