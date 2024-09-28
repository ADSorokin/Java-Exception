/**
 * Задание 1. Проверка корректности даты
 * Напишите приложение, которое будет запрашивать у пользователя следующие
 * данные в произвольном порядке, разделенные пробелом:
 * Фамилия Имя Отчество датарождения номертелефона пол
 * Форматы данных:
 * фамилия, имя, отчество - строки
 * дата_рождения - строка формата dd.mm.yyyy
 * номер_телефона - целое беззнаковое число без форматирования
 * пол - символ латиницей f или m.
 * Приложение должно проверить введенные данные по количеству. Если
 * количество не совпадает с требуемым, вернуть код ошибки, обработать его и
 * показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.
 * Приложение должно попытаться распарсить полученные значения и выделить из
 * них требуемые параметры. Если форматы данных не совпадают, нужно бросить
 * исключение, соответствующее типу проблемы. Можно использовать встроенные
 * типы java и создать свои. Исключение должно быть корректно обработано,
 * пользователю выведено сообщение с информацией, что именно неверно.
 * Если всё введено и обработано верно, должен создаться файл с названием,
 * равным фамилии, в него в одну строку должны записаться полученные данные, вида
 * <Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
 * Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
 * Не забудьте закрыть соединение с файлом.
 * При возникновении проблемы с чтением-записью в файл, исключение должно
 * быть корректно обработано, пользователь должен увидеть стектрейс ошибки.
 * */



import java.io.BufferedWriter;
import java.io.FileWriter;
        import java.io.IOException;
        import java.time.LocalDate;
        import java.time.format.DateTimeFormatter;
        import java.time.format.DateTimeParseException;

        import java.util.Scanner;
        import java.util.regex.Pattern;

public class UserDataApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные: (Фамилия Имя Отчество датарождения номер телефона пол)");

        String input = scanner.nextLine();
        String[] parts = input.split(" ");

        try {
            if (parts.length != 6) {
                throw new IllegalArgumentException("Ошибка: неверное количество данных.");
            }

            String lastName = parts[0];
            String firstName = parts[1];
            String middleName = parts[2];
            String birthDate = parts[3];
            String phoneNumber = parts[4];
            String gender = parts[5];

            String lastNameValid = validateName(lastName);
            String firstNameValid = validateName(firstName);
            String middleNameValid = validateName(middleName);
            LocalDate birthDateValid = validateDataAndConvertToFormat(birthDate);
            Long phoneNumberValid = validatePhoneNumberAndFormat(phoneNumber);
            char genderValid = validateGenderAndFormat(gender);

            writeToFile(lastNameValid, String.format("%s %s %s %s %d %c", lastNameValid,
                    firstNameValid, middleNameValid, birthDateValid, phoneNumberValid, genderValid));

        } catch (IOException ex) {
            System.err.println("Ошибка при записи в файл: " + ex.getMessage());
            ex.printStackTrace();


        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
            e.printStackTrace();

        } finally {
            scanner.close();

        }

    }
    private static String validateName(String name) throws IllegalArgumentException {
        if (!Pattern.compile("^[А-Я][а-я]*$").matcher(name).matches()) {
            throw new IllegalArgumentException("Ошибка: Неверный формат ввода ФИО. " +
                    "Требуется Русский алфавит без букв знаков и цифр первая буква заглавная");
        }
        return name;
    }

    private static LocalDate validateDataAndConvertToFormat(String birthDate) throws IllegalArgumentException,
            DateTimeParseException {
        if (!Pattern.compile("\\d{2}\\.\\d{2}\\.\\d{4}").matcher(birthDate).matches()) {
            throw new IllegalArgumentException("Ошибка: неверный формат даты рождения. Требуется формат dd.mm.yyyy.");
        }
        return LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    private static  Long validatePhoneNumberAndFormat(String phoneNumber) throws IllegalArgumentException {
        if (!Pattern.compile("\\+?\\d+([$\\s\\-]?\\d+[$\\s\\-]?[\\d\\s\\-]+)?").matcher(phoneNumber).matches()) {
            throw new IllegalArgumentException("Ошибка: неверный формат номера телефона.");
        }
        return Long.parseUnsignedLong(phoneNumber.replaceAll("[^0-9]", ""));
    }

    private static char validateGenderAndFormat(String gender) throws IllegalArgumentException {
        if (!gender.equalsIgnoreCase("f") && !gender.equalsIgnoreCase("m")) {
            throw new IllegalArgumentException("Ошибка: неверный символ пола. Должен быть 'f' или 'm'.");
        }
        return gender.toLowerCase().charAt(0);
    }

    private static void writeToFile(String name, String data) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(name + ".txt", true))) {
            writer.write(data + System.lineSeparator());
            writer.flush();

        }



    }
}
