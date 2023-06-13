import java.util.Scanner;

public class MainC{
    public static void main(String[] args){
      Scanner in = new Scanner(System.in);

      //Party Affiliation
      System.out.println("What is your party? [D: Democrat] [R: Republican] [I: independent]");
      String partyStr = in.nextLine();
      partyStr = partyStr.toUpperCase();

      //Output Party Message
      if(partyStr.contains("D")){
        System.out.println("\nYou get a Democratic Donkey");
      }
      else if(partyStr.contains("R")){
        System.out.println("\nYou get a Republican Elephant");
    }
      else if (partyStr.contains("I")){
        System.out.println("\nYou get an Independent Person");
      }
      else{
        System.out.println("\nYou have chosen another party not listed. No stickers for you.");
      }
    }
  }
