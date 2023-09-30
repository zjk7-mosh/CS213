package project1;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Calendar;
import java.text.DecimalFormat;

public class EventCalendar {
    private Event [] events; //the array holding the list of events
    private int numEvents; //current number of events in the array

//  ...

    private int find(Event event) {
        //search an event in the list
        return 0;
    }
    private void grow() { } //increase the capacity by 4
    public boolean add(Event event) {
        //add an event to the list
        return true;
    }
    public boolean remove(Event event) {
        //remove an event from the list
        return true;
    }
    public boolean contains(Event event) {
        //check if the event is in the list
        return true;
    }
    public void print() {
        //print the array as is
        System.out.println(events.toString()); //may be incorrect
    }
    public void printByDate() { } //ordered by date and timeslot
    public void printByCampus() { } //ordered by campus and building/room
    public void printByDepartment(){ } //ordered by department




}
