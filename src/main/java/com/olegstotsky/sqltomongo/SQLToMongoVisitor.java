package com.olegstotsky.sqltomongo;

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

public class SQLToMongoVisitor extends AbstractParseTreeVisitor<String> implements SQLVisitor<String>   {
    @Override
    public String visitSqlQuery(SQLParser.SqlQueryContext ctx) {
        StringBuilder result = new StringBuilder();
        result.append("db.");
        result.append(visitTableName(ctx.tableName()));
        result.append(".");
        result.append("find(");
        result.append(visitPredicates(ctx.predicates()));
        result.append(", ");
        result.append(visitIdList(ctx.idList()));
        result.append(")");
        return result.toString();
    }

    @Override
    public String visitTableName(SQLParser.TableNameContext ctx) {
        return ctx.identifier().getText();
    }

    @Override
    public String visitIdList(SQLParser.IdListContext ctx) {
        StringBuilder result = new StringBuilder();
        result.append("{");
        ctx.identifier().forEach(id -> {
            result.append(visitIdentifier(id) + ": 1, ");
        });
        result.append("}");
        return result.toString();
    }

    @Override
    public String visitPredicates(SQLParser.PredicatesContext ctx) {
        return visitPredicateExpr(ctx.predicateExpr());
    }

    @Override
    public String visitPredicateExpr(SQLParser.PredicateExprContext ctx) {
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        if (ctx.predicateExpr().size() == 0) {
            builder.append(visitPredicateTerm(ctx.predicateTerm()));
        } else {
            builder.append("$or: ");
            builder.append("[");
            builder.append(visitPredicateTerm(ctx.predicateTerm()));
            builder.append(", ");
            ctx.predicateExpr().forEach(expr -> {

            });
        }
        builder.append("}");
        return builder.toString();
    }

    @Override
    public String visitPredicateTerm(SQLParser.PredicateTermContext ctx) {
        StringBuilder builder = new StringBuilder();
        if (ctx.predicateTerm().size() == 0) {
            builder.append(visitPredicateAtom(ctx.predicateAtom()));
        }
        return builder.toString();
    }

    @Override
    public String visitPredicateAtom(SQLParser.PredicateAtomContext ctx) {
        StringBuilder builder = new StringBuilder();
        if (ctx.predicateExpr() == null) {
            builder.append(visitIdentifier(ctx.identifier()));
            builder.append(" : ");
            builder.append(generateCodeForCondition(ctx.RELATIONAL_OPERATOR().getText(), ctx.number().getText()));
        } else {}
        return builder.toString();
    }

    private String generateCodeForCondition(String operator, String arg) {
        if (operator.equals(">")) {
            return "{ " + "gt: " + arg + "}";
        }
        if (operator.equals("<")) {
            return "{ " + "lt: " + arg + "}";
        }
        if (operator.equals("<>")) {
            return "{ " + "ne: " + arg + "}";
        }
        if (operator.equals("=")) {
            return "{ " + "eq: " + arg + "}";
        }
        return "";
    }

    @Override
    public String visitSelectors(SQLParser.SelectorsContext ctx) {
        return null;
    }

    @Override
    public String visitIdentifier(SQLParser.IdentifierContext ctx) {
        return ctx.getText();
    }

    @Override
    public String visitNumber(SQLParser.NumberContext ctx) {
        return ctx.getText();
    }
}
