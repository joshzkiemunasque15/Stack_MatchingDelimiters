/* Description: Uses a stack to check whether (), [] and {} in a user-entered
 * sequence are properly matched and nested.
 *
 * Programmed by: Joshua L. Muñasque BSIT 48079 Data Structures
 *
 * Last Modified: October 23, 2026
 *
 * Version: 1.0
 *
 * [Acknowledgements: Pailine Rivas, W3school, WIKIPEDIA, Claude.] */
import java.util.Scanner;
import java.util.Stack;
 
public class DelimiterCheckerTrace {
 
    static boolean isOpening(char c) {
        return c == '(' || c == '[' || c == '{';
    }
 
    static boolean isClosing(char c) {
        return c == ')' || c == ']' || c == '}';
    }
 
    static boolean matches(char open, char close) {
        return (open == '(' && close == ')')
            || (open == '[' && close == ']')
            || (open == '{' && close == '}');
    }
 
    static String show(Stack<Character> s) {
        if (s.isEmpty()) return "(empty)";
        StringBuilder sb = new StringBuilder();
        for (char c : s) sb.append(c).append(' ');
        return sb.toString().trim();
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sequence: ");
        String input = sc.hasNextLine() ? sc.nextLine() : "";
        System.out.println("Input: " + input);
 
        Stack<Character> stack = new Stack<>();
 
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
 
            if (isOpening(c)) {
                System.out.println("Read: " + c);
                stack.push(c);
                System.out.println("Operation: PUSH " + c);
                System.out.println("Stack: " + show(stack));
            } else if (isClosing(c)) {
                System.out.println("Read: " + c);
                if (stack.isEmpty()) {
                    System.out.println("Operation: isEmpty -> true");
                    System.out.println("Invalid: closing delimiter '" + c
                        + "' has no matching opening delimiter.");
                    return;
                }
                char top = stack.peek();
                System.out.println("Operation: PEEK -> " + top);
                if (!matches(top, c)) {
                    System.out.println("Invalid: mismatched delimiters. '" + c
                        + "' does not match '" + top + "' at the top of the stack.");
                    System.out.println("Stack: " + show(stack));
                    return;
                }
                stack.pop();
                System.out.println("Operation: POP " + top);
                System.out.println("Stack: " + show(stack));
            }
        }
 
        if (stack.isEmpty()) {
            System.out.println("Valid: stack is empty after processing.");
        } else {
            System.out.println("Invalid: unmatched opening delimiter remains: " + show(stack));
        }
    }
}