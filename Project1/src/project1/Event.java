package project1;
//FIXME: remove unused imports before submitting
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Calendar;
import java.text.DecimalFormat;

/**
 A class that represents the Event abstract data type with fields; date, startTime, location, contact, and duration.
 @author FelipePDaSilva, ZachJKoshy,
*/
public class Event implements Comparable<Event> {
    private Date date; //the event date
    private Timeslot startTime; //the starting time
    private Location location;
    private Contact contact; //include the department name and email
    private int duration; //in minutes

    /**
     Default constructor for Event class.
     */
    public Event(){
        this.date = new Date();
        this.startTime = Timeslot.MORNING;
        this.location = Location.ARC103;
        this.contact = new Contact();
        this.duration = 60;
    }

    /**
     Parameterized constructor for Event class.
     @param date the event date
     @param startTime the starting time
     @param location the location
     @param contact the contact
     @param duration the duration
     */
    public Event(Date date, Timeslot startTime, Location location, Contact contact, int duration) { // Good
        this.date = date;
        this.startTime = startTime;
        this.location = location;
        this.contact = contact;
        this.duration = duration;
    }

    /**
     Compares two objects to see if they are equal.
     @param obj the object to be compared
     @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        //returns true if two dates, timeslots and locations are equal
        if (obj instanceof Event){
            return this.date == ((Event) obj).date && this.startTime == ((Event) obj).startTime &&
                    this.location == ((Event) obj).location;
        }
        return false;
    }

    /**
     Returns a textual representation of an event in the following format:
     [Event Date: 10/21/2023] [Start: 2:00pm] [End: 3:00pm] @HLL114 (Hill Center, Busch) [Contact: Computer Science, cs@rutgers.edu]
     @return a textual representation of an event
    */
    @Override
    public String toString() {
        String endTime = calculateEndtime();

        String dateString = "[Event Date: " + date.getMonth() + "/" + date.getDay() + "/" + date.getYear() + "]";

        String timeString = "[Start: " + startTime.getStartingTime() + "]" + " [End: " + endTime + "]";

        String locationString = "@" + location + " (" + location.getCampus() + ")";

        String contactString = "[Contact: " + contact.toString() + "]";

        return dateString + " " + timeString + " " + locationString + " " + contactString;
    }

    /**
     Calculates the end time of an event.
     @return the end time of an event
     */
    private String calculateEndtime(){
        int startHour = startTime.getHour();
        int startMinutes = startTime.getMinutes();
        int endHour = startHour;
        int endMinutes = startMinutes + duration;

        if (endMinutes == 60){
            endHour += 1;
            endMinutes = 00;
        } else if (endMinutes > 60) {
            endHour += 1;
            endMinutes = endMinutes - 60;
        }

        String endTime = Integer.toString(endHour) + ":" + Integer.toString(endMinutes);

        if (endHour == 10 || endHour == 11){
            endTime = endTime.concat("am");
        }else {
            endTime = endTime.concat("pm");
        }
        return endTime;
    }

    /**
     Getter method for the date of an event.
     @return the date of an event
     */
    public Date getDate() {
        return date;
    }

    /**
     * Getter method for the location of an event.
     * @return the location of an event
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Getter method for the contact of an event.
     * @return the contact of an event
     */
    public Contact getContact() {
        return contact;
    }

    /**
     * Compares two events to see which one is greater.
     * @param o the object to be compared.
     * @return 1 if the object is greater, -1 if the object is less, 0 if the object is equal.
     */
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

    //FIXME: Must create a testbed main driver which follows Prof's demo
    /**
     * Testbed main driver method for Event.java class.
     * @param args
     */
    public static void main(String[] args) {


    }

    /**
     * Old tests for Event.java class.
     */
    private static void oldTests() {
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
        Event eventDefault = new Event();
        Event event1 =  new Event(today, Timeslot.MORNING, Location.HLL114, cs, duration);
        System.out.println(event1.toString());

        System.out.println("\nTest equals(): " + event1.equals(event1));
        System.out.println("Test getDate(): " + event1.getDate());
        System.out.println("Test getLocation(): " + event1.getLocation());
        System.out.println("Test getContact(): " + event1.getContact());
        System.out.println("Test compareTo(): " + event1.compareTo(event1));

        System.out.println("\n--Test Complete--");
    }

    //Event()               working good
    //Event(parameters)     working good
    //equals()              working good
    //calculateEndTime()    working good
    //toString()            working good
    //getDate()             working good
    //getLocation()         working good
    //getContact()          working good
    //compareTo()           working good

}
