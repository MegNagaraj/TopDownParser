# TopDownParser
Parser Program for TinyPL with the below grammar that translates every TinyPL program into a sequence of byte-codes for the Java Virtual Machine.
-------------------------------------------------------------------------------------------------------------------------------------------------

program -> decls stmts end
decls -> int idlist ;
idlist -> id { , id }
stmts -> stmt [ stmts ]
cmpdstmt-> '{' stmts '}'
stmt -> assign | cond | loop
assign -> id = expr ;
cond -> if '(' rexp ')' cmpdstmt [ else cmpdstmt ]
loop -> while '(' rexp ')' cmpdstmt
rexp -> expr (< | > | =) expr
expr -> term [ (+ | -) expr ]
term -> factor [ (* | /) term ]
factor -> int_lit | id | '(' expr ')'
