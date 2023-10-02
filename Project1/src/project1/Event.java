package project1;
//FIXME: remove unused imports before submitting
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Calendar;
import java.text.DecimalFormat;

/** FIXME: add javadoc comments */
public class Event implements Comparable<Event> {
    private Date date; //the event date
    private Timeslot startTime; //the starting time
    private Location location;
    private Contact contact; //include the department name and email
    private int duration; //in minutes

    /** FIXME: add javadoc comments */
    public Event(){
        this.date = new Date();
        this.startTime = Timeslot.MORNING;
        this.location = Location.ARC103;
        this.contact = new Contact();
        this.duration = 60;
    }

    /** FIXME: add javadoc comments */
    public Event(Date date, Timeslot startTime, Location location, Contact contact, int duration) { // Good
        this.date = date;
        this.startTime = startTime;
        this.location = location;
        this.contact = contact;
        this.duration = duration;
    }

    /** FIXME: add javadoc comments */
    @Override
    public boolean equals(Object obj) {
        //returns true if two dates, timeslots and locations are equal
        if (obj instanceof Event){
            return this.date == ((Event) obj).date && this.startTime == ((Event) obj).startTime && this.location == ((Event) obj).location;
        }
        return false;
    }

    /** FIXME: add javadoc comments */
    @Override
    public String toString() {
        //returns a textual representation of an event in the following format:
        //"[Event Date: 10/21/2023] [Start: 2:00pm] [End: 3:00pm] @HLL114 (Hill Center, Busch) [Contact: Computer Science, cs@rutgers.edu]"
        String dateString = "[Event Date: " + date.getMonth() + "/" + date.getDay() + "/" + date.getYear() + "]";

        //FIXME: End time needs to properly add the duration to starting time
        String timeString = "[Start: " + startTime.getStartingTime() + "]" + " [End: " + startTime.getStartingTime() + " + " + duration + "]";


        String locationString = "@" + location + " (" + location.getCampus() + ")";
        String contactString = "[Contact: " + contact.toString() + "]";

        return dateString + " " + timeString + " " + locationString + " " + contactString;
    }

    /** FIXME: add javadoc comments */
    public Date getDate() {
        return date;
    }

    /** FIXME: add javadoc comments */
    public Location getLocation() {
        return location;
    }

    /** FIXME: add javadoc comments */
    public Contact getContact() {
        return contact;
    }

    /** FIXME: add javadoc comments */
    @Override
    public int compareTo(Event o) {
        //compares the dates first, then the timeslots if the dates are the same
        if(this.date.equals(o.date)){
            if(this.startTime.equals(o.startTime)){
                return 0;
            } else if (this.startTime.compareTo(o.startTime) == 1) {
                return 1;
            } else {
                return -1 ;
            }
        } else if (this.date.compareTo(o.date) == 1) {
            return 1;
        } else {
            return -1;
        }
    }

    /** FIXME: add javadoc comments */
    public static void main(String[] args) {
        System.out.println("\n--Testing Event.java class--");

        Date dateZero = new Date();
        Date today = Date.today();
        System.out.println("Today:\t\t" + today.toString());
        System.out.println("Timeslot:\t" + Timeslot.MORNING);
        System.out.println("Location:\t" + Location.HLL114);
        Contact cs = new Contact(Department.CS, "cs@rutgers.edu");
        System.out.println("Contact:\t" + cs.toString());
        int duration = 60;
        System.out.println("Duration:\t" + duration);

        System.out.println();
        Event event1 =  new Event(today, Timeslot.MORNING, Location.HLL114, cs, duration);
        System.out.println(event1.toString());

        System.out.println("\n--Test Complete--");
    }
}
