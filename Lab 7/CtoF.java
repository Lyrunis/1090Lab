import java.util.Scanner;

public class CtoF{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        //Temperature inputs
        System.out.println("Please enter a temperature in celsius: ");
        double tempF;
        boolean tempBool;

        //variable checker
        do{
            tempBool = false; //sets tempBool to false for initial test
            try{
                double tempC = in.nextDouble(); //input for temperature
                //temp conversion math
                tempF = ((9 * tempC) / 5) + 32;
                //conversion output
                System.out.println("Temperature: " + tempC + " Celsius, is " + tempF + " degrees in Fehrenheit.");
                tempBool = false; //do while breaker
            }
            catch (Exception e){ //exeption handler
                tempBool = true;
                System.out.println("Wrong input detected, try again. \nInput a temperature in celsius: ");
                in.next(); //re input
            }
        }
        while (tempBool);
        }
    }