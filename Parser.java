import Tokens.*;
import AST.*;

public class Parser {
    private final Lexer lexer;
    private Token currentToken;

    public Parser(Lexer lexer) {
        this.lexer = lexer;
        this.currentToken = lexer.getNextToken();
    }

    private void eat(TokenType expectedType) {
        // TODO: If currentToken matches expected, move to next token. Else throw error.
    }

    // Rule 1
    public ASTNode parseExpression() {
        // TODO: Call parseTerm(), then loop while currentToken is PLUS or MINUS.
        // Return a BinaryNode.
        return null;
    }

    // Rule 2
    private ASTNode parseTerm() {
        // TODO: Call parseFactor(), then loop while currentToken is MULTIPLY or DIVIDE.
        // Return a BinaryNode.
        return null;
    }

    // Rule 3
    private ASTNode parseFactor() {
        // TODO: If NUMBER, return NumberNode.
        // TODO: If LPAREN, eat it, call parseExpression(), eat RPAREN, return that
        // node.
        return null;
    }
}
