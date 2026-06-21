import Tokens.*;
import java.util.List;
import AST.*;

public class Parser {
    private List<Token> tokens;
    private int position;

    public Parser(List<Token> tokens) {
        this.tokens = tokens;
        this.position = 0;
    }

    private void eat(TokenType expectedType) throws IllegalArgumentException {
        System.out.println(tokens.get(position));
        System.out.println("Expected: " + expectedType);
        if (tokens.get(position).type.equals(expectedType)) {
            position++;
        } else {
            throw new IllegalArgumentException("Input is invalid!");
        }
    }

    public ASTNode parseExpression() {
        // TODO: Call parseTerm(), then loop while currentToken is PLUS or MINUS.
        // Return a BinaryNode.

        ASTNode leftTerm = parseTerm();

        while (tokens.get(position).type.equals(TokenType.PLUS) || tokens.get(position).type.equals(TokenType.MINUS)) {
            // Skip operator
            Token operatorToken = tokens.get(position);
            eat(operatorToken.type);

            // Build right branch
            ASTNode rightTerm = parseTerm();
            leftTerm = new BinaryNode(leftTerm, operatorToken.type, rightTerm);
        }

        return leftTerm;
    }

    private ASTNode parseTerm() {
        // TODO: Call parseFactor(), then loop while currentToken is MULTIPLY or DIVIDE.
        // Return a BinaryNode.

        ASTNode leftFactor = parseFactor();

        while (tokens.get(position).type.equals(TokenType.MULTIPLY)
                || tokens.get(position).type.equals(TokenType.DIVIDE)) {
            // Skip operator
            Token operatorToken = tokens.get(position);
            eat(operatorToken.type);

            // Build right branch
            ASTNode rightFactor = parseFactor();
            leftFactor = new BinaryNode(leftFactor, operatorToken.type, rightFactor);
        }

        return leftFactor;
    }

    private ASTNode parseFactor() {
        // TODO: If NUMBER, return NumberNode.
        // TODO: If LPAREN, eat it, call parseExpression(), eat RPAREN, return that
        // node.
        Token currentToken = tokens.get(position);

        if (currentToken.type.equals(TokenType.NUMBER)) {
            eat(TokenType.NUMBER);
            return new NumberNode(currentToken.value);
        } else if (currentToken.type.equals(TokenType.LPAREN)) {
            eat(TokenType.LPAREN);
            ASTNode expressionNode = parseExpression();
            eat(TokenType.RPAREN);
            return expressionNode;
        }

        throw new IllegalArgumentException("Input is invalid!");
    }

    public ASTNode parse() {
        ASTNode rootNode = parseExpression();

        if (tokens.get(position).type != TokenType.EOF) {
            throw new IllegalArgumentException("Unexpected tokens at the end of the expression!");
        }

        return rootNode;
    }
}
