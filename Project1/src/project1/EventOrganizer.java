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
        System.out.println("Event Organizer running...");
        //A while loop to continuously read the command lines from the console until a “Q” command is entered

        //Instantiate EventCalander
        EventCalendar calendar = new EventCalendar();

        //[Event Date: 10/21/2023] [Start: 2:00pm] [End: 3:00pm] @HLL114 (Hill Center, Busch) [Contact: Computer Science, cs@rutgers.edu]
        //A 10/21/2023 afternoon hll114 cs cs@rutgers.edu 60
        while (true) {
            //Read a command line from the console
            Scanner sc = new Scanner(System.in);
            String commandLine = sc.nextLine();
            StringTokenizer tokens = new StringTokenizer(commandLine, " ");
            String command = tokens.nextToken();
            if(command.equals("Q")){break;}
            switch(command){
                // A 2/29/2024 afternoon HLL114 CS cs@rutgers.edu 60
                case "A" -> {
                    Date date = new Date(tokens.nextToken());
                    Timeslot startTime = Timeslot.valueOf(tokens.nextToken().toUpperCase());
                    Location location = Location.valueOf(tokens.nextToken().toUpperCase());
                    Contact contact = new Contact(Department.valueOf(tokens.nextToken().toUpperCase()), tokens.nextToken().toLowerCase());
                    int duration = Integer.parseInt(tokens.nextToken());
                    Event event = new Event(date, startTime, location, contact, duration);
                    calendar.add(event);
                    System.out.println("Event added to the calendar.");
                }
                // R 2/29/2024 afternoon HLL114
                case "R" -> {
                    Date date = new Date(tokens.nextToken());
                    Timeslot startTime = Timeslot.valueOf(tokens.nextToken().toUpperCase());
                    Location location = Location.valueOf(tokens.nextToken());
                    calendar.contains(date, startTime, location);
                    calendar.remove(date, startTime, location);
                }
                //print with the current order in the array.
                case "P" -> {
                    if(!calendar.isEmpty()) {
                        calendar.print();
                    } else{
                        System.out.println("Event calendar is empty!");
                    }
                }
                //print sorted by the event date and timeslot.
                case "PE" -> {
                    if(!calendar.isEmpty()) {
                        calendar.printDate();
                    } else{
                        System.out.println("Event calendar is empty!");
                    }
                }
                //print sorted by campus and building/room.
                case "PC" -> {
                    if(!calendar.isEmpty()) {
                        calendar.printLocation();
                    } else{
                        System.out.println("Event calendar is empty!");
                    }
                }
                //print sorted by the department in the contact.
                case "PD" -> {
                    if(!calendar.isEmpty()) {
                        calendar.printDepartment();
                    } else{
                        System.out.println("Event calendar is empty!");
                    }
                }
                default ->{
                    System.out.println(command + " is an invalid command!");
                }
            }
                //calendar.print();
            }
        System.out.println("Event Organizer terminated");

    }

    //FIXME: add javadoc for testbed
    public static void main(String[] args){
        EventOrganizer organizer = new EventOrganizer();

        organizer.run();
    }
}
