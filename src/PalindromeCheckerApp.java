import java.util.Deque;
import java.util.ArrayDeque;

public class PalindromeCheckerApp {
    // PalindromeChecker class encapsulates palindrome logic
    static class PalindromeChecker {

        // Method to check if a string is a palindrome (ignores case and spaces)
        public boolean checkPalindrome(String input) {
            // Normalize string
            String normalized = input.replaceAll("\\s+", "").toLowerCase();

            // Use deque for efficient front & rear comparison
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

    public static void main(String[] args) {

        String input = "Madam In Eden Im Adam";

        // Create PalindromeChecker object
        PalindromeChecker checker = new PalindromeChecker();

        // Check palindrome
        if (checker.checkPalindrome(input)) {
            System.out.println("The string \"" + input + "\" is a Palindrome (ignoring case and spaces).");
        } else {
            System.out.println("The string \"" + input + "\" is NOT a Palindrome (ignoring case and spaces).");
        }

        System.out.println("Program executed successfully.");
    }
}


