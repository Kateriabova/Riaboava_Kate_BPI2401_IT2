package emailcheck;

public class EmailValidator {
    
    public static void validateEmail(String email) throws CustomEmailFormatException {
        if (email == null || email.trim().isEmpty()) {
            throw new CustomEmailFormatException("Email адрес не может быть пустым");
        }
        if (!email.contains("@")) {
            throw new CustomEmailFormatException("Email должен содержать символ '@'");
        }
        
        String[] parts = email.split("@");
        if (parts.length != 2) {
            throw new CustomEmailFormatException("Некорректный формат email");
        }
        
        String localPart = parts[0];
        String domain = parts[1];
        
        if (localPart.isEmpty()) {
            throw new CustomEmailFormatException("Локальная часть email не может быть пустой");
        }
        
        if (domain.isEmpty()) {
            throw new CustomEmailFormatException("Доменная часть email не может быть пустой");
        }
        
        if (!domain.contains(".")) {
            throw new CustomEmailFormatException("Доменная часть должна содержать точку");
        }
        if (domain.contains("..") || localPart.contains("..")) {
            throw new CustomEmailFormatException("Email не должен содержать две точки подряд");
        }
        if (email.contains(" ")) {
            throw new CustomEmailFormatException("Email не должен содержать пробелы");
        }
        
        if (localPart.startsWith(".") || localPart.endsWith(".")) {
            throw new CustomEmailFormatException("Локальная часть не может начинаться или заканчиваться точкой");
        }
        if (domain.startsWith(".") || domain.endsWith(".")) {
            throw new CustomEmailFormatException("Доменная часть не может начинаться или заканчиваться точкой");
        }
    }
}