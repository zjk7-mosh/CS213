package project1;
//FIXME: remove unused imports before submitting
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Calendar;
import java.text.DecimalFormat;

//FIXME: might want to add to this javadoc comment before submission
/**
 * This class represents the EventCalendar data type
 * @author FelipePDaSilva, ZachJKoshy
 */
public class EventCalendar {
    private Event[] events; //the array holding the list of events
    private int numEvents; //current number of events in the array

    /**
     * Default constructor for EventCalendar class, Initializes the array with a capacity of 4.
     */
    public EventCalendar(){
        this.events = new Event[4];
        this.numEvents = 0;
    }

    /**
     * searches for an event in the list
     * @param event the event to be searched for
     * @return the index of the event if found, -1 otherwise
     */
    private int find(Event event) {
        for(int i = 0; i < numEvents; i++){
            if(events[i].equals(event)){
                return i;
            }
        }
        return -1;
    }

    //FIXME: add java docs
    private int find(Date date, Timeslot startingTime, Location location) {
        for(int i = 0; i < numEvents; i++){
            if(events[i].getDate().equals(date) &&
                    events[i].getTimeslot().equals(startingTime) &&
                    events[i].getLocation().equals(location)){
                return i;
            }
        }
        return -1;
    }

    /**
     * increases the capacity of the array by 4
     */
    private void grow() {
        //increase the capacity by 4
        Event[] copy = new Event[numEvents + 4];
        for(int i = 0; i < numEvents; i++){
            copy[i] = events[i];
        }
        events = copy;
        copy = null;
    }

    /**
     * adds an event to the list
     * @param event the event to be added
     * @return true if the event was added, false otherwise
     */
    public boolean add(Event event) {
        //add an event to the list
        if (this.events[events.length - 1] != null){
            grow();
        }

        if(this.events[numEvents] == null){
            this.events[numEvents] = event;
            numEvents += 1;
            return true;
        }
        return false;
    }

    /**
     * removes an event from the list
     * @param event the event to be removed
     * @return true if the event was removed, false otherwise
     */
    public boolean remove(Event event) {
        //remove an event from the list
        int found = find(event);
        if(found != -1){
            for(int i = found; i < numEvents; i++){
                this.events[i] = events[i + 1];
            }
            numEvents -= 1;
        }
        return true;
    }

    //FIXME: add javadocs
    //R 12/22/2023 MORNING HLL114
    public boolean remove(Date date, Timeslot startingTime, Location location) {
        //remove an event from the list
        int found = find(date, startingTime, location);
        if(found != -1){
            for(int i = found; i < numEvents; i++){
                this.events[i] = events[i + 1];
            }
            numEvents -= 1;
        }
        return true;
    }

    /**
     * checks if the list contains an event
     * @param event the event to be checked
     * @return true if the event is in the list, false otherwise
     */
    public boolean contains(Event event) {
        return find(event) != -1;
    }

    //FIXME: add java docs
    // R 12/22/2023 MORNING HLL114
    public boolean contains(Date date, Timeslot startingTime, Location location){

        return find(date, startingTime, location) != -1;
    }

    //FIXME: add javadocs
    public boolean isEmpty(){
        return(numEvents == 0);
    }


    /**
     * prints the list of events to System.out.
     */
    public void print() {
        //print the array as is
        for(Event event : events) {
            if(event != null) {
                System.out.println(event.toString());
            }
        }
    }

    /**
     * prints the list of events ordered by date and timeslot to System.out.
     */
    public void printDate() {
        sortDate();
        print();
    }

    /**
     * prints the list of events ordered by location to System.out.
     */
    public void printLocation() {
        sortLocation();
        print();
    }

    /**
     * prints the list of events ordered by department to System.out.
     */
    public void printDepartment(){
        sortDepartment();
        print();
    }



    //FIXME: Sorting modes - Is this COMPLETE?
    //Need to implement 3 sorting MODES; by date, location(campus/building/room), and department
    //current implementation is using 3 separate methods for each mode
    //another possible implementation is using enums to determine the sorting mode
    /**
     * Sorts the list of events by date and timeslot
     */
    private void sortDate() {                           //removed Events[] parameter, I think it should just sort the private Events[] attribute instead
        boolean swapped;
        for (int i = 0; i < numEvents - 1; i++) {       //lol, event.length is also equal to its private attribute numEvents
            swapped = false;
            for (int j = 0; j < numEvents - i - 1; j++) {
                if (events[j].getDate().compareTo(events[j + 1].getDate()) > 0) {
                    swap(j);                            // Swap people[j] with people[j+1]
                    swapped = true;
                }
            }
            // If no two elements were swapped by inner loop, then break
            if (!swapped) {
                break;
            }
        }
    }

    //FIXME: NOT COMPLETE
    //Still need to test, and implement sorting by location (campus/building/room), and also by department
    /**
     * Sorts the list of events by location
     */
    private void sortLocation() {
        boolean swapped;
        for (int i = 0; i < numEvents - 1; i++) {       //lol, event.length is also equal to its private attribute numEvents
            swapped = false;
            for (int j = 0; j < numEvents - i - 1; j++) {
                if (events[j].getLocation().compareTo(events[j + 1].getLocation()) > 0) {
                    swap(j);                            // Swap people[j] with people[j+1]
                    swapped = true;
                }
            }
            // If no two elements were swapped by inner loop, then break
            if (!swapped) {
                break;
            }
        }
    }
    //FIXME: NOT COMPLETE
    //FIXME: compareTo() method for Contact class incomplete
    //Still need to test, and implement sorting by location (campus/building/room), and also by department
    /**
     * Sorts the list of events by department
     */
    private void sortDepartment() {
        boolean swapped;
        for (int i = 0; i < numEvents - 1; i++) {       //lol, event.length is also equal to its private attribute numEvents
            swapped = false;
            for (int j = 0; j < numEvents - i - 1; j++) {
                //FIXME: compareTo() method for Contact class incomplete
                if (events[j].getContact().compareTo(events[j + 1].getContact()) > 0) {
                    swap(j);                            // Swap people[j] with people[j+1]
                    swapped = true;
                }
            }
            // If no two elements were swapped by inner loop, then break
            if (!swapped) {
                break;
            }
        }
    }
    /**
     * helper method for sort methods, which swaps two events in the array
     * @param event the index of the first event
     */
    private void swap(int event){
        Event tempEvent = events[event];
        events[event] = events[event + 1];
        events[event + 1] = tempEvent;
    }

    /**
     * Testbed main driver method for EventCalendar.java class.
     * @param args the command line arguments
     */
    public static void main(String[] args){

        System.out.println(("--Test EventCalender.java--\n"));
        //public Event(Date date, Timeslot startTime, Location location, Contact contact, int duration)
        Event event1 = new Event(new Date("10/01/2023"), Timeslot.MORNING, Location.BE_AUD, new Contact(Department.CS, "cs@rutgers.edu"), 60);
        Event event2 = new Event(new Date("10/02/2023"), Timeslot.MORNING, Location.TIL232, new Contact(Department.ITI, "iti@rutgers.edu"), 60);
        Event event3 = new Event(new Date("10/03/2023"), Timeslot.MORNING, Location.MU302, new Contact(Department.EE, "ee@rutgers.edu"), 60);
        Event event4 = new Event(new Date("10/04/2023"), Timeslot.MORNING, Location.ARC103, new Contact(Department.MATH, "math@rutgers.edu"), 60);
        Event event5 = new Event(new Date("10/05/2023"), Timeslot.MORNING, Location.HLL114, new Contact(Department.ITI, "iti@rutgers.edu"), 60);
        Event event6 = new Event(new Date("10/06/2023"), Timeslot.MORNING, Location.BE_AUD, new Contact(Department.CS, "cs@rutgers.edu"), 60);
        Event event7 = new Event(new Date("10/07/2023"), Timeslot.MORNING, Location.ARC103, new Contact(Department.MATH, "math@rutgers.edu"), 60);
        Event event8 = new Event(new Date("10/08/2023"), Timeslot.MORNING, Location.AB2225, new Contact(Department.EE, "ee@rutgers.edu"), 60);
        Event event9 = new Event(new Date("10/09/2023"), Timeslot.MORNING, Location.HLL114, new Contact(Department.CS, "cs@rutgers.edu"), 60);
        Event event10 = new Event(new Date("10/10/2023"), Timeslot.MORNING, Location.TIL232, new Contact(Department.BAIT, "bait@rutgers.edu"), 60);

        EventCalendar calendar = new EventCalendar();
        System.out.println("Size of array: " + calendar.events.length);
        calendar.add(event10);
        System.out.println("Size of array: " + calendar.events.length);
        calendar.add(event9);
        System.out.println("Size of array: " + calendar.events.length);
        calendar.add(event8);
        System.out.println("Size of array: " + calendar.events.length);
        calendar.add(event7);
        System.out.println("Size of array: " + calendar.events.length);
        calendar.add(event6);
        System.out.println("Size of array: " + calendar.events.length);
        calendar.add(event5);
        System.out.println("Size of array: " + calendar.events.length);
        calendar.add(event4);
        System.out.println("Size of array: " + calendar.events.length);
        calendar.add(event3);
        System.out.println("Size of array: " + calendar.events.length);
        calendar.add(event2);
        System.out.println("Size of array: " + calendar.events.length);
        calendar.add(event1);
        System.out.println("Size of array: " + calendar.events.length);
        System.out.println();

        calendar.print();
        System.out.println("Number of events: " + calendar.numEvents);
        calendar.remove(event3);
        System.out.println("Removed event3");
        System.out.println("Number of events: " + calendar.numEvents);
        calendar.print();

        System.out.println();
        System.out.println("Test contains(event10): " + calendar.contains(event10));
        System.out.println("Test contains(event3): " + calendar.contains(event3));
        System.out.println();

        calendar.print();
        System.out.println("\nSort by Date\n");
        calendar.printDate();

        System.out.println("\nSort by Location\n");
        calendar.printLocation();

        System.out.println("\nSort by Department\n");
        calendar.printDepartment();

        System.out.println("\n\n--Test Complete--");
    }

    //EventCalendar()   working good
    //find()            working good
    //grow()            working good
    //Add()             working good
    //remove()          working good
    //contains()        working good
    //print()           working good
    //printDate()       working good
    //printLocation()   working good
    //printDepartment() working good
    //swap()            working good
    //sortDate()        working good
    //sortLocation()    working good
    //sortDepartment()  working good


}
