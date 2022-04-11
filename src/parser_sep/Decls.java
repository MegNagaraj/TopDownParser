package parser_sep;

class Decls {

	public Decls(){
		if(Lexer.nextToken == Token.KEY_INT)
		{
		
			Lexer.lex();
			new Idlist();

			if(Lexer.nextToken == Token.SEMICOLON){
				Lexer.lex();
			}
			else 
			{
				System.out.println("Expected Semicolon. not found");
			}
		} 
		else 
		{
			System.out.println("Expected Int. not found");
		}
	}
}