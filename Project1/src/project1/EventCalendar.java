package project1;
//FIXME: remove unused imports before submitting
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Calendar;
import java.text.DecimalFormat;

/** FIXME: add javadoc comments */
public class EventCalendar {
    private Event[] events; //the array holding the list of events
    private int numEvents; //current number of events in the array

    //  ... may need to add other attributes and methods
    public EventCalendar(){
        this.events = new Event[4];
        this.numEvents = 0;
    }

    /** FIXME: add javadoc comments */
    //FIXME: incomplete method, must write body
    private int find(Event event) {
        //search an event in the list
        for(int i = 0; i < numEvents; i++){
            if(events[i].equals(event)){
                return i;
            }
        }
        return -1;
    }
    /** FIXME: add javadoc comments */
    //FIXME: incomplete method, must write body
    private void grow() {
        //increase the capacity by 4
        Event[] copy = new Event[numEvents + 4];
        for(int i = 0; i < numEvents; i++){
            copy[i] = events[i];
        }
        events = copy;
        copy = null;
    }

    /** FIXME: add javadoc comments */
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

    /** FIXME: add javadoc comments */
    // remove() method working properly!!!!!
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

    /** FIXME: add javadoc comments */
    //FIXME: is this complete?
    public boolean contains(Event event) {
        //check if the event is in the list
       if(find(event) != -1){
           return true;
       }
       return false;
    }

    /** FIXME: add javadoc comments */
    public void print() {
        //print the array as is
        for(Event event : events) {
            if(event != null) {
                System.out.println(event.toString());
            }
        }
    }

    /** FIXME: add javadoc comments */
    //FIXME: incomplete method, must write body
    public void printDate() {
        sortDate();
        print();
    } //ordered by date and timeslot

    /** FIXME: add javadoc comments */
    //FIXME: incomplete method, must write body
    public void printLocation() {
        sortLocation();
        print();
    } //ordered by campus and building/room

    /** FIXME: add javadoc comments */
    //FIXME: incomplete method, must write body
    public void printDepartment(){
        sortDepartment();
        print();
    } //ordered by department

    /** FIXME: add javadoc comments*/
    //FIXME: created this private swap() helper method to reduce the code in each sort() method
    private void swap(int a){
        Event temp = events[a];
        events[a] = events[a + 1];
        events[a + 1] = temp;
    }

    //FIXME: Sorting modes - functionality NOT COMPLETE
    //Need to implement 3 sorting MODES; by date, location(campus/building/room), and department
    //current implementation is using 3 separate methods for each mode
    //another possible implementation is using enums to determine the sorting mode
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



    public static void main(String[] args){

        System.out.println(("--Test EventCalender.java--\n"));
        //public Event(Date date, Timeslot startTime, Location location, Contact contact, int duration)
        Event event1 = new Event(new Date("10/01/2023"), Timeslot.MORNING, Location.BE_AUD, new Contact(), 60);
        Event event2 = new Event(new Date("10/02/2023"), Timeslot.MORNING, Location.TIL232, new Contact(), 60);
        Event event3 = new Event(new Date("10/03/2023"), Timeslot.MORNING, Location.MU302, new Contact(), 60);
        Event event4 = new Event(new Date("10/04/2023"), Timeslot.MORNING, Location.ARC103, new Contact(), 60);
        Event event5 = new Event(new Date("10/05/2023"), Timeslot.MORNING, Location.HLL114, new Contact(), 60);
        Event event6 = new Event(new Date("10/06/2023"), Timeslot.MORNING, Location.BE_AUD, new Contact(), 60);
        Event event7 = new Event(new Date("10/07/2023"), Timeslot.MORNING, Location.ARC103, new Contact(), 60);
        Event event8 = new Event(new Date("10/08/2023"), Timeslot.MORNING, Location.AB2225, new Contact(), 60);
        Event event9 = new Event(new Date("10/09/2023"), Timeslot.MORNING, Location.HLL114, new Contact(), 60);
        Event event10 = new Event(new Date("10/10/2023"), Timeslot.MORNING, Location.TIL232, new Contact(), 60);

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

    //Add() working good
    //grow() working good
    //remove() working good
    //contains() working good
    //print() working good

    //printByDate() not implemented
    //printByCampus() not implemented
    //printByDepartment() not implemented
    //sort() not implemented


}
