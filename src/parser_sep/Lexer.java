package parser_sep;
import java.io.*;

public class Lexer {

	static public char ch = ' ';
	static public String ident = "";
	static private Buffer buffer = new Buffer(new DataInputStream(System.in));
	static public int nextToken;
	static public char nextChar;
	static public int intValue;

	public static int lex() {
		while (Character.isWhitespace(ch))
			ch = buffer.getChar();
		if (Character.isLetter(ch)) {
			ident = getIdent();
			if (ident.equals("if")) nextToken = Token.KEY_IF;  
			else if (ident.equals("int"))nextToken = Token.KEY_INT; 
			else if (ident.equals("else")) nextToken = Token.KEY_ELSE;
			else if (ident.equals("end")) nextToken = Token.KEY_END; 
			else if (ident.equals("while")) nextToken = Token.KEY_WHILE; 
			else if (ident.equals("return")) nextToken = Token.KEY_RETURN;
			     else nextToken = Token.ID;
			}
		else if (Character.isDigit(ch)) {
			nextToken = getNumToken(); // intValue would be set
		} 
		else {
			nextChar = ch;
			switch (ch) {
			case ';':
				nextToken = Token.SEMICOLON;
				ch = buffer.getChar();
				break;
			case ',':
				nextToken = Token.COMMA;
				ch = buffer.getChar();
				break;
			case '+':
				nextToken = Token.ADD_OP;
				ch = buffer.getChar();
				break;
			case '-':
				nextToken = Token.SUB_OP;
				ch = buffer.getChar();
				break;
			case '*':
				nextToken = Token.MULT_OP;
				ch = buffer.getChar();
				break;
			case '/':
				nextToken = Token.DIV_OP;
				ch = buffer.getChar();
				break;
			case '=':
				ch = buffer.getChar();
				if (ch == '=') 
					  { nextToken = Token.EQ_OP; 
					    ch = buffer.getChar(); 
					  }
				else nextToken = Token.ASSIGN_OP;
				break;
			case '<':
				 nextToken = Token.LESSER_OP;
			     ch = buffer.getChar();
				break;
			case '>':
				nextToken = Token.GREATER_OP;
				ch = buffer.getChar();
				break;
			case '!':
				ch = buffer.getChar(); // '='
				nextToken = Token.NOT_EQ;
				ch = buffer.getChar();
				break;
			case '(':
				nextToken = Token.LEFT_PAREN;
				ch = buffer.getChar();
				break;
			case ')':
				nextToken = Token.RIGHT_PAREN;
				ch = buffer.getChar();
				break;
			case '{':
				nextToken = Token.LEFT_BRACE;
				ch = buffer.getChar();
				break;
			case '}':
				nextToken = Token.RIGHT_BRACE;
				ch = buffer.getChar();
				break;
			default:
				error("Illegal character " + ch);
				break;
			}
		}
		return nextToken;
	} // lex

	private static String getIdent() {
		// ch is declared in class Lexer
		String ident = "";
		do {
			ident = ident + ch;
			ch = buffer.getChar();
		} while (Character.isLetter(ch) || Character.isDigit(ch));
		return ident;
	}
	
	private static int getNumToken() {
		int num = 0;
		do {
			num = num * 10 + Character.digit(ch, 10);
			ch = buffer.getChar();
		} while (Character.isDigit(ch));
		intValue = num;
		return Token.INT_LIT;
	}
	
	public int number() {
		return intValue;
	}

	public String identifier() {
		return ident;
	}

	public static void error(String msg) {
		System.err.println(msg);
		System.exit(1);
	}


}