package project1;
//FIXME: remove unused imports before submitting
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Calendar;
import java.text.DecimalFormat;
import java.time.LocalDate;

/** A class that represents the Date abstract data type with year, month, and day. ...*/
public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int day;

    /** A default constructor that creates a date with today's date. */
    public Date() {
        //FIXME: implement proper code "could not figure it out yet"
        // temporary date set to 0/0/0
        // I actually think this is fine, the today() method instantiates todays date,
        // So this should probably remain default to 0/0/0 don't you think?
        this.month = 0;
        this.day = 0;
        this.year = 0;
    }

    /** A parameterized constructor that takes a string in a form of "mm/dd/yyyy". ...*/
    public Date(String date) {  //date in format mm/dd/yyyy
        //FIXME: currently only works in string parameter is mm/dd/yyyy
        //FIXME: Fails if parameter is m/d/yyyy
        this.month = Integer.parseInt(date.substring(0,2));
        this.day = Integer.parseInt(date.substring(3,5));
        this.year = Integer.parseInt(date.substring(6));
    }

    // I believe the constructor should take in 3 int parameters???
    public Date(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    /** A copy constructor that clones a date object. ...*/
    public Date(Date date) {
        this.month = date.month;
        this.day = date.day;
        this.year = date.year;
    }

    /** Checks if this date object is a valid calendar date. ...*/
    public boolean isValid() {
        //check if the date is a valid calendar date
        //FIXME: I think its working fine, double check
        //FIXME: Magic numbers used here to set limits for valid days,months,and years.
        return (this.month <= 12) && (this.day <= 31) && (this.year > 0);
    }

    /** This method compares 2 dates. ...*/
    @Override
    public int compareTo(Date date) {
        if ((this.month == date.month) && (this.day == date.day) && (this.year == date.year)){
            return 0;
        } else if ((this.month > date.month) || (this.day > date.day) || (this.year > date.year)) {
            return 1;
        } else {
            return -1;
        }
    }

    /** Return today's date. ...*/
    public static Date today() { //Good
        String todayString = LocalDate.now().toString(); // in format yyyy-mm-dd
        int todayMonth = Integer.parseInt(todayString.substring(5,7));
        int todayDay = Integer.parseInt(todayString.substring(8));
        int todayYear = Integer.parseInt(todayString.substring(0,4));
        return new Date(todayDay, todayMonth, todayYear);
    }

    /** Return the textual representation of a fitness.student.Date object. ...*/
    @Override
    public String toString() { //Good
        return month + "/" + day + "/" + year;
    }

    /** Getter method for the day of a date. ...*/
    public int getDay() { //Good
        return day;
    }

    /** Getter method for the month of a date ...*/
    public int getMonth() { //Good
        return month;
    }

    /** Getter method for the year of a date. ...*/
    public int getYear() { //Good
        return year;
    }

    /** Check if two dates are the same date. ...*/
    //bs: may be unnecessary, this is not required in the project description
    @Override
    public boolean equals(Object obj) { //Good
        if (obj instanceof Date){
            return ((((Date) obj).month == this.month) && ((Date) obj).day == this.day) && (((Date) obj).year == this.year);
        }
        return false;
    }

    //I inserted the following test cases into one testbed main driver
    public static void main(String[] args) {

        System.out.println("\n--Testing Date.java class--");

        Date dateZero = new Date();
        Date NineEleven = new Date(9, 11, 2001);
        Date today = Date.today();
        Date someday = new Date("07/07/2007");

        System.out.println("Test isValid():\t\t" + someday.isValid());             // COMPLETE
        System.out.println("Test compareTo():\t" + someday.compareTo(someday));      // COMPLETE
        System.out.println("Test today():\t\t" + today.toString());              // COMPLETE
        System.out.println("Test toString():\t" + someday.toString());             // COMPLETE
        System.out.println("Test getMonth():\t" + someday.getMonth());             // COMPLETE
        System.out.println("Test getDay():\t\t" + someday.getDay());               // COMPLETE
        System.out.println("Test getYear():\t\t" + someday.getYear());             // COMPLETE
        System.out.println("Test equals():\t\t" + someday.equals(someday));          // COMPLETE

        String todayString = LocalDate.now().toString(); // in format yyyy-mm-dd
        System.out.println(todayString);
        System.out.println();

        /** Test case #1 */
//        private static void testDaysInFeb_Nonleap () {
//            Date date = new Date("2/29/2011"); //test data
//            boolean expectedOutput = false; //define expected output
//            boolean actualOutput = date.isValid(); //call the method to get the actual output
//            System.out.println("**Test case #1: # of days in Feb. in a non-leap year is 28");
//            testResult(date, expectedOutput, actualOutput); //compare the results
        //FIXME: NOT IMPLEMENTED
        System.out.println("--Test Days In Feb During Non Leap Year--");
        Date nonLeapYear = new Date(2,29,2023);
        System.out.println(nonLeapYear.toString());
        System.out.println();
//        }

        /** Test case #2 */
//        private static void testDaysInFeb_Leap () {
        //FIXME: NOT IMPLEMENTED
        System.out.println("--Test Days In Feb During Leap Year--");
        Date leapYear = new Date(2,29,2023);
        System.out.println(leapYear.toString());
        System.out.println();
//        }

        /** Test case #3 */
//        private static void testMonth_OutOfRange () {
        //FIXME: NOT IMPLEMENTED
        System.out.println("--Test Month Out Of Range--");
        Date monthOutOfRange = new Date(13,1,2023);
        System.out.println(monthOutOfRange.toString());
        System.out.println();
//        }

        /** Check if a given test case PASS or FAIL ...*/
//        private static void testResult (Date date,boolean expectedQutput, boolean actualOutput){
//
//        }

        System.out.println("--Test Complete--");
    }
}
