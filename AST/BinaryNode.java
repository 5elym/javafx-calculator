package AST;

// A branch node: holds a math operator and the nodes on its left and right
public class BinaryNode extends ASTNode {
    public final ASTNode left;
    public final TokenType operator;
    public final ASTNode right;

    public BinaryNode(ASTNode left, TokenType operator, ASTNode right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }
}
