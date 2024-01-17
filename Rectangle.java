// Name: Phillip Bell
// Class: CS 3305/Section 04
// Term: Spring 2024
// Instructor: Dr. Haddad
// Assignment: 1
// IDE Name: Inteli J
public class Rectangle {
   private double width;
    private double height;

    //Default constructor
    Rectangle(){
        this.width= 1.00;
        this.height=1.00;
    }

    //overloaded constructor that passes the info from the test program
    Rectangle(double width,double height){
        this.width=width;
        this.height=height;
    }

    //getters and setter for width and height
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    //Calculates and gets the area of the rectangle
    public double getArea(){
        double area;

        area=width*height;
        return area;
    }

    //Calculates and gets the perimeter of the rectangle
    public double getPerimeter(){
        double perimeter;

        perimeter=2*(width+height);
        return perimeter;
    }

    //print out the rectangles information
    public void printRectangle(String objectName){

        //create a - line the size of the name
        String underline="";
        for (int i = 0; i <objectName.length() ; i++) {
            underline=underline+"-";
        }

        //prints out the result
        System.out.print("\n"+objectName+":\n" +
                             underline+"-");
        System.out.printf( "\nWidth:\t%.2f",width);
        System.out.printf("\nHeight:\t%.2f",height);
        System.out.printf("\nArea:\t%.2f",getArea());
        System.out.printf("\nPerimeter:\t%.2f",getPerimeter());
        System.out.println( "\n\nRectangle "+objectName+" is "+width+" units wide and "+height+" units high.");




    }

}