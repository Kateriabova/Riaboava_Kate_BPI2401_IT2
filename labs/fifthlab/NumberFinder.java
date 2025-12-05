package fifthlab;

import java.util.regex.*;

public class NumberFinder {
    public static void main(String[] args){
        try{
            String text = String.join(" ", args);
            Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
            Matcher matcher = pattern.matcher(text);
            System.out.println("Найденные числа: ");
            boolean found = false;
            
            while (matcher.find()) {
                System.out.println(matcher.group());
                found = true;
            }
            
            if (!found) {
                System.out.println("Числа не найдены");
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
