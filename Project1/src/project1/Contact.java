package project1;
//FIXME: remove unused imports before submitting
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Calendar;
import java.text.DecimalFormat;

/** FIXME: add javadoc comments */
public class Contact {
    private Department department;
    private String email;

    /** A default constructor that creates a new contact. */
    public Contact(){
        this.department = Department.CS;
        this.email = "default@rutgers.edu";
    }

    /** A parameterized constructor that takes a string in a form of "mm/dd/yyyy". ...*/
    public Contact(Department department, String email){
        this.department = department;
        this.email = email;
    }

    public boolean isValid() {
        //FIXME: implement proper code "could not figure it out yet"
        return false;
    }

    @Override
    public String toString(){
        return "Contact: " + department + ", " + email;
    }

    public static void main(String[] args){
        System.out.println("\n--Testing Contact.java class--");

        Contact defaultContact = new Contact();
        Contact Zach = new Contact(Department.CS, "Zach@rutgers.edu");
        Contact Felipe = new Contact(Department.CS, "Felipe@rutgers.edu");

        System.out.println("Test isValid():\t\t" + Felipe.isValid());
        System.out.println("Test toString():\t" + Zach.toString());

        System.out.println("--Test Complete--");
    }
}
