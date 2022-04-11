package parser_sep;

class Stmt {
	static String id_var = " ";

	public Stmt(){

		switch(Lexer.nextToken){
		case Token.ID:

			id_var = Lexer.ident;
			Lexer.lex();
			new Assign();
			if(Code.tempMap_present(id_var)){
				Integer varByteCode = Code.tempMap_retrieve(id_var);
				if(varByteCode<=3)
				{
					Code.byteCodeMap_push("istore_"+varByteCode);
				}
				else
				{
					Code.byteCodeMap_push("istore "+varByteCode);
					Code.ptr_var+=1; //MEG: need to store extra byte after 4
				}
			}
			break;
		case Token.KEY_WHILE:
			Lexer.lex();
			new Loop();
			break;
		case Token.KEY_IF:
			Lexer.lex();
			new Cond();
			break;

		}
	}
} 

