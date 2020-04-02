package com.olegstotsky.sqltomongo;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.*;

public class SQLToMongoVisitorTest {

    @Test
    public void visitSQLQuery() throws IOException {
        String input = "SELECT age FROM USER WHERE age = 5";
        SQLLexer lexer = new SQLLexer(CharStreams.fromStream(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8))));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        SQLParser parser = new SQLParser(tokenStream);
        SQLToMongoVisitor visitor = new SQLToMongoVisitor();
        System.out.println(visitor.visit(parser.sqlQuery()));
    }
}