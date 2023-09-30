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
    //FIXME: incomplete method, must write body
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
    //FIXME: incomplete method, must write body
    //FIXME: UNTESTED, but I think it should be working fine.
    //FIXME: The idea for removing an event from any location is to set it equal to the next event instead,
    //FIXME: and go down the array setting each event equal to the next until we hit null
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
    //FIXME: incomplete method, must write body
    public boolean contains(Event event) {
        //check if the event is in the list

        return true;
    }

    /** FIXME: add javadoc comments */
    public void print() {
        //print the array as is
        System.out.println(events.toString()); //FIXME: may be incorrect
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


    //FIXME: Implement Sorting method
    private void sort(){

    }

    public static void main(String[] args){

        System.out.println(("--Test EventCalender.java--\n"));
        Event event1 = new Event();
        Event event2 = new Event();
        Event event3 = new Event();
        Event event4 = new Event();
        Event event5 = new Event();

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

        //Add() working good
        //grow() working good

        System.out.println("\n\n--Test Complete--");
    }



}
