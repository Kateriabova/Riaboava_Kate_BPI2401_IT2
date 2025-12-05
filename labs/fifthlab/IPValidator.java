package fifthlab;
import java.util.regex.*;

public class IPValidator {
    public static void main(String[] args){
        try {
            String ip = String.join(" ", args);
            Pattern pattern = Pattern.compile("^((25[0-5]|2[0-4][0-9]|1?[1-9]?[0-9]|10[0-9])\\.){3}(25[0-5]|2[0-4][0-9]|1?[0-9]?[0-9])$");
            Matcher matcher = pattern.matcher(ip);
            if (matcher.matches()) {
                System.out.println("Valid ip!");
            } else{
                System.out.println("Invalid ip!");
            }
        } catch (PatternSyntaxException e){
            System.out.println("Ошибка в регулярном выражении " + e.getMessage());
        } catch (NullPointerException e){
            System.out.println("Параметр не может быть null " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }
    
}
