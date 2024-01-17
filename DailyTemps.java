import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

// Name: Phillip Bell
// Class: CS 3305/Section 04
// Term: Spring 2024
// Instructor: Dr. Haddad
// Assignment: 1
// IDE Name: Inteli J
public class DailyTemps {

    // store the  temperature for each day of the week
    //array index 0 represents Monday’s temperature; array index 1 represents Tuesday’s temperature; etc
   private int[] temp = new int[7];

    //constructor takes in temps and set them to day in the array
    DailyTemps(int[] temp){
        //loops through array and assigns a temperature

        for (int i = 0; i < temp.length; i++) {
            this.temp[i]=temp[i];
        }

    }


    //sets the temp for an  individual day
    public void setTemp() {
        Scanner scan = new Scanner(System.in);

        int index=0;
        int newTemp=0;
        boolean sentinel=true;
        //sentinel loop for exception
        do{
        do {

            try {


                //request user input of the day they wish to change and temp
                System.out.print("\nWhat day:\t");
                index = dayToIndex(scan.next());
                System.out.print("What temp:\t");
                newTemp = scan.nextInt();
                scan.nextLine();
                sentinel=false;
            }//catch exceptions when temp is not int
            catch (InputMismatchException e){
                System.out.println("Incorrect input, please enter ints for temperature");
                scan.nextLine();
                sentinel=true;
            }
        }
        while (sentinel);





            try {
                this.temp[index] = newTemp;
                sentinel=false;
            }//catch exceptions when user enter anything not a day week
            catch (ArrayIndexOutOfBoundsException i) {
                System.out.println("Incorrect input, please enter Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday ");
                sentinel = true;

            }


        }while (sentinel);

    }

    //Changes days to ints so that it can be used as an index
    public int dayToIndex(String day){
        
        switch (day.toLowerCase(Locale.ROOT)){
            case "monday":
                return 0;
            case "tuesday":
                return 1;
            case "wednesday":
                return 2;
            case "thursday":
                return 3;
            case "friday":
                return 4;
            case "saturday":
                return 5;
            case "sunday":
                return 6;
        }
        return 7;
    }
    //Changes Indexes to days
    public String indexToDay(int index){

        switch (index){
            case 0:
                return  "Monday";
            case 1:
                return "Tuesday";
            case 2:
                return  "Wednesday";
            case 3:
                return "Thursday";
            case 4:
                return "Friday";
            case 5:
                return "Saturday";
            case 6:
                return "Sunday";
        }
        return "null";
    }
    //Identifies the amount of days under 32
    public void freezing(){
        //initializes freezing day at 0
        int freezingDays=0;


        for (int i = 0; i <temp.length ; i++) {
            if(temp[i] <32){
                freezingDays++;
            }
            
        }
        System.out.println("Number of freezing days is "+freezingDays+" days");
        
    }

    //determines which day is the hottest and if they are the same it will choose the first day
    public void warmest(){
        //Variables save the highest temp and day of the week
        int highTemp=0;
        String day= "";
        for (int i = 0; i <temp.length ; i++) {
                if(highTemp<temp[i]){
                    highTemp=temp[i];
                    day=indexToDay(i);
                }
        }
        System.out.println("The warmest day of the week is "+day);
    }

    //prints out the day and what temp coincides with that day
    public void printTemps(){
        System.out.print("\n");

        for (int i = 0; i < temp.length ; i++) {
            //prints out and aligns days
            if(i==0||i==4||i==6||i==1){
                System.out.print(indexToDay(i)+"\t\t"+temp[i]+"\n");
            }
            else {
                System.out.print(indexToDay(i)+"\t"+temp[i]+"\n");
            }

        }

    }
}
