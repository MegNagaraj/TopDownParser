package parser_sep;

/* Parser code for TinyPL
 * 
 * @author Meghana Nagaraj
 * CSU ID: 2805897
 * 
 * */
public class Parser {

	public static void main(String[] args) 
	{
		System.out.println("Please write input code and terminate with 'end', and press enter key \n");
		Lexer.lex();
		new Body();
		Code.output();
	}
}