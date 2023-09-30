package project1;
//FIXME: remove unused imports before submitting
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Calendar;
import java.text.DecimalFormat;

/** FIXME: add javadoc comments */
public enum Location {
    HLL114("Hill Center, Busch"),
    ARC103("Allison Road, Busch"),
    BE_AUD("Beck Hall, Livingston"),
    TIL232("Tillett Hall, Livingston"),
    AB2225("Academic Building, College Avenue"),
    MU302("Murray Hall, College Avenue");
    private final String campus;

    public String getCampus(){
        return campus;
    }
    Location(String campus) {
        this.campus = campus;
    }

    //FIXME: REMOVE THIS MAIN METHOD BEFORE SUBMIT
    //Are you sure we have to remove it?
    //I thought all class file need to have their own "testbed" main driver method?
    public static void main(String[] args) {
        System.out.println("Location: " + Location.AB2225);
        System.out.println("Location: " + Location.ARC103);
        System.out.println("Location: " + Location.BE_AUD);
        System.out.println("Location: " + Location.MU302);
        System.out.println("Location: " + Location.HLL114);

        System.out.println("Location: " + Location.AB2225.campus);
        System.out.println("Location: " + Location.ARC103.campus);
        System.out.println("Location: " + Location.BE_AUD.campus);
        System.out.println("Location: " + Location.MU302.campus);
        System.out.println("Location: " + Location.HLL114.campus);
    }
}
