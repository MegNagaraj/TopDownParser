package parser_sep;

class Cmpdstmt {
	Stmts stmts;
	public Cmpdstmt(){
		if(Lexer.nextToken == Token.LEFT_BRACE)
		{
			Lexer.lex();
			stmts = new Stmts();                           
			if(Lexer.nextToken == Token.RIGHT_BRACE)
			{
				Lexer.lex();                                        
			}
			else 
			{
				System.out.println("Expected Right Brace ");
			}
		}
		else if(Lexer.nextToken==Token.KEY_IF)
		{

			new Stmt();
		}
		else if(Lexer.nextToken==Token.ID)
		{

			new Stmt();
		}

	}
}
