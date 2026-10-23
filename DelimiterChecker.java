/* Description: Uses a stack to check whether (), [] and {} in a user-entered
 * sequence are properly matched and nested.
 *
 * Programmed by: Joshua L. Muñasque BSIT 48079 Data Structures
 *
 * Last Modified: October 23, 2026
 *
 * Version: 1.0
 *
 * [Acknowledgements: Pailine Rivas, W3school, WIKIPEDIA, Claude.]
 */
import java.util.Scanner;
import java.util.Stack;
 
public class DelimiterChecker {
 
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
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sequence: ");
        String input = sc.hasNextLine() ? sc.nextLine() : "";
 
        Stack<Character> stack = new Stack<>();
 
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
 
            if (isOpening(c)) {
                stack.push(c);
            } else if (isClosing(c)) {
                if (stack.isEmpty()) {
                    System.out.println("Invalid: closing delimiter '" + c
                        + "' has no matching opening delimiter.");
                    return;
                }
                char top = stack.peek();
                if (!matches(top, c)) {
                    System.out.println("Invalid: mismatched delimiters. '" + c
                        + "' does not match '" + top + "' at the top of the stack.");
                    return;
                }
                stack.pop();
            }
        }
 
        if (stack.isEmpty()) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid: unmatched opening delimiter remains: " + stack);
        }
    }
}