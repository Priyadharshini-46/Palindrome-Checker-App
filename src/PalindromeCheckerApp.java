import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Stack;

public class PalindromeCheckerApp {

    // Stack-based approach
    static boolean stackPalindrome(String str) {
        String normalized = str.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char ch : normalized.toCharArray()) stack.push(ch);
        for (char ch : normalized.toCharArray()) if (ch != stack.pop()) return false;
        return true;
    }

    // Deque-based approach
    static boolean dequePalindrome(String str) {
        String normalized = str.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();
        for (char ch : normalized.toCharArray()) deque.addLast(ch);
        while (deque.size() > 1) if (deque.removeFirst() != deque.removeLast()) return false;
        return true;
    }

    // Two-pointer string approach
    static boolean twoPointerPalindrome(String str) {
        String normalized = str.replaceAll("\\s+", "").toLowerCase();
        int start = 0, end = normalized.length() - 1;
        while (start < end) if (normalized.charAt(start++) != normalized.charAt(end--)) return false;
        return true;
    }

    public static void main(String[] args) {

        String input = "A man a plan a canal Panama";

        // Measure Stack strategy
        long startTime = System.nanoTime();
        boolean resultStack = stackPalindrome(input);
        long durationStack = System.nanoTime() - startTime;

        // Measure Deque strategy
        startTime = System.nanoTime();
        boolean resultDeque = dequePalindrome(input);
        long durationDeque = System.nanoTime() - startTime;

        // Measure Two-pointer strategy
        startTime = System.nanoTime();
        boolean resultTwoPointer = twoPointerPalindrome(input);
        long durationTwoPointer = System.nanoTime() - startTime;

        // Display results
        System.out.println("Palindrome check for: \"" + input + "\"\n");

        System.out.println("Stack strategy: " + (resultStack ? "Palindrome" : "Not Palindrome")
                + " | Time: " + durationStack + " ns");

        System.out.println("Deque strategy: " + (resultDeque ? "Palindrome" : "Not Palindrome")
                + " | Time: " + durationDeque + " ns");

        System.out.println("Two-pointer strategy: " + (resultTwoPointer ? "Palindrome" : "Not Palindrome")
                + " | Time: " + durationTwoPointer + " ns");

        System.out.println("\nProgram executed successfully.");
    }
}
