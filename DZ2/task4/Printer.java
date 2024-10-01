package task4;

import java.util.Arrays;
class Statistics {
    public static double findAverage(int[] numbers) {
        try {
            if (numbers == null || numbers.length == 0) {
                System.out.println("Массив не определен или полон.");
                return Double.NaN;
            }
            double sum = 0;
            for (int n : numbers) {
                sum += n;
            }
            return sum / numbers.length;
        } catch (Exception e) {

            System.out.println("Ошибка вычисления ср арифмитического.");
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