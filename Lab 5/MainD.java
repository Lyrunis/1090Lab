import java.util.Scanner;

public class MainD{
    public static void main(String[] args){
      Scanner in = new Scanner(System.in);

      //Age input
      System.out.println("Please enter your age: ");
      int age = in.nextInt();

      //Age checker
      if(age >= 21){
        System.out.println("\nYOU GET A WRIST BAND");
      }
    }
  }
