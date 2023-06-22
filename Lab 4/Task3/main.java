public class main{
    public static void main(String[] args){
        //variable declaration
        double iniBalance = 5000;
        double interestRate = 1.17;
        double dueBalance = iniBalance;

        for(int i = 1; i < 3; i++) {
            dueBalance = dueBalance * interestRate;
            System.out.println("Total balance after " + i + " month(s): " + dueBalance);
        }
    }
}