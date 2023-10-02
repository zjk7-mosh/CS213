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
    private int hour;
    private int minutes;

    Timeslot (String startingTime) {
        //startingTime = startingTime.toUpperCase();
        this.startingTime = startingTime;
        switch (this.startingTime) {
            case "10:30am" -> {
                this.hour = 10;
                this.minutes = 30;
            }
            case "2:00pm" -> {
                this.hour = 2;
                this.minutes = 00;
            }
            case "6:30pm" -> {
                this.hour = 6;
                this.minutes = 30;
            }
        }
    }

    public String getStartingTime(){
        return this.startingTime;
    }

    public int getHour(){
        return this.hour;
    }

    public int getMinutes(){
        return this.minutes;
    }

    public static void main(String[] args) {
        System.out.println("Timeslot: " + Timeslot.MORNING);
        System.out.println("Timeslot: " + Timeslot.AFTERNOON);
        System.out.println("Timeslot: " + Timeslot.EVENING);
        System.out.println();
        System.out.println("Start Time: " + Timeslot.MORNING.startingTime);
        System.out.println("Start Time: " + Timeslot.AFTERNOON.startingTime);
        System.out.println("Start Time: " + Timeslot.EVENING.startingTime);
        System.out.println();
        System.out.println("Morning: " + Timeslot.MORNING.hour + ":" + Timeslot.MORNING.minutes + "am");
        System.out.println("Afternoon: " + Timeslot.AFTERNOON.hour + ":" + Timeslot.AFTERNOON.minutes + "pm");
        System.out.println("Evening: " + Timeslot.EVENING.hour + ":" + Timeslot.EVENING.minutes + "pm");
    }
}
