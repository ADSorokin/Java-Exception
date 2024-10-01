package task3;

import java.util.Arrays;
class StringSorter {
    public static String[] sortStrings(String[] strings) {
        try {
            if (strings == null) {
                System.out.println("Input array is null. Returning an empty array.");
                return new String[0];
            }
            Arrays.sort(strings);
            return strings;
        } catch (Exception e) {

            System.out.println("An error occurred during sorting.");
            return new String[0];
        }
    }
}
public class Printer {
    public static void main(String[] args) {
        String[] strings;
        if (args.length > 0) {
            strings = args[0].split(",");
        } else {
            strings = new String[]{"banana", "apple", "cherry"}; //Значение по умолчанию
        }
        String[] result = StringSorter.sortStrings(strings);
        System.out.println(Arrays.toString(result));
    }
}

