package src.task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Answer {
    public int[] subArraysWithExceptionHandling(int[] a, int[]
            b, List<String> errors) {
        if (a.length != b.length) {
            errors.add("Массивы разной длины");
            return new int[0];
        }
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i] - b[i];
            if (result[i] < 0) {
                errors.add("Отрицательный результат разности в позиции " + i + ": " + result[i]);
            }
        }

        return result;
    }
}
public class Printer {
    public static void main(String[] args) {
        List<String> errors = new ArrayList<>();
        int[] a = {10, 20, 30};
        int[] b = {5, 15, 35};
        int[] result = new
                Answer().subArraysWithExceptionHandling(a, b, errors);
        System.out.println(Arrays.toString(result)); //Ожидаемый результат: исключение RuntimeException
        int[] c = {10, 20};
        int[] d = {5, 15, 25};
        result = new Answer().subArraysWithExceptionHandling(c,
                d, errors); // Ожидаемый результат: исключение IllegalArgumentException
        System.out.println(Arrays.toString(result));
// Проверяем, если были ошибки
        if (!errors.isEmpty()) {
            System.out.println("Обнаружены ошибки:");
            for (String error : errors) {
                System.out.println(error);
            }
        } else {
            System.out.println("Ошибок не обнаружено.");
        }
    }
}
