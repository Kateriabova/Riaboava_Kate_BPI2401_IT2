package sixthlab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TopWord {
    public static void main(String[] args) {
        // указываем путь к файлу
        String filePath = "text.txt";
        
        // создаем объект File
        File file = new File(filePath);
        
        // создаем объект Scanner для чтения файла
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }
        
        // создаем объект Map для хранения слов и их количества
        Map<String, Integer> wordCountMap = new HashMap<>();
        
        // читаем файл по словам и добавляем их в Map
        while (scanner.hasNext()) {
            String word = scanner.next().toLowerCase().replaceAll("^[^a-zA-Zа-яА-Я']+|[^a-zA-Zа-яА-Я']+$", ""); // удаляем все символы, не являющиеся буквами и апострофами в начале и конце
            if (!word.isEmpty()) {
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
        }
        
        // закрываем Scanner
        scanner.close();
        
        // создаем список из элементов Map
        List<Map.Entry<String, Integer>> list = new ArrayList<>(wordCountMap.entrySet());
        
        // сортируем список по убыванию количества повторений
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue()); // сортировка по убыванию
            }
        });
    
        System.out.println("Топ-10 самых часто встречающихся слов:");
        
        // выводим результат
        int count = 0;
        for (Map.Entry<String, Integer> entry : list) {
            if (count < 10) {
                System.out.println((count + 1) + ". " + entry.getKey() + " - " + entry.getValue() + " раз(а)");
                count++;
            } else {
                break;
            }
        }
    }
}
