package Tokens;

public enum TokenType {
    NUMBER,
    PLUS,
    MINUS,
    MULTIPLY,
    DIVIDE,
    LPAREN,
    RPAREN,
    EOF // "End of File" - crucial for telling the parser to stop looking for more math
}
