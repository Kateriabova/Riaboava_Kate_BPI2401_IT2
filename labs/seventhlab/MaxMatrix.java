package seventhlab;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MaxMatrix {
    public static volatile double max;

    public static void main(String[] args) throws InterruptedException {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine().trim();
        String[] arrs = input.split("],");
        String[] firstElem = arrs[0].split(",");
        double[][] matrix = new double[arrs.length][firstElem.length];
        try{
            for (int i = 0; i < arrs.length; i ++){
                arrs[i] = arrs[i].trim().substring(1);
                int n = arrs[i].length();
                if (i == 0){
                arrs[i] = arrs[i].substring(1);
                n -= 1;
                } if (i == arrs.length - 1){
                    arrs[i] = arrs[i].substring(0, n - 2);
                    n -= 2;
                }
                String[] arr = arrs[i].trim().split(",");
                double[] nums = new double[arr.length];
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j].trim().equals("")){
                        nums[j] = 0;
                    } else{
                        nums[j] = Double.parseDouble(arr[j].trim());
                    }  
                }
                matrix[i] = nums;
            }
            s.close();
            ExecutorService executor = Executors.newFixedThreadPool(matrix.length);
            max = matrix[0][0];
            for (double[] line : matrix) { 
                executor.execute(() -> {
                    for (double elem : line){
                        updateMax(elem);
                    }
                });
            }
            executor.shutdown();
            while (!executor.isTerminated()) {
                Thread.sleep(10);
            }
            System.out.println(max);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка данных: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Ошибка вычисления: " + e.getMessage());
        }
    }

    public static synchronized void updateMax(double value) {
        if (value > max) {
            max = value;
        }
    }
}
