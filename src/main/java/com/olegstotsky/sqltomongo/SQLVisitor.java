// Generated from /Users/olegstotsky/Desktop/University/sem2/java/DataGripTestTaskFinal/grammar/SQL.g4 by ANTLR 4.8
package com.olegstotsky.sqltomongo;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SQLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SQLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SQLParser#sqlQuery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSqlQuery(SQLParser.SqlQueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#tableName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableName(SQLParser.TableNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#idList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdList(SQLParser.IdListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#predicates}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicates(SQLParser.PredicatesContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#predicateExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicateExpr(SQLParser.PredicateExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#predicateTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicateTerm(SQLParser.PredicateTermContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#predicateAtom}.
	 * @param ctx the parse tree
     * @return the visitor result
     */
    T visitPredicateAtom(SQLParser.PredicateAtomContext ctx);

    /**
     * Visit a parse tree produced by {@link SQLParser#selectors}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSelectors(SQLParser.SelectorsContext ctx);

    /**
     * Visit a parse tree produced by {@link SQLParser#limitSelector}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitLimitSelector(SQLParser.LimitSelectorContext ctx);

    /**
     * Visit a parse tree produced by {@link SQLParser#skipSelector}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSkipSelector(SQLParser.SkipSelectorContext ctx);

    /**
     * Visit a parse tree produced by {@link SQLParser#identifier}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIdentifier(SQLParser.IdentifierContext ctx);

    /**
     * Visit a parse tree produced by {@link SQLParser#number}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
	T visitNumber(SQLParser.NumberContext ctx);
}