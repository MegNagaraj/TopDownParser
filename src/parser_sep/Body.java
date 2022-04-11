package parser_sep;

class Body
{
	public Body()
	{
		new Decls();
		new Stmts();
		if(Lexer.nextToken==Token.KEY_END)
		{
			System.out.println("*** Byte Code for TinyPL *** \n");
			return;
		}
		else
		{
			System.out.println("Expected End; not found" );
		}
	}
}