package project1;
//bs: remove unused imports
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Calendar;
import java.text.DecimalFormat;
/** //bs: ADD Javadoc comments. */
public class Event implements Comparable<Event> {
    private Date date; //the event date
    private Timeslot startTime; //the starting time
    private Location location;
    private Contact contact; //include the department name and email
    private int duration; //in minutes

    /** //bs: ADD Javadoc comments. */
    public Event(Date date, Timeslot startTime, Location location, Contact contact, int duration) {
            this.date = date;
            this.startTime = startTime;
            this.location = location;
            this.contact = contact;
            this.duration = duration;
    }

    //bs: override equals method
    /** //bs: ADD Javadoc comments. */
    @Override
    public boolean equals(Object obj) {
        //returns true if two dates, timeslots and locations are equal
        return super.equals(obj);
    }

    //bs: override toString method
    /** //bs: ADD Javadoc comments. */
    @Override
    public String toString() {
        //returns a textual representation of an event in the following format:
        //"[Event Date: 10/21/2023] [Start: 2:00pm] [End: 3:00pm] @HLL114 (Hill Center, Busch) [Contact: Computer Science, cs@rutgers.edu]"
        return super.toString();
    }

    //bs: implement compareTo method
    /** //bs: ADD Javadoc comments. */
    @Override
    public int compareTo(Event o) {
        //compares the dates first, then the timeslots if the dates are the same
        return 0;
    }

    //IntelliJ Auto-generated getter methods bellow:
      //bs: must remove unnecessary methods from below, and javadoc comment the kept ones before submit//
    public Date getDate() {
        return date;
    }
    public Timeslot getStartTime() {
        return startTime;
    }
    public Location getLocation() {
        return location;
    }
    public Contact getContact() {
        return contact;
    }
    public int getDuration() {
        return duration;
    }
}
