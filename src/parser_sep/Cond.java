package parser_sep;

class Cond {

	public Cond()
	{
		if(Lexer.nextToken == Token.LEFT_PAREN){
			Lexer.lex();
			new Relexp();
			int ifelse_var = Code.ptr_var - 3; //MEG:if/else +3 bytes

			if(Lexer.nextToken == Token.RIGHT_PAREN){
				Lexer.lex();
				new Cmpdstmt();
				if(Lexer.nextToken == Token.KEY_ELSE){
					Code.byteCodeMap.put(ifelse_var,Code.byteCodeMap.get(ifelse_var)+" "+(Code.ptr_var+3));
					ifelse_var= Code.ptr_var;
					Code.ptr_var+=3;
					Lexer.lex();
					new Cmpdstmt();
					Code.byteCodeMap.put(ifelse_var, "goto "+ (Code.ptr_var) );
				}
				else
				{
					Code.byteCodeMap.put(ifelse_var,Code.byteCodeMap.get(ifelse_var)+" "+(Code.ptr_var));
				}
			} else
			{
				System.out.println("Expected Right parenthesis");
			}
		} else
		{
			System.out.println("Expected Left parenthesis");
		}
	}
}