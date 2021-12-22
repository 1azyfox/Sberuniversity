import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {
        final double ROUBLES_PER_POUND = 85.08; // курс 1 фунта стерлингов Соединенного Королевства
        BigInteger pounds; // сумма денег в фунтах стерлингов Соединенного Королевства
        BigInteger roubles; // сумма денег в российских рублях
        int n; // количество необходимых конвертаций
        String wordPoundInRussian;

        for (; ; ) {
            Scanner inputN = new Scanner(System.in);
            try {
                System.out.println("Введите корректное необходимое количество конвертаций:");
                n = inputN.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.print("Неверный ввод. ");
            }
        }
        while (n != 0) {
            for (; ; ) {
                Scanner inputPounds = new Scanner(System.in);
                try {
                    System.out.println("Введите, сколько фунтов стерлингов Соединенного Королевства с точностью до целого хотите перевести в рубли:");
                    pounds = inputPounds.nextBigInteger();
                    break;
                } catch (InputMismatchException e) {
                    System.out.print("Неверный ввод. ");
                }
            }

            BigInteger lastDigitOfPounds = pounds.remainder(BigInteger.valueOf(10));
            if (lastDigitOfPounds.compareTo(BigInteger.ONE) == 0) {
                wordPoundInRussian = "фунт";
            } else if (lastDigitOfPounds.compareTo(BigInteger.valueOf(2)) == 0 || lastDigitOfPounds.compareTo(BigInteger.valueOf(3)) == 0 || lastDigitOfPounds.compareTo(BigInteger.valueOf(4)) == 0) {
                wordPoundInRussian = "фунтa";
            } else {
                wordPoundInRussian = "фунтов";
            }
            roubles = ((pounds.multiply(BigInteger.valueOf((long) (ROUBLES_PER_POUND * 100)))).add(BigInteger.valueOf(100)).divide(BigInteger.valueOf(100)));
            System.out.println(pounds + " " + wordPoundInRussian + " " + "стерлингов Соединенного Королевства равно " + roubles + " рублей");
            n--;
        }
    }
}
