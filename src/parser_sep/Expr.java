package parser_sep;

class Expr {  

	public Expr() 
	{
		char ari_var = ' ';
		new Term();
		if (Lexer.nextToken == Token.SUB_OP || Lexer.nextToken == Token.ADD_OP) 
		{
			ari_var = Lexer.nextChar;
			Lexer.lex();
			new Expr();
			Code.byteCodeMap_push(Code.operator_byteCode(ari_var));
		}

	}	
}
