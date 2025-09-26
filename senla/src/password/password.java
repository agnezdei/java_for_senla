package password;

import java.util.Scanner;
import java.security.SecureRandom;

public class password {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
        
    System.out.println("Введите желаемую длину пароля(от 8 до 12): ");
    int length = scanner.nextInt();
    if (length < 8) {
        System.out.println("Ошибка! Длина меньше допустимой. Установлена длина 8.");
        length = 8;
        }
    else if (length > 12) {
        System.out.println("Ошибка! Длина больше допустимой. Установлена длина 12.");
        length = 12;
        }

    String result = generatePassword(length);
    System.out.println("Ваш пароль: " + result);
    }

    public static String generatePassword(int length) {
    String lowercase = "abcdefghijklmnopqrstuvwxyz";
    String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String digits = "0123456789";
    String special = "!@#$%^&*()-_=+[]{}|;:,.<>?";

    String allcharacters = lowercase + uppercase + digits + special;

    SecureRandom random = new SecureRandom();
    StringBuilder password = new StringBuilder();

    // Гарантируем наличие хотя бы одного символа из каждой категории
        password.append(lowercase.charAt(random.nextInt(lowercase.length())));
        password.append(uppercase.charAt(random.nextInt(uppercase.length())));
        password.append(digits.charAt(random.nextInt(digits.length())));
        password.append(special.charAt(random.nextInt(special.length())));
        
        // Заполняем оставшуюся часть пароля
        for (int i = 4; i < length; i++) {
            password.append(allcharacters.charAt(random.nextInt(allcharacters.length())));
        }
        
        // Перемешиваем символы для устранения предсказуемости
        return shuffleString(password.toString(), random);
    }
    
    // Метод для перемешивания символов в строке
    private static String shuffleString(String input, SecureRandom random) {
        char[] characters = input.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            int randomIndex = random.nextInt(characters.length);
            char temp = characters[i];
            characters[i] = characters[randomIndex];
            characters[randomIndex] = temp;
        }
        return new String(characters);
    }
}