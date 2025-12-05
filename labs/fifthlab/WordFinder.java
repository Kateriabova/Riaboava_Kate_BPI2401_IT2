package fifthlab;
import java.util.regex.*;
import java.util.Arrays;

public class WordFinder {
    public static void main(String[] args) {
        try {
            String letter = args[0];
            String text = String.join(" ", Arrays.copyOfRange(args, 1, args.length));
            if (!letter.matches("[a-zA-Zа-яА-Я]")) {
                System.out.println("Первый параметр должен быть буквой");
                return;
            }
            Pattern pattern = Pattern.compile("\\b(?i)" + letter + "[a-zA-Zа-яА-Я]*\\b");
            Matcher matcher = pattern.matcher(text);
            System.out.println("Слова, начинающиеся с буквы '" + letter + "': ");
            boolean found = false;
            while (matcher.find()) {
                System.out.println(matcher.group());
                found = true;
            }
            if (!found) {
                System.out.println("Слова не найдены");
            }
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Текст не найден " + e.getMessage());
        }catch (PatternSyntaxException e){
            System.out.println("Ошибка в регулярном выражении " + e.getMessage());
        } catch (NullPointerException e){
            System.out.println("Параметр не может быть null " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }
}
