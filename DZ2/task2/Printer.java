package task2;

 class PalindromeChecker {
     public static boolean isPalindrome(String input) {
         try {

             // Удаляем пробелы и приводим строку к нижнему регистру
             String cleanedInput = input.replaceAll("[\\W_]", "").toLowerCase();

             // Проверяем, является ли строка палиндромом
             String reversedInput = new StringBuilder(cleanedInput).reverse().toString();

             if (!(cleanedInput.equals(reversedInput))) {
                 return false;
             } else {
                 return true;
             }

         } catch (Exception e) {

             System.err.println("An error occurred while checking for palindrome.");

         }
         return false;

     }
 }







public class Printer {
    public static void main(String[] args) {
        String input;
        if (args.length > 0) {
            input = args[0];
        } else {
            input = "A man a plan a canal Panama";
        }
        boolean result = task2.PalindromeChecker.isPalindrome(input);
        System.out.println("Is the input a palindrome? " +
                result);
    }
}
