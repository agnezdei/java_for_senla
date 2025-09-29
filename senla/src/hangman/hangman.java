package hangman;

import java.util.Scanner;
import java.util.Random;

class HangmanGame {
    private String secretWord;
    private char[] guessedLetters;
    private int remainingLives;
    private String usedLetters;
    
    public HangmanGame() {
        String[] wordList = {"ВАМПИР", "ТРЕЗУБЕЦ", "ЭКСПЕРИМЕНТ", "ОГНЕТУШИТЕЛЬ", "ПРИБОЙ"};
        
        Random random = new Random();
        this.secretWord = wordList[random.nextInt(wordList.length)];
        this.guessedLetters = new char[secretWord.length()];
        
        for (int i = 0; i < guessedLetters.length; i++) {
            guessedLetters[i] = '_';
        }
        
        this.remainingLives = 6;
        this.usedLetters = "";
    }
    
    public boolean guessLetter(char letter) {

        letter = Character.toUpperCase(letter);
        
        if (usedLetters.indexOf(letter) != -1) {
            System.out.println("Вы уже использовали букву '" + letter + "'");
            return false;
        }
        
        usedLetters += letter;
        boolean found = false;
        
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == letter) {
                guessedLetters[i] = letter;
                found = true;
            }
        }
        
        if (!found) {
            remainingLives--;
        }
        
        return found;
    }
    
    public boolean isWordGuessed() {
        return new String(guessedLetters).equals(secretWord);
    }
    
    public boolean isGameOver() {
        return remainingLives <= 0;
    }
    
    public String getGuessedWord() {
        String result = "";
        for (char c : guessedLetters) {
            result += c + " ";
        }
        return result;
    }
    
    public int getRemainingLives() {
        return remainingLives;
    }
    
    public String getUsedLetters() {
        return usedLetters;
    }
    
    public String getSecretWord() {
        return secretWord;
    }
}

class HangmanDrawer {
    public static void drawHangman(int lives) {
        String[] stages = {
            """
              ____
              |  |
                 |
                 |
                 |
                 |
            _____|___
            """,
            """
              ____
              |  |
              O  |
                 |
                 |
                 |
            _____|___
            """,
            """
              ____
              |  |
              O  |
              |  |
                 |
                 |
            _____|___
            """,
            """
              ____
              |  |
              O  |
             /|  |
                 |
                 |
            _____|___
            """,
            """
              ____
              |  |
              O  |
             /|\\ |
                 |
                 |
            _____|___
            """,
            """
              ____
              |  |
              O  |
             /|\\ |
             /   |
                 |
            _____|___
            """,
            """
              ____
              |  |
              O  |
             /|\\ |
             / \\ |
                 |
            _____|___
            """
        };
        
        System.out.println(stages[6 - lives]);
    }
}

public class hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        HangmanGame game = new HangmanGame();
        
        System.out.println("=== ИГРА 'ВИСЕЛИЦА' ===");
        System.out.println("Угадайте слово по буквам!");
        
        while (!game.isGameOver() && !game.isWordGuessed()) {
            System.out.println("\n" + "=".repeat(30));
            
            HangmanDrawer.drawHangman(game.getRemainingLives());
            System.out.println("\nСлово: " + game.getGuessedWord());
            System.out.println("Осталось попыток: " + game.getRemainingLives());
            System.out.println("Использованные буквы: " + game.getUsedLetters());
            
            System.out.print("Введите букву: ");
            String input = scanner.nextLine();
            
            if (input.length() != 1) {
                System.out.println("Пожалуйста, введите одну букву!");
                continue;
            }
            
            char letter = input.charAt(0);

            if (!Character.isLetter(letter)) {
                System.out.println("Пожалуйста, введите букву!");
                continue;
            }
            
            game.guessLetter(letter);
        }
        
        System.out.println("\n" + "=".repeat(30));
        HangmanDrawer.drawHangman(game.getRemainingLives());
        
        if (game.isWordGuessed()) {
            System.out.println("\n Да! Вы угадали слово: " + game.getSecretWord());
        } else {
            System.out.println("\n💀 GAME OVER! Загаданное слово было: " + game.getSecretWord());
        }
        
        scanner.close();
    }
}