package seventhlab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MaxMatrix2 {
    public static ArrayList<Double> maxArray = new ArrayList<>();

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
            double max = matrix[0][0];
            for (int i = 0; i < matrix.length; i ++){
                maxArray.add(max);
            }
            for (int i = 0; i < matrix.length; i ++) { 
                double[] line = matrix[i];
                final int row = i;
                executor.execute(() -> {
                    for (double elem : line){
                        if (elem > maxArray.get(row)){
                            maxArray.set(row, elem);
                        }
                    }
                });
            }
            executor.shutdown();
            while (!executor.isTerminated()) {
                Thread.sleep(10);
            }
            System.out.println(Collections.max(maxArray));
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка данных: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Ошибка вычисления: " + e.getMessage());
        }
    }
}
