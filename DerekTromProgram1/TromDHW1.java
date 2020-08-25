/*
  Derek Trom
  derek.trom@und.edu
  HW1 CSCI 365
 */
import java.util.Random;
public class TromDHW1{
    public static int generateRandomInt(int upperRange){
        Random random = new Random();
        return random.nextInt(upperRange);
    }
    public static int[] fillArray(int []array) {
        for (int i = 0, n = array.length; i < n; i++) {
            array[i] = generateRandomInt(100);
        }
        return array;
    }
    public static void printArray(int[] array){
        int count = 0;
        for (int i = 0, n = array.length; i < n; i++) {
            count++;
            System.out.printf("%3d %3d\n" ,count, array[i]);
        }

    }
    public static int maxOfArray(int[] array){
        int max = array[0];
        for (int i = 0, n = array.length; i < n; i++){
            if (array[i] > max){
                max = array[i];
            }
        }
        return max;
    }
    public static int minOfArray(int[] array){
        int min = array[0];
        for (int i = 0, n = array.length; i < n; i++){
            if (array[i] < min){
                min = array[i];
            }
        }
        return min;
    }
    public static double avgOfArray(int[] array){
        int sum = 0;
        int count = 0;
        for (int i = 0, n = array.length; i < n; i++){
            count++;
            sum += array[i];
        }
        double average = sum/count;

        return average;
    }


    public static void main(String[] args){

        int arrayOfNums[] = new int[20];
        arrayOfNums = fillArray(arrayOfNums);
        int max = maxOfArray(arrayOfNums);
        System.out.println("Max: " + max);
        int min = minOfArray(arrayOfNums);
        System.out.println("Min: "+ min);
        double average = avgOfArray(arrayOfNums);
        System.out.printf("Average = %.2f\n", average);
        System.out.print("Values\n");
        printArray(arrayOfNums);


    }
}