package password;

import java.util.Scanner;
import java.util.Random;

public class password {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        System.out.print("Введите длину пароля (8-12): ");
        int length = scanner.nextInt();
        
        if (length < 8) {
            System.out.println("Длина меньше 8. Установлено значение 8.");
            length = 8;
        } else if (length > 12) {
            System.out.println("Длина больше 12. Установлено значение 12.");
            length = 12;
        }
        
        String chars = "abcdefghijklmnopqrstuvwxyz";
        String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        String symbols = "!?,.@#$%^&*";
        
        String all = chars + CHARS + numbers + symbols;
        
        String password = "";

        password += chars.charAt(random.nextInt(chars.length()));
        password += CHARS.charAt(random.nextInt(CHARS.length()));
        password += numbers.charAt(random.nextInt(numbers.length()));
        password += symbols.charAt(random.nextInt(symbols.length()));

        for (int i = 4; i < length; i++) {
            password += all.charAt(random.nextInt(all.length()));
        }
        
        System.out.println("Пароль: " + password);

        scanner.close();
    }
}