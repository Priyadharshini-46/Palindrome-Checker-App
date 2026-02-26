public class PalindromeCheckerApp {
    // Recursive function to check palindrome
    static boolean isPalindrome(String str, int start, int end) {
        // Base condition: single character or crossed pointers
        if (start >= end) {
            return true;
        }

        // If characters at start and end are different, not a palindrome
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive call: move inward
        return isPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {

        String word = "racecar";

        // Call recursive function
        boolean result = isPalindrome(word, 0, word.length() - 1);

        if (result) {
            System.out.println("The word \"" + word + "\" is a Palindrome.");
        } else {
            System.out.println("The word \"" + word + "\" is NOT a Palindrome.");
        }

        System.out.println("Program executed successfully.");
    }
}

