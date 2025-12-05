package fifthlab;
import java.util.regex.*;

public class PasswordValidator {
    public static void main(String[] args){
        try{
            String password = String.join(" ", args);
            Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9]{8,16}$");
            Matcher matcher = pattern.matcher(password);
            if (matcher.matches()) {
                System.out.println("Valid password!");
            } else{
                System.out.println("Invalid password!");
            }
        } catch (PatternSyntaxException e){
            System.out.println("Ошибка в регулярном выражении " + e.getMessage());
        } catch (NullPointerException e){
            System.out.println("Текст не может быть null " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }
    
}
