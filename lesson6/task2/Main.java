package homeworks.lesson6;

import java.util.Random;

public class Main {

    static public void main(String[]args){

         int[] array = new int[10000];
         Random rn = new Random();
         for(int i = 0; i < array.length; i++){
             array[i] = rn.nextInt(10000);
         }

        int[] array2 = array.clone();
        long tstart;
        long tend;

        tstart = System.currentTimeMillis();
        sumCalculate(array);
        tend = System.currentTimeMillis();
        System.out.println((tend - tstart) + "ms");

        tstart = System.currentTimeMillis();
        MultiThreadCulc.culculateSum(array2,10);
        tend = System.currentTimeMillis();
        System.out.println((tend - tstart) + "ms");

    }
    static void sumCalculate(int[] array){
        int sum = 0;

        for(int i = 0; i < array.length; i++){
            sum += array[i];
        }
    System.out.println(sum);
    }
}
