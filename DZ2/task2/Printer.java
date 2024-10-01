package task2;

 class PalindromeChecker {
    public static boolean isPalindrome(String input) {
        try {

            String cleanedInput = input.replace(" ", "").toLowerCase();

            int length = cleanedInput.length();

            for (int i = 0; i < length / 2; i++) {
                if (cleanedInput.charAt(i) !=
                        cleanedInput.charAt(length - i - 1)) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {

            System.err.println("An error occurred while checking for palindrome.");
            return false;
        }
    }
}
public class Printer {
    public static void main(String[] args) {
        String input;
        if (args.length > 0) {
            input = args[0];
        } else {
            input = "A man a plan a canal Panama"; // Значениепо умолчанию
        }
        boolean result = task2.PalindromeChecker.isPalindrome(input);
        System.out.println("Is the input a palindrome? " +
                result);
    }
}
