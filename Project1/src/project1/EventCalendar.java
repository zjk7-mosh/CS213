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
        for(Event e : events) {
            if(e != null) {
                System.out.println(e.toString()); //FIXME: may be incorrect //FIXME: should work now
            }
        }
    }

    /** FIXME: add javadoc comments */
    //FIXME: incomplete method, must write body
    public void printByDate() { } //ordered by date and timeslot

    /** FIXME: add javadoc comments */
    //FIXME: incomplete method, must write body
    public void printByCampus() { } //ordered by campus and building/room

    /** FIXME: add javadoc comments */
    //FIXME: incomplete method, must write body
    public void printByDepartment(){ } //ordered by department


    //FIXME: NOT COMPLETE
    //Still need to test this method
    private void sortDate(Event[] events) {
        int n = events.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (events[j].getDate().compareTo(events[j + 1].getDate()) > 0) {
                    // Swap people[j] with people[j+1]
                    Event temp = events[j];
                    events[j] = events[j + 1];
                    events[j + 1] = temp;

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
    private void sortLocation(Event[] events) {
        int n = events.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (events[j].getDate().compareTo(events[j + 1].getDate()) > 0) {
                    // Swap people[j] with people[j+1]
                    Event temp = events[j];
                    events[j] = events[j + 1];
                    events[j + 1] = temp;

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
        Event event1 = new Event(new Date("10/01/2023"), Timeslot.MORNING, Location.ARC103, new Contact(), 60);
        Event event2 = new Event(new Date("10/02/2023"), Timeslot.MORNING, Location.ARC103, new Contact(), 60);
        Event event3 = new Event(new Date("10/03/2023"), Timeslot.MORNING, Location.ARC103, new Contact(), 60);
        Event event4 = new Event(new Date("10/04/2023"), Timeslot.MORNING, Location.ARC103, new Contact(), 60);
        Event event5 = new Event(new Date("10/05/2023"), Timeslot.MORNING, Location.ARC103, new Contact(), 60);
        Event event6 = new Event(new Date("10/06/2023"), Timeslot.MORNING, Location.ARC103, new Contact(), 60);
        Event event7 = new Event(new Date("10/07/2023"), Timeslot.MORNING, Location.ARC103, new Contact(), 60);
        Event event8 = new Event(new Date("10/08/2023"), Timeslot.MORNING, Location.ARC103, new Contact(), 60);
        Event event9 = new Event(new Date("10/09/2023"), Timeslot.MORNING, Location.ARC103, new Contact(), 60);
        Event event10 = new Event(new Date("10/10/2023"), Timeslot.MORNING, Location.ARC103, new Contact(), 60);

        EventCalendar calendar = new EventCalendar();
        System.out.println("Size of array: " + calendar.events.length);
        calendar.add(event1);
        System.out.println("Size of array: " + calendar.events.length);
        calendar.add(event2);
        System.out.println("Size of array: " + calendar.events.length);
        calendar.add(event3);
        System.out.println("Size of array: " + calendar.events.length);
        calendar.add(event4);
        System.out.println("Size of array: " + calendar.events.length);
        calendar.add(event5);
        System.out.println("Size of array: " + calendar.events.length);
        calendar.add(event6);
        System.out.println("Size of array: " + calendar.events.length);
        calendar.add(event7);
        System.out.println("Size of array: " + calendar.events.length);
        calendar.add(event8);
        System.out.println("Size of array: " + calendar.events.length);
        calendar.add(event9);
        System.out.println("Size of array: " + calendar.events.length);
        calendar.add(event10);
        System.out.println("Size of array: " + calendar.events.length);

        System.out.println();
        System.out.println(calendar.events[0]);
        System.out.println(calendar.events[1]);
        System.out.println(calendar.events[2]);
        System.out.println(calendar.events[3]);
        System.out.println(calendar.events[4]);
        System.out.println(calendar.events[5]);
        System.out.println(calendar.events[6]);
        System.out.println(calendar.events[7]);
        System.out.println(calendar.events[8]);
        System.out.println(calendar.events[9]);

        System.out.println(calendar.numEvents);
        calendar.remove(event3);
        System.out.println(calendar.numEvents);

        System.out.println(calendar.events[0]);
        System.out.println(calendar.events[1]);
        System.out.println(calendar.events[2]);
        System.out.println(calendar.events[3]);
        System.out.println(calendar.events[4]);
        System.out.println(calendar.events[5]);
        System.out.println(calendar.events[6]);
        System.out.println(calendar.events[7]);
        System.out.println(calendar.events[8]);
        System.out.println(calendar.events[9]);

        System.out.println("Test contains(event10): " + calendar.contains(event10));
        System.out.println("Test contains(event3): " + calendar.contains(event3));

        System.out.println("\n");
        calendar.print();

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
