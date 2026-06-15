import Tokens.Token;

public class Lexer {
    private final String input;
    private int position;

    public Lexer(String input) {
        this.input = input;
        this.position = 0;
    }

    // Your goal: Scan the string character by character, ignore spaces,
    // and group characters into logical Tokens.
    public Token getNextToken() {
        // TODO: If end of string, return EOF Token
        // TODO: Skip whitespaces
        // TODO: If character is a digit, extract full number and return NUMBER Token
        // TODO: If character is +, -, *, /, (, or ), return respective Token
        return null;
    }
}
