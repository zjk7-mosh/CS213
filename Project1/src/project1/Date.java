package project1;
/** A class that represents the Date abstract data type with year, month, and day. ...*/
public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int day;
    public boolean isValid() //check if the date is a valid calendar date

    /** A parameterized constructor that takes a string in a form of "mm/dd/yyyy". ...*/
    public Date(String date) {...}

    /** A default constructor that creates a date with today's date. */
    public Date() {...}

    /** A copy constructor that clones a date object. ...*/
    public Date(Date date) {...}

    /** This method compares 2 dates. ...*/
    @Override
    public int compareTo(Date date) {...}

    /** Return today's date. ...*/
    public static Date today() { return new Date(); }

    /** Check if this date object is a valid calendar date. ...*/
    public boolean isValid() {...}

    /** Return the textual representation of a fitness.student.Date object. ...*/
    @Override
    public String toString() { return month + "/" + day + "/" + year; }

    /** Getter method for the day of a date. ...*/
    public int getDay() { return day; }

    /** Getter method for the month of a date ...*/
    public int getMonth() { return month; }

    /** Getter method for the year of a date. ...*/
    public int getYear() { return year; }

    /** Check if two dates are the same date. ...*/
    @Override
    public boolean equals(Object obj) {...}

    /** Test case #1 */
    private static void testDaysInFeb_Nonleap() {
        Date date = new Date("2/29/2011"); //test data
        boolean expectedOutput = false; //define expected output
        boolean actualOutput = date.isValid(); //call the method to get the actual output
        System.out.println("**Test case #1: # of days in Feb. in a non-leap year is 28");
        testResult(date, expectedOutput, actualOutput); //compare the results
    }

    /** Test case #2 */
    private static void testDaysInFeb_Leap() {...}
    /** Test case #3 */
    private static void testMonth_OutOfRange () {...}
    /** Check if a given test case PASS or FAIL ...*/
    private static void testResult(Date date, boolean expectedQutput, boolean actualOutput) {...}


}
