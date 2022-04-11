package parser_sep;

class Factor {  

	public Factor() 
	{
		int lit_value;
		switch (Lexer.nextToken) 
		{
		case Token.ID:
			Integer code = Code.tempMap_retrieve(Lexer.ident);
			if(code != null && code<=3)
			{
				Code.byteCodeMap_push("iload_" + code.toString());
			}
			else
			{
				Code.byteCodeMap_push("iload "+code.toString());
				Code.ptr_var += 1; //MEG: extra coz needs to save 2 bytes
			}
			Lexer.lex();
			break;
		case Token.INT_LIT: 
			lit_value = Lexer.intValue;
			Lexer.lex();
			if((lit_value>=0) && (lit_value <= 5))
			{
				Code.byteCodeMap_push("iconst_" + lit_value);
			} 
			else if ( lit_value > 127)
			{
				Code.byteCodeMap_push("sipush " + lit_value);
				Code.ptr_var += 2; //MEG: after 127 add 3 bytes instead of 1
			} 
			else 
			{
				Code.byteCodeMap_push("bipush " + lit_value);
				Code.ptr_var++;
			}
			break;
		case Token.LEFT_PAREN: 
			Lexer.lex();
			new Expr();
			Lexer.lex(); 
			break;
		default:
			System.out.println("Expected id, or expr, or intLit; Not found");
			break;
		}
	}

}