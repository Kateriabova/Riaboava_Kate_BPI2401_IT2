package emailcheck;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("'exit' для выхода");
        
        while (true) {
            System.out.print("\nВведите email для проверки: ");
            String email = scanner.nextLine().trim();
            
            if (email.equalsIgnoreCase("exit")) {
                break;
            }
            
            try {
                EmailValidator.validateEmail(email);
                System.out.println("Email '" + email + "' имеет корректный формат");
                
            } catch (CustomEmailFormatException e) {
                System.out.println("Ошибка: " + e.getMessage());
                ExceptionLogger.logException(e);
            }
        }
        
        scanner.close();
    }
}