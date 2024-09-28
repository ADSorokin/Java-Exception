/**
 * ������� 1. �������� ������������ ����
 * �������� ����������, ������� ����� ����������� � ������������ ���������
 * ������ � ������������ �������, ����������� ��������:
 * ������� ��� �������� ������������ ������������� ���
 * ������� ������:
 * �������, ���, �������� - ������
 * ����_�������� - ������ ������� dd.mm.yyyy
 * �����_�������� - ����� ����������� ����� ��� ��������������
 * ��� - ������ ��������� f ��� m.
 * ���������� ������ ��������� ��������� ������ �� ����������. ����
 * ���������� �� ��������� � ���������, ������� ��� ������, ���������� ��� �
 * �������� ������������ ���������, ��� �� ���� ������ � ������ ������, ��� ���������.
 * ���������� ������ ���������� ���������� ���������� �������� � �������� ��
 * ��� ��������� ���������. ���� ������� ������ �� ���������, ����� �������
 * ����������, ��������������� ���� ��������. ����� ������������ ����������
 * ���� java � ������� ����. ���������� ������ ���� ��������� ����������,
 * ������������ �������� ��������� � �����������, ��� ������ �������.
 * ���� �� ������� � ���������� �����, ������ ��������� ���� � ���������,
 * ������ �������, � ���� � ���� ������ ������ ���������� ���������� ������, ����
 * <�������><���><��������><������������> <�������������><���>
 * ������������ ������ ���������� � ���� � ��� �� ����, � ��������� ������.
 * �� �������� ������� ���������� � ������.
 * ��� ������������� �������� � �������-������� � ����, ���������� ������
 * ���� ��������� ����������, ������������ ������ ������� ��������� ������.
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
        System.out.println("������� ������: (������� ��� �������� ������������ ����� �������� ���)");

        String input = scanner.nextLine();
        String[] parts = input.split(" ");

        try {
            if (parts.length != 6) {
                throw new IllegalArgumentException("������: �������� ���������� ������.");
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

            writeToFile(lastNameValid, String.format("%s %s %s %s %d %c", lastNameValid, firstNameValid, middleNameValid, birthDateValid, phoneNumberValid, genderValid));

        } catch (Exception e) {
            System.err.println("������: " + e.getMessage());
            e.printStackTrace();

        } finally {
            scanner.close();

        }
    }

    private static String validateName(String name) throws IllegalArgumentException {
        if (!Pattern.compile("^[�-�][�-�]*$").matcher(name).matches()) {
            throw new IllegalArgumentException("������: �������� ������ ����� ���. ��������� ������� ������� ��� ���� ������ � ���� ������ ����� ���������");
        }
        return name;
    }

    private static LocalDate validateDataAndConvertToFormat(String birthDate) throws IllegalArgumentException, DateTimeParseException {
        if (!Pattern.compile("\\d{2}\\.\\d{2}\\.\\d{4}").matcher(birthDate).matches()) {
            throw new IllegalArgumentException("������: �������� ������ ���� ��������. ��������� ������ dd.mm.yyyy.");
        }
        return LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    private static Long validatePhoneNumberAndFormat(String phoneNumber) throws IllegalArgumentException {
        if (!Pattern.compile("\\+?\\d+([$$\\s\\-]?\\d+[$$\\s\\-]?[\\d\\s\\-]+)?").matcher(phoneNumber).matches()) {
            throw new IllegalArgumentException("������: �������� ������ ������ ��������.");
        }
        return Long.parseUnsignedLong(phoneNumber.replaceAll("[^0-9]", ""));
    }

    private static char validateGenderAndFormat(String gender) throws IllegalArgumentException {
        if (!gender.equalsIgnoreCase("f") && !gender.equalsIgnoreCase("m")) {
            throw new IllegalArgumentException("������: �������� ������ ����. ������ ���� 'f' ��� 'm'.");
        }
        return gender.toLowerCase().charAt(0);
    }

    private static void writeToFile(String name, String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(name + ".txt", true))) {
            writer.write(data + System.lineSeparator());
            writer.flush();

        } catch (IOException ex) {
            System.err.println("������ ��� ������ � ����: " + ex.getMessage());
            ex.printStackTrace();
        }



    }
}
