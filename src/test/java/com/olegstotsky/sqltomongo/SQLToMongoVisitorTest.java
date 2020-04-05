package com.olegstotsky.sqltomongo;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;

public class SQLToMongoVisitorTest {

    @Test
    public void simpleSQLQueryTest() throws IOException {
        String input = "SELECT * FROM user";
        SQLLexer lexer = new SQLLexer(CharStreams.fromStream(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8))));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        SQLParser parser = new SQLParser(tokenStream);
        SQLToMongoVisitor visitor = new SQLToMongoVisitor();
        assertEquals("db.user.find({})", visitor.visit(parser.sqlQuery()));
    }

    @Test
    public void sqlQueryWithSimpleWhereClauseTest() throws IOException {
        String input = "SELECT * FROM user WHERE age = 5";
        SQLLexer lexer = new SQLLexer(CharStreams.fromStream(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8))));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        SQLParser parser = new SQLParser(tokenStream);
        SQLToMongoVisitor visitor = new SQLToMongoVisitor();
        assertEquals("db.user.find({age : { eq: 5}})", visitor.visit(parser.sqlQuery()));
    }

    @Test
    public void sqlQueryWithSimpleWhereAndClauseTest() throws IOException {
        String input = "SELECT * FROM user WHERE age = 5 AND height = 7";
        SQLLexer lexer = new SQLLexer(CharStreams.fromStream(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8))));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        SQLParser parser = new SQLParser(tokenStream);
        SQLToMongoVisitor visitor = new SQLToMongoVisitor();
        assertEquals("db.user.find({age : { eq: 5}, height : { eq: 7}})", visitor.visit(parser.sqlQuery()));
    }

    @Test
    public void sqlQueryWithNestedWhereAndClauseTest() throws IOException {
        String input = "SELECT * FROM user WHERE age = 5 AND height = 7 AND money = 100";
        SQLLexer lexer = new SQLLexer(CharStreams.fromStream(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8))));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        SQLParser parser = new SQLParser(tokenStream);
        SQLToMongoVisitor visitor = new SQLToMongoVisitor();
        assertEquals("db.user.find({age : { eq: 5}, {height : { eq: 7}, money : { eq: 100}}})", visitor.visit(parser.sqlQuery()));
    }

    @Test
    public void sqlQueryWithSimpleWhereOrClauseTest() throws IOException {
        String input = "SELECT * FROM user WHERE age = 5 OR height = 7";
        SQLLexer lexer = new SQLLexer(CharStreams.fromStream(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8))));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        SQLParser parser = new SQLParser(tokenStream);
        SQLToMongoVisitor visitor = new SQLToMongoVisitor();
        assertEquals("db.user.find({$or: [{age : { eq: 5}}, {height : { eq: 7}}]})", visitor.visit(parser.sqlQuery()));
    }

    @Test
    public void sqlQueryWithTwoNestedAndOrClauseTest() throws IOException {
        String input = "SELECT * FROM user WHERE age = 5 AND height = 6 OR height = 7 AND age=3";
        SQLLexer lexer = new SQLLexer(CharStreams.fromStream(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8))));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        SQLParser parser = new SQLParser(tokenStream);
        SQLToMongoVisitor visitor = new SQLToMongoVisitor();
        assertEquals("db.user.find({$or: [{age : { eq: 5}, height : { eq: 6}}, {height : { eq: 7}, age : { eq: 3}}]})", visitor.visit(parser.sqlQuery()));
    }

    @Test
    public void sqlQueryWithNestedAndOrClauseTestWithOneOnRight() throws IOException {
        String input = "SELECT * FROM user WHERE age = 5 AND height = 6 OR height = 7";
        SQLLexer lexer = new SQLLexer(CharStreams.fromStream(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8))));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        SQLParser parser = new SQLParser(tokenStream);
        SQLToMongoVisitor visitor = new SQLToMongoVisitor();
        assertEquals("db.user.find({$or: [{age : { eq: 5}, height : { eq: 6}}, {height : { eq: 7}}]})", visitor.visit(parser.sqlQuery()));
    }


    @Test
    public void sqlQueryWithNestedAndOrClauseTestWithOneOnLeft() throws IOException {
        String input = "SELECT * FROM user WHERE age = 5 OR height = 7 AND age=3";
        SQLLexer lexer = new SQLLexer(CharStreams.fromStream(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8))));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        SQLParser parser = new SQLParser(tokenStream);
        SQLToMongoVisitor visitor = new SQLToMongoVisitor();
        assertEquals("db.user.find({$or: [{age : { eq: 5}}, {height : { eq: 7}, age : { eq: 3}}]})", visitor.visit(parser.sqlQuery()));
    }

    @Test
    public void sqlQueryWithNestedAndOrClauseTestWithThreeOnRight() throws IOException {
        String input = "SELECT * FROM user WHERE age = 5 OR height = 7 AND age=3 AND age=10";
        SQLLexer lexer = new SQLLexer(CharStreams.fromStream(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8))));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        SQLParser parser = new SQLParser(tokenStream);
        SQLToMongoVisitor visitor = new SQLToMongoVisitor();
        assertEquals("db.user.find({$or: [{age : { eq: 5}}, {height : { eq: 7}, {age : { eq: 3}, age : { eq: 10}}}]})", visitor.visit(parser.sqlQuery()));
    }
}