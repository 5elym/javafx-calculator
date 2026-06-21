import java.util.ArrayList;
import java.util.List;

import AST.ASTNode;
import AST.ASTPrinter;
import Tokens.Token;
import Tokens.TokenType;

public class Lexer {
    private final char[] input;
    private int position;
    private List<Token> tokenList;

    public Lexer(String input) {
        this.input = input.toCharArray();
        this.position = 0;
        this.tokenList = new ArrayList<Token>();
    }

    /**
     * Reads the next token from the input and advances the position.
     * Handles numbers, operators, parentheses, and whitespace.
     * 
     * @return The next token in the input, or null if an invalid character is
     *         found.
     */
    public Token getNextToken() throws RuntimeException {
        if (position >= input.length)
            return new Token(TokenType.EOF);

        // Handle numbers
        char character = input[position];
        if (Character.isDigit(character)) {
            String numString = "";
            while (position < input.length && Character.isDigit(input[position])) {
                numString += input[position];
                position++;
            }
            return new Token(TokenType.NUMBER, Double.parseDouble(numString));
        }

        // Handle operators and parentheses
        switch (character) {
            case '+' -> {
                position++;
                return new Token(TokenType.PLUS);
            }
            case '-' -> {
                position++;
                return new Token(TokenType.MINUS);
            }
            case '*' -> {
                position++;
                return new Token(TokenType.MULTIPLY);
            }
            case '/' -> {
                position++;
                return new Token(TokenType.DIVIDE);
            }
            case '(' -> {
                position++;
                return new Token(TokenType.LPAREN);
            }
            case ')' -> {
                position++;
                return new Token(TokenType.RPAREN);
            }
            case ' ' -> {
                position++;
                return getNextToken();
            }
        }

        throw new RuntimeException("Unexpected character: " + character);
    }

    /**
     * Parses the entire input string and fills the token list with all tokens
     * found.
     * This method continues to call getNextToken until it reaches the end of the
     * input (EOF).
     */
    public void parseInput() {
        try {
            Token token = getNextToken();
            while (!token.getType().equals(TokenType.EOF)) {
                tokenList.add(token);
                token = getNextToken();
            }
            tokenList.add(token); // Add EOF token at the end
        } catch (RuntimeException e) {
            System.err.println("Error while parsing input! " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Unexpected error! " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Token> getTokens() {
        return tokenList;
    }

    public static void main(String[] args) {
        // String input = "3 + 5 * (2 - 8)";
        String input = "3 + 4 * 2";
        Lexer lexer = new Lexer(input);
        lexer.parseInput();
        List<Token> tokens = lexer.getTokens();
        for (Token token : tokens) {
            System.out.println(token);
        }

        System.out.println("---------------------------------------------------");

        Parser parser = new Parser(tokens);
        ASTNode astRoot = parser.parse();

        ASTPrinter.printTree(astRoot);

        Evaluator evaluator = new Evaluator();

        double result = evaluator.evaluate(astRoot);

        System.out.println("RESULT: " + result);
    }
}
