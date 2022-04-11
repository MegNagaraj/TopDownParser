package parser_sep;


class Assign {

	Expr expr;

	public Assign()
	{
		if(Lexer.nextToken==Token.ASSIGN_OP)
		{
			Lexer.lex();
			expr = new Expr();
			if(Lexer.nextToken==Token.SEMICOLON){
				Lexer.lex();
			}
			else
			{
				System.out.println("Expected ';' not found");
			}
		}
		else
		{
			System.out.println("Expected Assignment. Not found");
		}
	}
}