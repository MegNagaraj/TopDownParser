package parser_sep;

class Stmts 
{
	public Stmts()
	{
		new Stmt();
		if ((Lexer.nextToken != Token.KEY_END) && (Lexer.nextToken != Token.RIGHT_BRACE))
		{
			new Stmts();
		}
	}
}