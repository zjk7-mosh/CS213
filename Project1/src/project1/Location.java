package project1;
//FIXME: remove unused imports before submitting
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Calendar;
import java.text.DecimalFormat;

//FIXME: This enum isn't correctly implemented.

//FIXME: might want to add to this javadoc comment before submission
/**
 * Enum class represents the different Locations where an event can take place.
 * @author FelipePDaSilva, ZachJKoshy
 */
public enum Location {
    HLL114("Hill Center, Busch"),
    ARC103("Allison Road, Busch"),
    BE_AUD("Beck Hall, Livingston"),
    TIL232("Tillett Hall, Livingston"),
    AB2225("Academic Building, College Avenue"),
    MU302("Murray Hall, College Avenue");
    private final String campus;

    /**
     * Returns the campus of the location.
     * @return the campus of the location
     */
    public String getCampus(){
        return campus;
    }

    /**
     * Parameterized constructor for Location class.
     * @param campus the campus
     */
    Location(String campus) {
        this.campus = campus;
    }

    /**
     * Testbed main() for enum Location class.
     * @param args the command line arguments
     */
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
