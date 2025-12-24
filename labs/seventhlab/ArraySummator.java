package seventhlab;

import java.util.Arrays;
import java.util.Scanner;

public class ArraySummator extends Thread {
    private double[] partOfArray;
    private  double s;
    public ArraySummator(double[] array) {
        partOfArray = array;
    }

    @Override
    public void run(){
        for (double elem : partOfArray){
            s += elem;
        }
        System.out.println(s); 
    }

    public double getS(){
        return s;
    }

    public static void main(String[ ] args) throws InterruptedException {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        input = input.trim();
        String[] arr = input.substring(1, input.length() - 1).split(", ");
        double[] nums = new double[arr.length];
        try{
            for (int j = 0; j < arr.length; j++) {
                nums[j] = Double.parseDouble(arr[j].trim()); 
            }
            int len = nums.length;
            ArraySummator thread1 = new ArraySummator(Arrays.copyOfRange(nums, 0, len / 2));
            ArraySummator thread2 = new ArraySummator(Arrays.copyOfRange(nums, len / 2, len));
            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();
            double result1 = thread1.getS();
            double result2 = thread2.getS();
            System.out.println(result1 + result2); 
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка данных: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Ошибка вычисления: " + e.getMessage());
        }
    }
}
