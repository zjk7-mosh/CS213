package project1;
//FIXME: remove unused imports before submitting
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Calendar;
import java.text.DecimalFormat;

/** A class that represents the Date abstract data type with year, month, and day. ...*/
public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int day;

    /** A default constructor that creates a date with today's date. */
    public Date() {
        //FIXME: implement proper code "could not figure it out yet"
        // temporary date set to 0/0/0
        this.year = 0;
        this.month = 0;
        this.day = 0;
    }

    /** A parameterized constructor that takes a string in a form of "mm/dd/yyyy". ...*/
    // I believe the constructor should take in 3 int parameters???
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    /** A copy constructor that clones a date object. ...*/
    public Date(Date date) {
        this.day = date.day;
        this.month = date.month;
        this.year = date.year;
    }

    /** Checks if this date object is a valid calendar date. ...*/
    public boolean isValid() {
        //check if the date is a valid calendar date
        //FIXME: implement proper code "could not figure it out yet"
        return false;
    }

    /** This method compares 2 dates. ...*/
    @Override
    public int compareTo(Date date) {
        //FIXME: implement proper code "could not figure it out yet"
        return 0;
    }

    /** Return today's date. ...*/
    public static Date today() {
        return new Date();
    }

    /** Return the textual representation of a fitness.student.Date object. ...*/
    @Override
    public String toString() {
        return month + "/" + day + "/" + year;
    }

    /** Getter method for the day of a date. ...*/
    public int getDay() {
        return day;
    }

    /** Getter method for the month of a date ...*/
    public int getMonth() {
        return month;
    }

    /** Getter method for the year of a date. ...*/
    public int getYear() {
        return year;
    }


    /** Check if two dates are the same date. ...*/
    //bs: may be unnecessary, this is not required in the project description
    @Override
    public boolean equals(Object obj) {
        //FIXME: implement proper code "could not figure it out yet"
        return false;
    }

    //I inserted the following test cases into one testbed main driver
    public static void main(String[] args) {

        System.out.println("\n--Testing Date.java class--");

        Date dateZero = new Date(0, 0, 0);
        Date date1 = new Date();

        System.out.println("Test isValid():\t\t" + date1.isValid());
        System.out.println("Test compareTo():\t\t" + date1.compareTo(dateZero));
        System.out.println("Test today():\t\t" + today());
        System.out.println("Test toString():\t" + date1.toString());
        System.out.println("Test getDay():\t\t\t" + date1.getDay());
        System.out.println("Test getMonth():\t\t" + date1.getMonth());
        System.out.println("Test getYear():\t\t\t" + date1.getYear());
        System.out.println("Test equals():\t\t" + date1.equals(dateZero));

//        /** Test case #1 */
//        private static void testDaysInFeb_Nonleap () {
//            Date date = new Date("2/29/2011"); //test data
//            boolean expectedOutput = false; //define expected output
//            boolean actualOutput = date.isValid(); //call the method to get the actual output
//            System.out.println("**Test case #1: # of days in Feb. in a non-leap year is 28");
//            testResult(date, expectedOutput, actualOutput); //compare the results
//        }

//        /** Test case #2 */
//        private static void testDaysInFeb_Leap () {
//
//        }

//        /** Test case #3 */
//        private static void testMonth_OutOfRange () {
//
//        }

//        /** Check if a given test case PASS or FAIL ...*/
//        private static void testResult (Date date,boolean expectedQutput, boolean actualOutput){
//
//        }

        System.out.println("--Test Complete--");
    }
}
