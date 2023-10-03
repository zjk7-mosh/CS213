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
                    if(!date.isValid()){
                        System.out.println(date.toString() + ": Invalid calendar date!");
                        break;
                    } else if (date.compareTo(Date.today()) == -1) {
                        System.out.println(date.toString() + ": Event date must be a future date!");
                        break;
                    }

                    String time = tokens.nextToken().toUpperCase();
                    if(!time.equals("MORNING") && !time.equals("AFTERNOON") && !time.equals("EVENING")){
                        System.out.println("Invalid time slot!");
                        break;
                    }
                    Timeslot startTime = Timeslot.valueOf(time);

                    String room = tokens.nextToken().toUpperCase();
                    if(!room.equals("HLL114") && !room.equals("ARC103") &&
                            !room.equals("BE_AUD") && !room.equals("TIL232") &&
                            !room.equals("AB2225") && !room.equals("MU302")){
                        System.out.println("Invalid location!!");
                        break;
                    }
                    Location location = Location.valueOf(room);

                    String department = tokens.nextToken().toUpperCase();
                    if(!department.equals("CS") && !department.equals("EE") &&
                            !department.equals("ITI") && !department.equals("MATH") &&
                            !department.equals("BAIT")){
                        System.out.println("Invalid contact information!");
                        break;
                    }
                    String email = tokens.nextToken().toLowerCase();
                    if(!email.equals("cs@rutgers.edu") && !email.equals("ee@rutgers.edu") &&
                            !email.equals("iti@rutgers.edu") && !email.equals("math@rutgers.edu") &&
                            !email.equals("bait@rutgers.edu")){
                        System.out.println("Invalid contact information!");
                        break;
                    }
                    Contact contact = new Contact(Department.valueOf(department), email);


                    int duration = Integer.parseInt(tokens.nextToken());
                    if(duration < 30 || duration > 120){
                        System.out.println("Event duration must be at least 30 minutes and at most 120 minutes");
                        break;
                    }
                    Event event = new Event(date, startTime, location, contact, duration);

                    if(calendar.contains(date, startTime, location)){
                        System.out.println("The event is already on the calendar.");
                    }else{
                        calendar.add(event);
                        System.out.println("Event added to the calendar.");
                    }

                }
                // R 2/29/2024 afternoon HLL114
                case "R" -> {
                    Date date = new Date(tokens.nextToken());
                    Timeslot startTime = Timeslot.valueOf(tokens.nextToken().toUpperCase());
                    Location location = Location.valueOf(tokens.nextToken().toUpperCase());

                    if(!calendar.contains(date, startTime, location)){
                        System.out.println("Cannot remove; event is not in the calendar!");
                        break;
                    }
                    calendar.remove(date, startTime, location);
                    System.out.println("Event has been removed from the calendar!");
                }
                //print with the current order in the array.
                case "P" -> {
                    if(!calendar.isEmpty()) {
                        System.out.println("* Event calendar *");
                        calendar.print();
                        System.out.println("* end of event calendar *");
                    } else{
                        System.out.println("Event calendar is empty!");
                    }
                }
                //print sorted by the event date and timeslot.
                case "PE" -> {
                    if(!calendar.isEmpty()) {
                        System.out.println("* Event calendar by event date and start time *");
                        calendar.printDate();
                        System.out.println("* end of event calendar *");
                    } else{
                        System.out.println("Event calendar is empty!");
                    }
                }
                //print sorted by campus and building/room.
                case "PC" -> {
                    if(!calendar.isEmpty()) {
                        System.out.println("* Event calendar by campus and building *");
                        calendar.printLocation();
                        System.out.println("* end of event calendar *");
                    } else{
                        System.out.println("Event calendar is empty!");
                    }
                }
                //print sorted by the department in the contact.
                case "PD" -> {
                    if(!calendar.isEmpty()) {
                        System.out.println("* Event calendar by department *");
                        calendar.printDepartment();
                        System.out.println("* end of event calendar *");
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
