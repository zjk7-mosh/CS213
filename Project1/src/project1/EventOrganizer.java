package project1;
//FIXME: remove unused imports before submitting
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Calendar;
import java.text.DecimalFormat;

//FIXME: add to javadoc comments after finishing EventOrganizer class
/**
 * This class represents the EventOrganizer data type
 * //add more here
 * @author FelipePDaSilva, ZachJKoshy
 */
public class EventOrganizer {
    /**
     * Default constructor for EventOrganizer class.
     */
    public void run() {
        //A while loop to continuously read the command lines from the console until a “Q” command is entered
        while (true) {
            //Read a command line from the console
            Scanner sc = new Scanner(System.in);
            String commandLine = sc.nextLine();
            //If the command line is “Q”, then quit the program
            if (commandLine.equals("Q")) {
                break;
            }
            //If the command line is “A”, then add a new event to the calendar
            else if (commandLine.equals("A")) {
                //Read the event name, start time, and end time from the console
                Date date = new Date(sc.next());
                Timeslot startTime = Timeslot.valueOf(sc.next());
                Location location = Location.valueOf(sc.next());
                //FIXME: I think Department enum needs to be fixed to be able to read the department name
                Contact contact = new Contact(Department.valueOf(sc.next()), sc.next());
                int duration = sc.nextInt();
                //Create a new event object with the given information
                Event event = new Event(date, startTime, location, contact, duration);
                //instantiate a new EventCalendar object
                EventCalendar calendar = new EventCalendar();
                //Add the event to the calendar
                calendar.add(event);
            }

        }
        System.out.println("Event Organizer terminated");
    }
}
