package Tokens;

public class Token {
    public final TokenType type;
    public final double value; // Only used if the type is NUMBER

    // Constructor for numbers (which need a value)
    public Token(TokenType type, double value) {
        this.type = type;
        this.value = value;
    }

    // Constructor for symbols (which don't need a value)
    public Token(TokenType type) {
        this.type = type;
        this.value = 0.0;
    }

    public TokenType getType() {
        return this.type;
    }

    public double getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        if (type == TokenType.NUMBER) {
            return String.format("Token(%s, %f)", type, value);
        }
        return String.format("Token(%s)", type);
    }
}
