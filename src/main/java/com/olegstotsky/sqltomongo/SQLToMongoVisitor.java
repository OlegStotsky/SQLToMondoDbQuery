package com.olegstotsky.sqltomongo;

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

public class SQLToMongoVisitor extends AbstractParseTreeVisitor<String> implements SQLVisitor<String> {
    private boolean haveOuterBracetsForExprBeenProduced = false;
    private boolean justOneLevelBelowOR = false;

    @Override
    public String visitSqlQuery(SQLParser.SqlQueryContext ctx) {
        StringBuilder result = new StringBuilder();
        result.append("db.");
        result.append(visitTableName(ctx.tableName()));
        result.append(".");
        result.append("find(");
        result.append(visitPredicates(ctx.predicates()));
        if (ctx.idList().STAR() == null) {
            result.append(", ");
            result.append(visitIdList(ctx.idList()));
        }
        result.append(")");
        result.append(visitSelectors(ctx.selectors()));
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
        for (int i = 0; i < ctx.identifier().size(); ++i) {
            if (i == ctx.identifier().size() - 1) {
                result.append(visitIdentifier(ctx.identifier(i)) + ": 1");
            } else {
                result.append(visitIdentifier(ctx.identifier(i)) + ": 1, ");
            }
        }
        result.append("}");
        return result.toString();
    }

    @Override
    public String visitPredicates(SQLParser.PredicatesContext ctx) {
        if (ctx == null) {
            return "{}";
        }
        StringBuilder builder = new StringBuilder();
        builder.append(visitPredicateExpr(ctx.predicateExpr()));
        return builder.toString();
    }

    @Override
    public String visitPredicateExpr(SQLParser.PredicateExprContext ctx) {
        StringBuilder builder = new StringBuilder();
        if (ctx.predicateExpr() == null) {
            builder.append(visitPredicateTerm(ctx.predicateTerm()));
        } else {
            boolean haveToAppendBracketToEnd = false;
            if (!haveOuterBracetsForExprBeenProduced) {
                builder.append("{");
                haveToAppendBracketToEnd = true;
                haveOuterBracetsForExprBeenProduced = true;
            }
            builder.append("$or: ");
            builder.append("[");
            justOneLevelBelowOR = true;
            builder.append(visitPredicateTerm(ctx.predicateTerm()));
            justOneLevelBelowOR = true;
            builder.append(", ");
            builder.append(visitPredicateExpr(ctx.predicateExpr()));
            builder.append("]");
            if (haveToAppendBracketToEnd) {
                builder.append("}");
            }
        }
        return builder.toString();
    }

    @Override
    public String visitPredicateTerm(SQLParser.PredicateTermContext ctx) {
        StringBuilder builder = new StringBuilder();
        if (ctx.predicateTerm() == null) {
            boolean haveToAppendBracket = false;
            if (justOneLevelBelowOR) {
                builder.append("{");
                haveToAppendBracket = true;
                justOneLevelBelowOR = false;
            }
            builder.append(visitPredicateAtom(ctx.predicateAtom()));
            if (haveToAppendBracket) {
                builder.append("}");
            }
        } else {
            haveOuterBracetsForExprBeenProduced = true;
            justOneLevelBelowOR = false;
            builder.append("{");
            builder.append(visitPredicateAtom(ctx.predicateAtom()));
            builder.append(", ");
            builder.append(visitPredicateTerm(ctx.predicateTerm()));
            builder.append("}");
        }
        return builder.toString();
    }

    @Override
    public String visitPredicateAtom(SQLParser.PredicateAtomContext ctx) {
        StringBuilder builder = new StringBuilder();
        if (ctx.predicateExpr() == null) {
            if (!haveOuterBracetsForExprBeenProduced) {
                builder.append("{");
            }
            builder.append(visitIdentifier(ctx.identifier()));
            builder.append(" : ");
            builder.append(generateCodeForCondition(ctx.RELATIONAL_OPERATOR().getText(), ctx.number().getText()));
            if (!haveOuterBracetsForExprBeenProduced) {
                builder.append("}");
                haveOuterBracetsForExprBeenProduced = true;
            }
        } else {
            builder.append(visitPredicateExpr(ctx.predicateExpr()));
        }
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
        StringBuilder builder = new StringBuilder();
        if (ctx.skipSelector() != null) {
            builder.append(visitSkipSelector(ctx.skipSelector()));
        }
        if (ctx.limitSelector() != null) {
            builder.append(visitLimitSelector(ctx.limitSelector()));
        }
        return builder.toString();
    }

    @Override
    public String visitLimitSelector(SQLParser.LimitSelectorContext ctx) {
        return String.format(".limit(%d)", Integer.parseInt(visitNumber(ctx.number())));
    }

    @Override
    public String visitSkipSelector(SQLParser.SkipSelectorContext ctx) {
        return String.format(".skip(%d)", Integer.parseInt(visitNumber(ctx.number())));
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
