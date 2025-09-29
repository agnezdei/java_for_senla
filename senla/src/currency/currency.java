package currency;

import java.util.Scanner;

class curr {
    private String code;
    private String name;
    private double rateToRub;
    
    public curr(String code, String name, double rateToRub) {
        this.code = code;
        this.name = name;
        this.rateToRub = rateToRub;
    }
    
    public double convertFromRubles(double rubles) {
        return rubles / rateToRub;
    }
    
    public String getCode() { return code; }
    public String getName() { return name; }
}

public class currency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        curr[] currencies = {
            new curr("USD", "Доллар США", 82.9),
            new curr("EUR", "Евро", 98.2),
            new curr("KRW", "Вон", 0.06),
            new curr("PLN", "Злотый", 23.1),
            new curr("BRL", "Реал", 15.6)
        };
        
        System.out.println("=== Конвертер валют ===");
        System.out.println("Введите сумму в рублях: ");
        double rubles = scanner.nextDouble();
        
        System.out.println("\nРезультаты конвертации:");
        
        for (curr currency : currencies) {
            double converted = currency.convertFromRubles(rubles);
            String result = String.format("%s (%s): %.2f", 
                currency.getCode(), currency.getName(), converted);
            System.out.println(result);
        }
        
        scanner.close();
    }
}