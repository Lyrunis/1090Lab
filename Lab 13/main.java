import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class main {

    private static ArrayList<String> itemList = new ArrayList<>();
    private static boolean isListDirty = false;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean shouldQuit = false;

        while (!shouldQuit) {
            displayMenu();
            String choice = SafeInput.getRegExString(scanner, "Enter your choice (A/D/V/O/S/C/Q):", "[AaDdVvOoSsCcqQ]");

            switch (choice.toUpperCase()) {
                case "A":
                    addItem();
                    break;
                case "D":
                    deleteItem();
                    break;
                case "V":
                    viewList();
                    break;
                case "O":
                    openList();
                    break;
                case "S":
                    saveList();
                    break;
                case "C":
                    clearList();
                    break;
                case "Q":
                    shouldQuit = confirmQuit();
                    break;
            }
        }
    }

    private static void displayMenu() {
        SafeInput.prettyHeader("Menu");
        System.out.println("A - Add an item to the list");
        System.out.println("D - Delete an item from the list");
        System.out.println("V - View the list");
        System.out.println("O - Open a list from disk");
        System.out.println("S - Save the list to disk");
        System.out.println("C - Clear the list");
        System.out.println("Q - Quit the program");
    }

    private static void addItem() {
        String newItem = SafeInput.getNonZeroLenString(scanner, "Enter the item to add");
        itemList.add(newItem);
        isListDirty = true;
        System.out.println("Item added: " + newItem);
    }

    private static void deleteItem() {
        if (itemList.isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }
        System.out.println("This is your current items list");
        viewList();
        int itemNumber = getValidItemNumber();
        String removedItem = itemList.remove(itemNumber - 1);
        isListDirty = true;
        System.out.println("Item removed: " + removedItem);
    }

    private static void viewList() {
        if (itemList.isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }

        System.out.println("Current list:");
        for (int i = 0; i < itemList.size(); i++) {
            System.out.println((i + 1) + ". " + itemList.get(i));
        }
    }

    private static void openList() {
        if (isListDirty) {
            System.out.println("You have unsaved changes. Do you want to save before opening a new list? (Y/N)");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("Y")) {
                saveList();
            }
        }

        String filename = SafeInput.getNonZeroLenString(scanner, "Enter the filename to open (without extension):");
        filename += ".txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            itemList.clear();
            String line;
            while ((line = reader.readLine()) != null) {
                itemList.add(line);
            }
            System.out.println("List loaded from " + filename);
            isListDirty = false;
        } catch (IOException e) {
            System.out.println("Error loading the list from " + filename);
        }
    }

    private static void saveList() {
        if (itemList.isEmpty()) {
            System.out.println("The list is empty. Nothing to save.");
            return;
        }

        String filename = SafeInput.getNonZeroLenString(scanner, "Enter the filename to save (without extension):");
        filename += ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String item : itemList) {
                writer.write(item);
                writer.newLine();
            }
            System.out.println("List saved to " + filename);
            isListDirty = false;
        } catch (IOException e) {
            System.out.println("Error saving the list to " + filename);
        }
    }

    private static void clearList() {
        itemList.clear();
        System.out.println("List cleared.");
        isListDirty = true;
    }

    private static int getValidItemNumber() {
        int listSize = itemList.size();
        int itemNumber;
        do {
            itemNumber = SafeInput.getRangedInt(scanner, "Enter the item number to delete", 1, listSize);
        } while (itemNumber < 1 || itemNumber > listSize);
        return itemNumber;
    }

    private static boolean confirmQuit() {
        if (isListDirty) {
            System.out.println("You have unsaved changes. Do you want to save before quitting? (Y/N)");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("Y")) {
                saveList();
            }
        }
        return SafeInput.getYNConfirm(scanner, "Are you sure you want to quit?");
    }
}