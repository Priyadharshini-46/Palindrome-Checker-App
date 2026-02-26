import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Stack;

// PalindromeStrategy interface
interface PalindromeStrategy {
    boolean isPalindrome(String input);
}

// Stack-based strategy
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char ch : normalized.toCharArray()) {
            stack.push(ch);
        }

        for (char ch : normalized.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

// Deque-based strategy
class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();
        for (char ch : normalized.toCharArray()) {
            deque.addLast(ch);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }
}

// Context class for Strategy Pattern
class PalindromeChecker {

    private PalindromeStrategy strategy;

    public PalindromeChecker(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean check(String input) {
        return strategy.isPalindrome(input);
    }

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }
}

// Main application
public class PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "Step on no pets";

        // Use Stack strategy
        PalindromeChecker checker = new PalindromeChecker(new StackStrategy());
        boolean resultStack = checker.check(input);
        System.out.println("Using Stack Strategy: " + (resultStack ? "Palindrome" : "Not Palindrome"));

        // Switch to Deque strategy
        checker.setStrategy(new DequeStrategy());
        boolean resultDeque = checker.check(input);
        System.out.println("Using Deque Strategy: " + (resultDeque ? "Palindrome" : "Not Palindrome"));

        System.out.println("Program executed successfully.");
    }
}
