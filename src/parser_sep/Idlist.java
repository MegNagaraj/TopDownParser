package parser_sep;

class Idlist 
{
	static int count_id = 0;
	String id;
	public Idlist(){
		rec_func();
	}

	private void rec_func()
	{
		if(Lexer.nextToken == Token.ID)
		{
			id = Lexer.ident;
			Code.tempMap_push(id, ++count_id); //Meg:first increment then use
			Lexer.lex();
			if(Lexer.nextToken == Token.COMMA)
			{
				Lexer.lex();
				rec_func();
			}
		}
		else
		{
			System.out.println("Expecting ID; not found");
		}
	}
}