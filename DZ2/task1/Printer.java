package task1;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class DateValidator {
        public static String validateDate(String date) {
            // ������������� ������ ����
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateFormat.setLenient(false);

            try {

                Date dateObj = dateFormat.parse(date);

                if (isDateInRange(dateObj, dateFormat)) {
                    return "���������� ����: " + date;
                } else {
                    return "������: ���� ��� ����������� ���������";
                }

            } catch (ParseException e) {
                return "������: ������������ ������ ����";
            }
        }

        private static boolean isDateInRange(Date date, SimpleDateFormat dateFormat) {
            try {
                Date minDate = dateFormat.parse("0001-01-01");
                Date maxDate = dateFormat.parse("9999-12-31");
                int yearObj =date.getYear();
                System.out.println("����������� ��� : " + isLeapYear(yearObj));
                return !date.before(minDate) && !date.after(maxDate);

            } catch (ParseException e) {

                return false;
            }
        }

        private static boolean isLeapYear(int year) {
            return (year % 4 == 0 && year % 100 != 0) || (year % 400 ==
                    0);
        }
    }
    public class Printer {
        public static void main(String[] args) {
            String date;
            if (args.length > 0) {
                date = args[0];
            } else {
                date = "2026-05-29"; // �������� �� ���������
            }
            String result = DateValidator.validateDate(date);
            System.out.println(result);
        }

}
