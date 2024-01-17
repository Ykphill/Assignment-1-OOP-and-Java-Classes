import java.util.InputMismatchException;
import java.util.Scanner;

// Name: Phillip Bell
// Class: CS 3305/Section 04
// Term: Spring 2024
// Instructor: Dr. Haddad
// Assignment: 1
// IDE Name: Inteli J
public class TestRectangle {
    public static void main(String[] args) {
        //initialize scanner
        Scanner scan = new Scanner(System.in);

        //initialize my width and height
        double width=0;
        double height=0;

        //sentinel value
        boolean sentinel=true;

        //prints out menu so user can input rectangle values
        System.out.print("\nHi! This project can calculate the area and perimeter of any rectangle.\n\n" +
                "please input the attributes of your rectangle\n" +
                "---------------------------------------------\n");

        //Exception handling loop
        do {

            try {
                System.out.print("Width:\t");
                width = scan.nextDouble();

                System.out.print("Height:\t");
                height = scan.nextDouble();
                sentinel=false;
            }//catches any wrong format inputs
            catch (InputMismatchException e){
                System.out.println("PLEASE... only use integers for measurements\n");
                scan.nextLine();
            }

        }while (sentinel);

        //initialize Rectangle object
        Rectangle myRectangle = new Rectangle();
        Rectangle yourRectangle = new Rectangle(width,height);

        //call print method
        myRectangle.printRectangle("myRectangle");
        yourRectangle.printRectangle("yourRectangle");

    }
}