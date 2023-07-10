import java.util.Scanner;

public class MainB{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

      //Birth Month Selection
      System.out.println("Please enter the value of your birth month [1-12]");
      int birthMonth = in.nextInt();

      //Validity checker
      if(birthMonth >= 1 && birthMonth <= 12){
        System.out.println("Your birth month is " + birthMonth);
      }
      else{
        System.out.println("You entered an incorrect month value: " + birthMonth);
      }
    }
}