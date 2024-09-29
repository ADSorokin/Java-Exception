package src.task1;

/**
 * Задание 1. Преобразование строки в число
 * Реализуйте метод convertAndSum, который принимает массив строк, каждая
 * из которых должна быть преобразована в целое число. Метод возвращает
 * сумму всех чисел. Если хотя бы одна строка не может быть преобразована в
 * число, метод должен выбросить исключение NumberFormatException.
 * Дополнительно, если сумма чисел превышает 100, выбрасывайте
 * ArithmeticException с сообщением "Превышен лимит суммы"
 *
 * Задача 2. Объединение массивов с проверкой длины и содержимого
 * Реализуйте метод mergeAndValidateArrays, который принимает два
 * массива целых чисел. Метод должен объединить массивы и вернуть новый
 * массив. Если длины массивов не равны, выбрасывайте исключение
 * IllegalArgumentException. Если хотя бы один элемент объединенного
 * массива отрицательный, выбрасывайте исключение RuntimeException с
 * сообщением "Обнаружен отрицательный элемент"
 *
 * Задача 3. Обработка исключений для разностных массивов
 * Реализуйте метод subArraysWithExceptionHandling, который принимает
 * два массива целых чисел. Метод должен возвращать новый массив, где
 * каждый элемент является разностью соответствующих элементов двух входных
 * массивов. Если длины массивов не равны, выбрасывайте
 * IllegalArgumentException с сообщением "Массивы разной длины". Если
 * результат разности оказывается отрицательным, выбрасывайте
 * RuntimeException с сообщением "Отрицательный результат разности".
 *
 * Задача 4. Поиск и замена строк
 * Реализуйте метод findAndReplace, который принимает массив строк, строку
 * для поиска и строку для замены. Если искомая строка не найдена, добавьте
 * сообщение об ошибке в список. Верните новый массив строк с выполненной
 * заменой.
 *
 *
 */



class Answer {
    public static int convertAndSum(String[] strings) {
        int sum=0;
        for (String s : strings) {
            try {
                sum+=Integer.parseInt(s);
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Невозможно преобразовать число"+e);
            } if(sum > 100){
                throw new ArithmeticException(" Сумма выше 100");
            }
        }

        return sum;
    }
}


public class Printer {
    public static void main(String[] args) {
// Первая попытка: корректный ввод
        try {
            String[] strings = {"10", "20", "70"};
            System.out.println(Answer.convertAndSum(strings));
// Ожидаемый результат: 100
        } catch (NumberFormatException e) {
            System.out.println("Ошибка преобразования строки в число");
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
// Вторая попытка: ввод с некорректным числом
        try {
            String[] invalidStrings = {"10", "20", "abc"};
            System.out.println(Answer.convertAndSum(invalidStrings)); //Ожидаемый результат: исключение NumberFormatException
        } catch (NumberFormatException e) {
            System.out.println("Ошибка преобразования строки в число");
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
// Третья попытка: сумма превышает лимит
        try {
            String[] overLimitStrings = {"50", "60"};
            System.out.println(Answer.convertAndSum(overLimitStrings));
// Ожидаемый результат: исключение ArithmeticException
        } catch (NumberFormatException e) {
            System.out.println("Ошибка преобразования строки в число");
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}