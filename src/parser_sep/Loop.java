package parser_sep;

class Loop 
{
	public Loop()
	{
		int gotoPtr = Code.ptr_var;

		if(Lexer.nextToken == Token.LEFT_PAREN)
		{
			Lexer.lex();
			new Relexp();
			int temp = Code.ptr_var - 3;

			if(Lexer.nextToken == Token.RIGHT_PAREN)
			{
				Lexer.lex();
				new Cmpdstmt();
				Code.byteCodeMap_push("goto " + gotoPtr);
				Code.byteCodeMap.put(temp,Code.byteCodeMap.get(temp)+" "+(Code.ptr_var+=2));
			}
			else
			{
				System.out.println("Expected Right parenthesis. not found");
			}
		}
	}
}
