import AST.*;
import Tokens.*;

public class Evaluator {

    // Potentiall add calculator variables and history here

    public double evaluate(ASTNode node) {
        return switch (node) {
            case NumberNode num -> num.value;
            case BinaryNode bin -> evaluateBinaryNode(bin);
        };
    }

    private double evaluateBinaryNode(BinaryNode node) throws IllegalArgumentException {
        double leftNum = evaluate(node.left);
        double rightNum = evaluate(node.right);

        return switch (node.operator) {
            case TokenType.PLUS -> leftNum + rightNum;
            case TokenType.MINUS -> leftNum - rightNum;
            case TokenType.MULTIPLY -> leftNum * rightNum;
            case TokenType.DIVIDE -> leftNum / rightNum;
            default -> throw new IllegalArgumentException("Unknown operator: " + node.operator);
        };
    }
}
