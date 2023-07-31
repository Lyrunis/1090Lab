import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker {

    private static ArrayList<String> myArrList = new ArrayList<>(); // Create a list for storing items
    private static Scanner scanner = new Scanner(System.in); // Scanner for user input

    public static void main(String[] args) {
        boolean quit = false; // A flag to control the main loop
        while (!quit) {
            displayMenu(); // Display the menu options
            String choice = SafeInput.getRegExString(scanner, "Enter your choice (A/D/P/Q):", "[AaDdPpQq]"); // Get user choice
            switch (choice.toUpperCase()) {
                case "A":
                    addItem(); // Call the method to add an item
                    break;
                case "D":
                    deleteItem(); // Call the method to delete an item
                    break;
                case "P":
                    printList(); // Call the method to print the list
                    break;
                case "Q":
                    quit = confirmQuit(); // Call the method to confirm quitting
                    break;
            }
        }
    }

    private static void displayMenu() {
        SafeInput.prettyHeader("Menu"); // Display a fancy header for the menu
        System.out.println("A - Add an item to the list"); // Option A: Add an item
        System.out.println("D - Delete an item from the list"); // Option D: Delete an item
        System.out.println("P - Print the list"); // Option P: Print the list
        System.out.println("Q - Quit the program"); // Option Q: Quit the program
    }

    private static void addItem() {
        String newItem = SafeInput.getNonZeroLenString(scanner, "Enter the item to add"); // Get item from the user
        myArrList.add(newItem); // Add the item to the list
        System.out.println("Item added: " + newItem); // Print a message for the added item
    }

    private static void deleteItem() {
        if (myArrList.isEmpty()) {
            System.out.println("The list is empty."); // Display amessage if the list is empty
            return;
        }
        System.out.println("This is your current items list");
        printList();
        int itemNumber = getValidItemNumber(); // Get a valid item number for deletion
        String removedItem = myArrList.remove(itemNumber - 1); // Remove the item from the list
        System.out.println("Item removed: " + removedItem); // Print a message for the removed item
    }

    private static void printList() {
        if (myArrList.isEmpty()) {
            System.out.println("The list is empty."); // Display a message if the list is empty
            return;
        }

        System.out.println("Current list:"); // Display a message for the current list
        for (int i = 0; i < myArrList.size(); i++) {
            System.out.println((i + 1) + ". " + myArrList.get(i)); // Print each item with a number in front
        }
    }

    private static int getValidItemNumber() {
        int listSize = myArrList.size();
        int itemNumber;
        do {
            itemNumber = SafeInput.getRangedInt(scanner, "Enter the item number to delete", 1, listSize); // Get a valid item number within the list size
        } while (itemNumber < 1 || itemNumber > listSize); // Repeat until a valid number is entered
        return itemNumber; // Return the valid item number
    }

    private static boolean confirmQuit() {
        return SafeInput.getYNConfirm(scanner, "Are you sure you want to quit?"); // Get user confirmation for quitting
    }
}