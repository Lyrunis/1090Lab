import java.util.Scanner;

public class MainA{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        //Item Price Input
        System.out.println("Please enter item price: ");
        double itemPrice = in.nextDouble();

        //Other variable declarations
        double totalCost = 0;
        double shippingCost = 0;

        //Calculations
        if (itemPrice >= 100){
            shippingCost = 0;
            totalCost = itemPrice + shippingCost;
        }
        else if (itemPrice < 100 && itemPrice > 0){
            shippingCost = itemPrice * 0.02;
            totalCost = itemPrice + shippingCost;
        }
        else{
            System.out.println("\n Invalid item price: " + itemPrice);
        }

        //print statement
        System.out.println("Shipping cost of item is " + shippingCost + ". Total cost is " + totalCost);
    }
}