import java.util.InputMismatchException;
import java.util.Scanner;

// Name: Phillip Bell
// Class: CS 3305/Section 04
// Term: Spring 2024
// Instructor: Dr. Haddad
// Assignment: 1
// IDE Name: Inteli J

public class TestTemps {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int temp[]=new int[7];
        boolean sentinal=false; //act as a sentinel value

        System.out.println("\nHi, Please enter the temperature for the days of the week");
        System.out.println("----------------------------------------------------------");

        //exception loop
        do {


            try {
                //count=0;
                //iterates through the days and allows user to set the temp
                for (int i = 0; i < temp.length; i++) {
                    sentinal=false;
                    //prints out all the days and takes in the temperature and if/else alighns days spacing
                    if (i == 0 || i == 4 || i == 6) {
                        System.out.print(indexToDay(i) + ":\t\t");
                        temp[i] = scan.nextInt();

                    } else {
                        System.out.print(indexToDay(i) + ":\t");
                        temp[i] = scan.nextInt();
                    }

                }
            } catch (InputMismatchException e) {
                System.out.println("Please only input intergers");
                scan.nextLine();
                sentinal = true;
            }

        }while (sentinal);

        DailyTemps dailyTemps = new DailyTemps(temp);
        int choice=99;

        while (choice!=0){

            choice = selector();

            //calls a method based off the selector method
            if (choice==1){
                dailyTemps.printTemps();
            }
            if (choice==2){
                dailyTemps.warmest();
            }
            if (choice==3){
                dailyTemps.freezing();
            }
            if (choice==4){
                dailyTemps.setTemp();
            }
            else if(choice> 4||0>choice){
                System.out.print("\n"+choice+" is was not one of the options. please select from options below.");
            }
        }


    }

    //Changes Indexes to days
    public static String indexToDay(int index){

        //returns day based off index given
        switch (index){
            case 0:
                return "Monday";
            case 1:
                return "Tuesday";
            case 2:
                 return  "Wednesday";
            case 3:
                return  "Thursday";
            case 4:
                return  "Friday";
            case 5:
                return  "Saturday";
            case 6:
                return  "Sunday";
        }
        return "null";
    }

    //prints out menu and reads the user selected choice
    public static int selector(){

        Scanner scan = new Scanner(System.in);
        boolean sentinal=false; //act as a sentinel value

        //exception loop
        do {
            sentinal=false;
            try {

                sentinal=true;
                System.out.println("\nMenu\n" +
                        "----\n" +
                        "1) Print out the weeks daily temperatures\n" +
                        "2) Print the warmest day\n" +
                        "3) Print the days below freezing\n" +
                        "4) change a day's temp\n\n" +
                        "0) Quit program");

                return scan.nextInt();
            }
            catch(InputMismatchException e){
                System.out.print("\nPlease only input intergers");
                sentinal=true;
                scan.nextLine();
            }

        }while (sentinal);

        //return statement to fulfill method requirement
        return scan.nextInt();
    }
}
