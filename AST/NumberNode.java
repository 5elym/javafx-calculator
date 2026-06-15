package AST;

// A leaf node: literally just holds a number
public class NumberNode extends ASTNode {
    public final double value;

    public NumberNode(double value) {
        this.value = value;
    }
}
