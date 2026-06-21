package AST;

public class ASTPrinter {

    /*
     * FOR TESTING PURPOSES ONLY
     */

    public static void printTree(ASTNode node) {
        System.out.println("--- Abstract Syntax Tree ---");
        printRecursive(node, 0);
        System.out.println("----------------------------");
    }

    private static void printRecursive(ASTNode node, int level) {
        // Create an indentation string based on how deep we are in the tree
        StringBuilder indentBuilder = new StringBuilder();
        for (int i = 0; i < level; i++) {
            indentBuilder.append("  |__ ");
        }
        String indent = indentBuilder.toString();

        // If it's a Number, just print the value
        if (node instanceof NumberNode) {
            NumberNode numNode = (NumberNode) node;
            System.out.println(indent + numNode.value);
        }
        // If it's an Operator, print the operator, then recursively print left and
        // right
        else if (node instanceof BinaryNode) {
            BinaryNode binNode = (BinaryNode) node;
            System.out.println(indent + binNode.operator);

            // Go one level deeper for the children
            printRecursive(binNode.left, level + 1);
            printRecursive(binNode.right, level + 1);
        } else {
            System.out.println(indent + "UNKNOWN NODE TYPE");
        }
    }
}
