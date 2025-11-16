package hashtable;

public class Main {
 public static void main(String[] args) {
  HashTable<String, Integer> bookRatings = new HashTable<>();

  bookRatings.put("Война и мир", 6);
  bookRatings.put("Властелин Колец", 9);
  bookRatings.put("Медвежий Угол", 10);
  bookRatings.put("1984", 8);
  bookRatings.put("Гарри Поттер", 9);
  
  System.out.println("Рейтинг 'Медвежий Угол': " + bookRatings.get("Медвежий Угол"));
  System.out.println("Рейтинг 'Гарри Поттер': " + bookRatings.get("Гарри Поттер"));
  System.out.println("Всего книг: " + bookRatings.size());
  
  System.out.println("Старый рейтинг 'Гарри Поттер': " + bookRatings.get("Гарри Поттер"));
  bookRatings.put("Гарри Поттер", 10);
  System.out.println("Новый рейтинг 'Гарри Поттер': " + bookRatings.get("Гарри Поттер"));
  
  bookRatings.remove("1984");
  System.out.println("'1984' после удаления: " + bookRatings.get("1984"));
  System.out.println("Книг после удаления: " + bookRatings.size());
  
  HashTable<String, String> bookAuthors = new HashTable<>();
  
  bookAuthors.put("Война и мир", "Лев Толстой");
  bookAuthors.put("Властелин Колец", "Джон Рональд Руэл Толкин");
  bookAuthors.put("Медвежий Угол", "Фредрик Бакман");
  bookAuthors.put("1984", "Джордж Оруэлл");
  
  System.out.println("Автор 'Властелин Колец': " + bookAuthors.get("Властелин Колец"));
  System.out.println("Автор '1984': " + bookAuthors.get("1984"));

  System.out.println("Автор 'Гарри Поттер': " + bookAuthors.get("Гарри Поттер"));
 }
}
