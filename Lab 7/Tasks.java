public class Tasks {
     public static void main(String[] args){
        //declarations
        int mainCount = 0;
        int subCount = 0;
        //Task 1: 0 to 30
        System.out.println("-------Tasks 1-------");
        while (mainCount <= 30){
            System.out.print(mainCount + ", ");
            mainCount++;
        }
        //Task 2: 30 to 0
        System.out.println("\n-------Tasks 2-------");
        mainCount = 30;
        while (mainCount >= 0){
            System.out.print(mainCount + ", ");
            mainCount--;
        }
        //Task 3: 0 to 18 by 3's
        System.out.println("\n-------Tasks 3-------");
        mainCount = 0;
        while (mainCount <= 18){
            System.out.print(mainCount + ", ");
            mainCount = mainCount + 3;
        }
        //Task 4: 10 to 0 by 2's
        System.out.println("\n-------Tasks 4-------");
        mainCount = 10;
        while (mainCount >= 0){
            System.out.print(mainCount + ", ");
            mainCount = mainCount - 2;
        }
        //Task 5: Nested loop grow asterisk tree
        System.out.println("\n-------Tasks 5-------");
        mainCount = 1;
        while (mainCount <= 5){
            //System.out.println("MC" + mainCount);
            subCount = 1;
            while (subCount <= mainCount){
                System.out.print("*");
                //System.out.println("SC" + subCount);
                subCount++;
            }
            mainCount++;
            System.out.print("\n");
        }
        //Task 6: Nested loop shrink asterisk tree
        System.out.println("\n-------Tasks 6-------");
        mainCount = 5;
        while (mainCount >= 0){
            //System.out.println("MC" + mainCount);
            subCount = 1;
            while (subCount <= mainCount){
                System.out.print("*");
                //System.out.println("SC" + subCount);
                subCount++;
            }
            mainCount--;
            System.out.print("\n");
        }
        //Task 7: Nested loop block asterisk
System.out.println("\n-------Tasks 7-------");
        mainCount = 5;
        subCount = 1;
        while (mainCount >= 0){
            //System.out.println("MC" + mainCount);
            while (subCount <= mainCount && mainCount > 0){
                System.out.print("*");
                //System.out.println("SC" + subCount);
                subCount++;
            }
            subCount = subCount - 6;
            mainCount--;
            System.out.print("\n");

        }
     }
}
