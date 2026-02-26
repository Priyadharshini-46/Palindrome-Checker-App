public class PalindromeCheckerApp {
    // Function to check palindrome using two-pointer approach
    static boolean isPalindrome(String str) {
        // Normalize: remove spaces and convert to lowercase
        String normalized = str.replaceAll("\\s+", "").toLowerCase();

        int start = 0;
        int end = normalized.length() - 1;

        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {

        String input = "A man a plan a canal Panama";

        boolean result = isPalindrome(input);

        if (result) {
            System.out.println("The string \"" + input + "\" is a Palindrome (ignoring case and spaces).");
        } else {
            System.out.println("The string \"" + input + "\" is NOT a Palindrome (ignoring case and spaces).");
        }

        System.out.println("Program executed successfully.");
    }
}

