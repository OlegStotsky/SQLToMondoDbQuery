grammar SQL;

sqlQuery
    : 'SELECT' idList 'FROM' tableName predicates? selectors?
    ;

tableName
    : identifier
    ;

idList
    : '*' | identifier (',' identifier)*
    ;
predicates
    : 'WHERE' predicateExpr
    ;
predicateExpr
    : predicateTerm ('OR' predicateExpr)* | predicateTerm
    ;
predicateTerm
    : predicateAtom ('AND' predicateTerm)* | predicateAtom
    ;
predicateAtom
    : identifier RELATIONAL_OPERATOR number | '(' predicateExpr ')'
    ;

selectors
    : ('SKIP' number)? ('LIMIT' number)?
    ;

identifier
   : LETTER (LETTER | DIGIT)*
   ;

number
    : DIGIT+
    ;

RELATIONAL_OPERATOR
    : '<' | '>' | '<>' | '='
    ;

LETTER
   : 'a' .. 'z'
   | 'A' .. 'Z'
   ;

DIGIT
   : '0' .. '9'
   ;

SELECT : 'SELECT' ;
FROM : 'FROM' ;
STAR : '*' ;
COMMA : ',' ;
WHERE : 'WHERE' ;
OR : 'OR' ;
AND : 'AND' ;
LPAREN : '(' ;
RPAREN : ')' ;
LIMIT : 'LIMIT' ;
SPACE           :   [ \t]+ -> skip;
