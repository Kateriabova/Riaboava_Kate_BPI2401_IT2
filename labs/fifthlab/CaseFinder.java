package fifthlab;
import java.util.regex.*;
public class CaseFinder {
    public static void main(String[] args){
        try {
            String text = String.join(" ", args);
            Pattern pattern = Pattern.compile("[a-z][A-Z]");
            Matcher matcher = pattern.matcher(text);
            String result = matcher.replaceAll("!$0!");
            System.out.println(result);
        } catch (PatternSyntaxException e){
            System.out.println("Ошибка в регулярном выражении " + e.getMessage());
        } catch (NullPointerException e){
            System.out.println("Текст не может быть null " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }
    
}
