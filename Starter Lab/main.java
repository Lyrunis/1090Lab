public class main{
    static void main(String[] args){
    //int variable declaration
    int intOperandA = 6;
    int intOperandB = 3;
    int intSum;
    int intProduct;
    int intDifference;
    int intQuotient;
    int intModulo;

    //double variable declaration
    double doubleOperandA = 4.2;
    double doubleOperandB = 6.9;
    double doubleSum;
    double doubleProduct;
    double doubleDifference;
    double doubleQuotient;

    //int operations
    intSum =  intOperandA + intOperandB; //sum +
    intProduct = intOperandA * intOperandB; //product *
    intDifference = intOperandA - intOperandB; //difference -
    intQuotient = intOperandA / intOperandB; // quotient -
    intModulo = intOperandA % intOperandB; // modulo %
    
    //double operations
    doubleSum = doubleOperandA + doubleOperandB; //sum +
    doubleProduct = doubleOperandA * doubleOperandB; //product *
    doubleDifference = doubleOperandA - doubleOperandB; //difference -
    doubleQuotient = doubleOperandA % doubleOperandB; //quotient %

    //operations output
    System.out.println("The sum of int " +intOperandA + " and int " +intOperandB + " is: " +intSum);
    System.out.println("The product of int " +intOperandA + " and int " +intOperandB + " is: " +intProduct);
    System.out.println("The difference between int " +intOperandA + " and int " +intOperandB + " is: " +intDifference);
    System.out.println("The quotient between int " +intOperandA + " and int " +intOperandB + " is: " + intQuotient);
    System.out.println("The remainder between int " +intOperandA + " and int " +intOperandB + " is: " + intModulo);
    System.out.println("The sum of double " +doubleOperandA + " and double " +doubleOperandB + " is: " + doubleSum);
    System.out.println("The product of double " +doubleOperandA + " and double " +doubleOperandB + " is: " + doubleProduct);
    System.out.println("The difference between double " +doubleOperandA + " and double " +doubleOperandB + " is: " + doubleDifference);
    System.out.println("The quotient of double " +doubleOperandA + " and double " +doubleOperandB + " is: " + doubleQuotient);

    //part two variable declarations
    int childrenCount = 5;
    boolean rainStatus = true;
    double gasPrice = 3.98;
    int favNum = 3;
    double shoeSize = 10.5;
    int birthMonth = 11;
    String fullName = "Vuong Vu";
    
    }
}