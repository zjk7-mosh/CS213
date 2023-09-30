package project1;
//FIXME: remove unused imports before submitting
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Calendar;
import java.text.DecimalFormat;

/** FIXME: add javadoc comments */
public enum Timeslot {
    MORNING("10:30am"),
    AFTERNOON("2:00pm"),
    EVENING("6:30pm");
    private final String startingTime;

    //FIXME: Must include hour and minutes as properties
    private int hour;
    private int minutes;

    public String getStartingTime(){
        return this.startingTime;
    }

    Timeslot (String startingTime) {
        //startingTime = startingTime.toUpperCase();
        this.startingTime = startingTime;
    }

    public static void main(String[] args) {
        System.out.println("Timeslot: " + Timeslot.MORNING);
        System.out.println("Timeslot: " + Timeslot.AFTERNOON);
        System.out.println("Timeslot: " + Timeslot.EVENING);

        System.out.println("Timeslot: " + Timeslot.MORNING.startingTime);
        System.out.println("Timeslot: " + Timeslot.AFTERNOON.startingTime);
        System.out.println("Timeslot: " + Timeslot.EVENING.startingTime);
    }
}
