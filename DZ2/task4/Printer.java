package task4;

import java.util.Arrays;
class Statistics {
    public static double findAverage(int[] array) {
        try {
            if (array == null || array.length == 0) {
                System.out.println("Array is empty or null. Cannot compute average.");
                return Double.NaN;
            }
            double sum = 0;
            for (int num : array) {
                sum += num;
            }
            return sum / array.length;
        } catch (Exception e) {

            System.out.println("An error occurred while computing the average.");
            return Double.NaN;
        }
    }
}
public class Printer {
    public static void main(String[] args) {
        int[] array;
        if (args.length > 0) {
            array = Arrays.stream(args[0].split(" ")).mapToInt(Integer::parseInt).toArray();
        } else {
            array = new int[]{10, 20, 30, 40, 50}; // Значение поумолчанию
        }
        double average = Statistics.findAverage(array);
        System.out.println(average);
    }
}