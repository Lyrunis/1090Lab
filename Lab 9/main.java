import java.util.Random;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] dataPoints = new int[100];

        Random rnd = new Random();
        for (int i = 0; i < dataPoints.length; i++) { //goes through each index in array and assigns random values
            dataPoints[i] = rnd.nextInt(100) + 1;
        }


        for (int i = 0; i < dataPoints.length; i++) { //Prints each index
            System.out.print(dataPoints[i]);
            if (i != dataPoints.length - 1) {
                System.out.print(" | ");
            }
        }
        System.out.println();

        //Average Calculations
        int sum = 0;
        for (int value: dataPoints) {
            sum += value;
        }
        double average = (double) sum / dataPoints.length;
        System.out.println("The sum of the random array dataPoints is: " + sum);
        System.out.println("The average of the random array dataPoints is: " + average);

        int userValue = SafeInput.getRangedInt(in, "Enter a value between 1 and 100: ", 1, 100);

        int count = 0;
        for (int value : dataPoints) {
            if (value == userValue) {
                count++;
            }
        }
        System.out.println("The value was found " + count + " times in the array.");

    //user specified value finder
        userValue = SafeInput.getRangedInt(in, "Enter a value between 1 and 100: ", 1, 100);
        int position = -1; //pos initial (-1 + 1)
        for (int i = 0; i < dataPoints.length; i++) {
            if (dataPoints[i] == userValue) {
                position = i;
                break; // Exit if val found
            }
        }
        if (position != -1) {
            System.out.println("The value " + userValue + " was found at array index " + position + ".");
        } else {
            System.out.println("The value " + userValue + " was not found in the array.");
        }

        //array min max
        int min = dataPoints[0];
        int max = dataPoints[0];
        for (int i = 1; i < dataPoints.length; i++) {
            if (dataPoints[i] < min) {
                min = dataPoints[i];
            }
            if (dataPoints[i] > max) {
                max = dataPoints[i];
            }
        }
        System.out.println("The min value in dataPoints is: " + min);
        System.out.println("The max value in dataPoints is: " + max);

        // avg through static call
        System.out.println("Average of dataPoints is: " + getAverage(dataPoints));
    }

    // static average function
    public static double getAverage(int[] values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return (double) sum / values.length;
    }
}