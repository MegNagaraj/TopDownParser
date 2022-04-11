package parser_sep;

class Relexp {

	public Relexp(){
		new Expr();

		switch(Lexer.nextToken){
		case Token.GREATER_OP:
			Lexer.lex();
			if(Lexer.nextToken == Token.ASSIGN_OP) //MEG: >=
			{
				Lexer.lex();
				new Expr();
				Code.byteCodeMap_push("if_icmplt"); //MEG: check opp of >= ie Lt
				break;
			}
			else
			{
				new Expr();
				Code.byteCodeMap_push("if_icmple");//MEG: check opp of ? ie le
				break;
			}
		case Token.LESSER_OP:
			Lexer.lex(); 
			if(Lexer.nextToken == Token.ASSIGN_OP)
			{
				Lexer.lex(); //MEG: to next expression
				new Expr();
				Code.byteCodeMap_push("if_icmpgt"); //MEG: check opp of <= ie Gt
				break;
			}
			else
			{
				new Expr();
				Code.byteCodeMap_push("if_icmpge"); //MEG: check opp of < ie GE
				break;
			}
		case Token.ASSIGN_OP:
			Lexer.lex();
			new Expr();
			Code.byteCodeMap_push("if_icmpaeq............"); //MEG: TBD
			break;
		case Token.NOT_EQ:
			Lexer.lex();
			new Expr();
			Code.byteCodeMap_push("if_icmpeq"); //MEG: check opp of != ie ==
			break;
		case Token.EQ_OP:
			Lexer.lex();
			new Expr();
			Code.byteCodeMap_push("if_icmpne"); //MEG: check opp of == ie !=
			break;
		default:
			System.out.println("Expected one of the following <,>,<=,>=,==,!= ; Not found");
			break;
		}
		Code.ptr_var+=2;
	}
}
