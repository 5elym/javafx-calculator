import AST.*;

public class Evaluator {

    // This method takes the root of your tree and recursively calculates the final
    // double
    public double evaluate(ASTNode node) {

        // Base case: If it's just a number, return the number.
        if (node instanceof NumberNode) {
            // TODO: Cast to NumberNode and return its value
        }

        // Recursive case: If it's a binary operation, evaluate the left side,
        // evaluate the right side, and apply the operator.
        if (node instanceof BinaryNode) {
            // TODO: Cast to BinaryNode
            // TODO: double leftVal = evaluate(binaryNode.left);
            // TODO: double rightVal = evaluate(binaryNode.right);
            // TODO: Check binaryNode.operator and return leftVal + rightVal, etc.
        }

        throw new RuntimeException("Unknown AST Node type");
    }
}
