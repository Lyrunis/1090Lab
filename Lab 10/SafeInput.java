import java.util.Scanner;
public class SafeInput {
    /**
    *
    * @param pipe a Scanner opened to read from System.in
    * @param prompt prompt for the user
    * @return a String response that is not zero length
    */
   public static String getNonZeroLenString(Scanner pipe, String prompt)
   {
       String retString = "";
       do
       {
           System.out.print("\n" + prompt + ": ");
           retString = pipe.nextLine();
       }while(retString.length() == 0);

       return retString;

   }


    public static int getInt(Scanner pipe, String prompt) {
        int retInt = 0;
        boolean isValid = false;
        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt()) {
                retInt = pipe.nextInt();
                isValid = true;
            } else {
                String input = pipe.next();
                System.out.println("Invalid input. Please enter an integer.");
            }
            pipe.nextLine();
        } while (!isValid);

        return retInt;
    }

    public static double getDouble(Scanner pipe, String prompt) {
        double retDouble = 0.0;
        boolean isValid = false;
        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble()) {
                retDouble = pipe.nextDouble();
                isValid = true;
            } else {
                String input = pipe.next();
                System.out.println("Invalid input. Please enter a double value.");
            }
            pipe.nextLine();
        } while (!isValid);

        return retDouble;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int retInt = 0;
        boolean isValid = false;
        String fullPrompt = prompt + " [" + low + " - " + high + "]";
        do {
            retInt = getInt(pipe, fullPrompt);
            if (retInt >= low && retInt <= high) {
                isValid = true;
            } else {
                System.out.println("Invalid input. Please enter an integer within the specified range.");
            }
        } while (!isValid);

        return retInt;
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double retDouble = 0.0;
        boolean isValid = false;
        String fullPrompt = prompt + " [" + low + " - " + high + "]";
        do {
            retDouble = getDouble(pipe, fullPrompt);
            if (retDouble >= low && retDouble <= high) {
                isValid = true;
            } else {
                System.out.println("Invalid input. Please enter a double value within the specified range.");
            }
        } while (!isValid);

        return retDouble;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        boolean isValid = false;
        boolean response = false;
        do {
            System.out.print("\n" + prompt + " [Y/N]: ");
            String input = pipe.nextLine().trim().toLowerCase();
            if (input.equals("y") || input.equals("yes")) {
                response = true;
                isValid = true;
            } else if (input.equals("n") || input.equals("no")) {
                response = false;
                isValid = true;
            } else {
                System.out.println("Invalid input. Please enter 'Y' or 'N'.");
            }
        } while (!isValid);

        return response;
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String retString = "";
        boolean isValid = false;
        do {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
            if (retString.matches(regEx)) {
                isValid = true;
            } else {
                System.out.println("Invalid input. Please enter a string that matches the specified pattern.");
            }
        } while (!isValid);

        return retString;
    }

    public static void prettyHeader(String msg) {
        int totalWidth = 60;
        int msgLength = msg.length();
        int padding = (totalWidth - msgLength - 1) / 2;
    
        System.out.println("*****************************************************************");
        System.out.print("***");
        for (int i = 0; i < padding; i++) {
            System.out.print(" ");
        }
        System.out.print(msg);
        for (int i = 0; i < padding + (msgLength % 2); i++) {
            System.out.print(" ");
        }
        System.out.println("***");
        System.out.println("*****************************************************************");
    }
}
