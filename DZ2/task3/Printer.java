package task3;

import java.util.Arrays;
class StringSorter {
    public static String[] sortStrings(String[] str) {
        try {
            if (str == null) {
                System.out.println("Input array is null. Returning  empty ");
            }
            Arrays.sort(str);
            return str;
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
            strings = new String[]{"banana", "apple", "cherry"};
        }
        String[] result = StringSorter.sortStrings(strings);
        System.out.println(Arrays.toString(result));
    }
}

