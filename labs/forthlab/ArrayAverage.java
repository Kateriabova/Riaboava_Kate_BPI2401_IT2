package forthlab;

public class ArrayAverage {
    public static void main(String[] args) {
        //String[] arr = {"1.3", "2.2", "3", "4", "5"};
        //String[] arr = {"1", "2", "abc", "4", "5"};
        String[] arr = {};
        double sum = 0;
        try {
            for (int i = 0; i < arr.length; i++) {
                sum += Double.parseDouble(arr[i]); 
            }
            double average = sum / arr.length;
            System.out.println("Среднее арифметическое: " + average);
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: выход за границы массива");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка данных: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Ошибка вычисления: " + e.getMessage());
        }
    }
}