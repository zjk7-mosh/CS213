package project1;
//FIXME: remove unused imports before submitting
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Calendar;
import java.text.DecimalFormat;

/**
 * A class that represents the Date abstract data type with year, month, and day.
 * @author FelipePDaSilva, ZachJKoshy,
 */
public class Date implements Comparable<Date>{
    private int month;
    private int day;
    private int year;

    //FIXME: may want to move these to a separate class, i.e. DateConstants.java
    public int FULLYEAR = 12;
    public int ZERO = 0; //FIXME: double check if this is allowed by codingStandard and writeup


    /**
     * Default constructor for Date class.
     */
    public Date() {
        this.month = 0;
        this.day = 0;
        this.year = 0;
    }

    /**
     * Parameterized constructor for Date which takes a string in a form of "mm/dd/yyyy".
     * @param date the date in a form of "mm/dd/yyyy", with one or two digits for month and day.
     */
    public Date(String date) {
        if(date.length() == 10) { // mm/dd/yyyy
            this.month = Integer.parseInt(date.substring(0, 2));
            this.day = Integer.parseInt(date.substring(3, 5));
            this.year = Integer.parseInt(date.substring(6));
        } else if (date.length() == 9) {
            if(date.charAt(1) == '/'){  // m/dd/yyyy
                this.month = Integer.parseInt(date.substring(0, 1));
                this.day = Integer.parseInt(date.substring(2, 4));
                this.year = Integer.parseInt(date.substring(5));
            } else if (date.charAt(2) == '/') { // mm/d/yyyy
                this.month = Integer.parseInt(date.substring(0, 2));
                this.day = Integer.parseInt(date.substring(3, 4));
                this.year = Integer.parseInt(date.substring(5));
            }
        } else if (date.length() == 8) { // m/d/yyyy
            this.month = Integer.parseInt(date.substring(0, 1));
            this.day = Integer.parseInt(date.substring(2, 3));
            this.year = Integer.parseInt(date.substring(4));
        }
    }

    /**
     * Parameterized constructor for Date class, which takes 3 int values for month, day, and year.
     * @param month int month
     * @param day int day
     * @param year int year
     */
    public Date(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    /**
     * Copy constructor for Date class, which takes a Date object and clones it.
     * @param date the Date object to be cloned
     */
    public Date(Date date) {
        this.month = date.month;
        this.day = date.day;
        this.year = date.year;
    }

    //FIXME: is isValid() still incomplete?
        //FIXME: method is partically correct, but fails to dates out of bound.
    /**
     * Checks if this date object is a valid calendar date.
     * @return true if the date is valid, false if the date is invalid.
     */
    public boolean isValid() {
        int monthMax = monthMax();
        if(this.month == 2 && leapYear()){
            monthMax += 1;
        }
        return (this.month > ZERO && this.month <= FULLYEAR) &&
                (this.day > ZERO && this.day <= monthMax) &&
                (this.year > ZERO);
    }

    /**
     * Helper method for isValid() which returns the max number of days in a month.
     * @return the max number of days in a month
     */
        private int monthMax() { //FIXME: does this indentation of a helper method meet codingStandard?
            switch (this.month) {
                case 1 -> {return DateConstants.JANUARY.getMax();}
                case 2 -> {return DateConstants.FEBRUARY.getMax();}
                case 3 -> {return DateConstants.MARCH.getMax();}
                case 4 -> {return DateConstants.APRIL.getMax();}
                case 5 -> {return DateConstants.MAY.getMax();}
                case 6 -> {return DateConstants.JUNE.getMax();}
                case 7 -> {return DateConstants.JULY.getMax();}
                case 8 -> {return DateConstants.AUGUST.getMax();}
                case 9 -> {return DateConstants.SEPTEMBER.getMax();}
                case 10 -> {return DateConstants.OCTOBER.getMax();}
                case 11 -> {return DateConstants.NOVEMBER.getMax();}
                case 12 -> {return DateConstants.DECEMBER.getMax();}
            }
            return 31;
        }
/*
    public boolean isValid() {
        int max = DateConstants.monthMax(this.month);
        if(this.month == 2 && leapYear()){
            max += 1;
        }
        return (this.month > ZERO && this.month <= FULLYEAR) &&
                (this.day > ZERO && this.day <= max) &&
                (this.year > ZERO);
    }

 */


    /**
     * Compares two dates to see if they are equal.
     * @param date the object to be compared.
     * @return 0 if the dates are equal, 1 if this date is greater than the other date, -1 if this date is less than the other date.
     */
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

    /**
     * Returns today's date.
     * @return today's date
     */
    public static Date today() {
        //FIXME: had to replace LocalDate with Calendar, check that output is correct
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH) + 1; // Calendar.MONTH is 0-based
        int year = calendar.get(Calendar.YEAR);
        return new Date(month, day, year);
    }

    /**
     * Returns the textual representation of a Date object.
     * @return the textual representation of a Date object
     */
    @Override
    public String toString() { //Good
        return month + "/" + day + "/" + year;
    }

    /**
     * Getter method for the day of a date.
     * @return the day of a date
     */
    public int getDay() { //Good
        return day;
    }

    /**
     * Getter method for the month of a date.
     * @return the month of a date
     */
    public int getMonth() { //Good
        return month;
    }

    /**
     * Getter method for the year of a date.
     * @return the year of a date
     */
    public int getYear() { //Good
        return year;
    }

    /**
     * Checks if two dates are the same date.
     * @param obj
     * @return true if the dates are the same, false if the dates are not the same.
     */
    @Override
    public boolean equals(Object obj) { //Good
        if (obj instanceof Date){
            return ((((Date) obj).month == this.month) && ((Date) obj).day == this.day) && (((Date) obj).year == this.year);
        }
        return false;
    }

    /**
     * Tells whether a given year is a leap year or not.
     * @return true if the year is a leap year, false if the year is not a leap year.
     */
    private boolean leapYear(){
        return this.year % 4 == 0;
    }

    //FIXME: reformat testbed main to execute the required testcases for Date.isValid()
    /**
     * Testbed main() for Date class.
     * @param args
     */
    public static void main(String[] args) {
        //oldTests();
        testDaysInFeb_Nonleap();
        testDay_OutOfRange();
        testMonth_OutOfRange();
    }
    /**
     * Test case #1
     */
    private static void testDaysInFeb_Nonleap () {
        Date date = new Date("2/29/2022"); //test data
        boolean expectedOutput = false; //define expected output
        boolean actualOutput = date.isValid(); //call the method to get the actual output
        System.out.println("**Test case #1: # of days in Feb. in a non-leap year is 28");
        testResult(date, expectedOutput, actualOutput); //compare the results
    /*
        System.out.println("--Test Days In Feb During Non Leap Year--");
        Date nonLeapYear = new Date(2,29,2023);
        System.out.println(nonLeapYear.toString());
        System.out.println();
     */
    }
    /**
     * Test case #2
     */
    private static void testDay_OutOfRange () {
        Date date = new Date("4/31/2024"); //test data
        boolean expectedOutput = false; //define expected output
        boolean actualOutput = date.isValid(); //call the method to get the actual output
        System.out.println("**Test case #2: # of days in April is 30");
        testResult(date, expectedOutput, actualOutput); //compare the results
    }
    /**
     * Test case #3
     */
    private static void testMonth_OutOfRange () {
        Date date = new Date("13/30/2022"); //test data
        boolean expectedOutput = false; //define expected output
        boolean actualOutput = date.isValid(); //call the method to get the actual output
        System.out.println("**Test case #3: # of months in a year is 12");
        testResult(date, expectedOutput, actualOutput); //compare the results
    }
    /** Check if a given test case PASS or FAIL ...*/
    private static void testResult (Date date,boolean expectedOutput, boolean actualOutput){
        if (expectedOutput == actualOutput){
            System.out.println(date.toString() + ": PASS");
        } else {
            System.out.println(date.toString() + ": FAIL");
        }
    }
    /** Test case #i: unused in testbed main() */
    private static void testDaysInFeb_Leap () {
        Date date = new Date("2/29/2022"); //test data
        boolean expectedOutput = false; //define expected output
        boolean actualOutput = date.isValid(); //call the method to get the actual output
        System.out.println("**Test case #i: # of days in Feb. in a non-leap year is 28");
        testResult(date, expectedOutput, actualOutput); //compare the results
    /*
        System.out.println("--Test Days In Feb During Leap Year--");
        Date leapYear = new Date(2,29,2023);
        System.out.println(leapYear.toString());
        System.out.println();
     */
    }

    /**
     * Old tests for Date class.
     */
    private static void oldTests() {
        System.out.println("\n--Testing Date.java class--");
        //        Date dateZero = new Date();
        //        Date NineEleven = new Date(9, 11, 2001);
        Date today = Date.today();
        //        Date twoMonthTwoDay = new Date("10/11/2012");
        //        Date twoMonthOneDay = new Date("11/5/2006");
        //        Date oneMonthTwoDay = new Date("7/14/2023");
        //        Date OneMonthOneDay = new Date("3/8/2009");
        Date validTest = new Date("2/29/2024");
        System.out.println("Test isValid():\t\t" + validTest.isValid());             // COMPLETE
        System.out.println("Test compareTo():\t" + validTest.compareTo(today));      // COMPLETE
        System.out.println("Test today():\t\t" + today.toString());              // COMPLETE
        System.out.println("Test toString():\t" + validTest.toString());             // COMPLETE
        System.out.println("Test getMonth():\t" + validTest.getMonth());             // COMPLETE
        System.out.println("Test getDay():\t\t" + validTest.getDay());               // COMPLETE
        System.out.println("Test getYear():\t\t" + validTest.getYear());             // COMPLETE
        System.out.println("Test equals():\t\t" + validTest.equals(today));          // COMPLETE
        /** Test case #1 */
        //        testDaysInFeb_Nonleap
        //            Date date = new Date("2/29/2011"); //test data
        //            boolean expectedOutput = false; //define expected output
        //            boolean actualOutput = date.isValid(); //call the method to get the actual output
        //            System.out.println("**Test case #1: # of days in Feb. in a non-leap year is 28");
        //            testResult(date, expectedOutput, actualOutput); //compare the results

        //        System.out.println("--Test Days In Feb During Non Leap Year--");
        //        Date nonLeapYear = new Date(2,29,2023);
        //        System.out.println(nonLeapYear.toString());
        //        System.out.println();
        //        }
        /** Test case #2 */
        //        private static void testDaysInFeb_Leap () {

        //        System.out.println("--Test Days In Feb During Leap Year--");
        //        Date leapYear = new Date(2,29,2023);
        //        System.out.println(leapYear.toString());
        //        System.out.println();
        //        }
        /** Test case #3 */
        //        private static void testMonth_OutOfRange () {

        //        System.out.println("--Test Month Out Of Range--");
        //        Date monthOutOfRange = new Date(13,1,2023);
        //        System.out.println(monthOutOfRange.toString());
        //        System.out.println();
        ////        }
        /** Check if a given test case PASS or FAIL ...*/
        //        private static void testResult (Date date,boolean expectedQutput, boolean actualOutput){
        //        }
        System.out.println("--Test Complete--");
    }

    //Date()                working good
    //Date(String()         working good
    //Date(int, int, int)   working good
    //Date(Date)            working good
    //isValid()
    //compareTo()           working good
    //today()               working good
    //toString()            working good
    //getMonth()            working good
    //getDay()              working good
    //getYear()             working good
    //equals()              working good
}
