package parser_sep;

class Term {  

	public Term() 
	{
		char ari_var = ' '; //MEG: arithmetic variable to check for * or /
		new Factor();
		if (Lexer.nextToken == Token.DIV_OP || Lexer.nextToken == Token.MULT_OP) 
		{
			ari_var = Lexer.nextChar;
			Lexer.lex();
			new Term();
			Code.byteCodeMap_push(Code.operator_byteCode(ari_var));
		}
	}
}