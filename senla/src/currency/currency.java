package currency;

import java.util.Scanner;

public class currency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Конвертер валют ===");
        System.out.println("Введите сумму в рублях: ");
        double rubles = scanner.nextDouble();
        
        double dollars = rubles / 82.9;
        double euros = rubles / 98.2;
        double wons = rubles / 0.06;
        double zloty = rubles / 23.1;
        double reals = rubles / 15.6;
        
        System.out.printf("USD: %.2f%n", dollars);
        System.out.printf("EUR: %.2f%n", euros);
        System.out.printf("KRW: %.2f%n", wons);
        System.out.printf("PLN: %.2f%n", zloty);
        System.out.printf("BRL: %.2f%n", reals);
        
        scanner.close();
    }
}