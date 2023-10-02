package project1;
//FIXME: remove unused imports before submitting
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Calendar;
import java.text.DecimalFormat;

/**
 * A class that represents the Contact abstract data type with fields; department and email.
 * @author FelipePDaSilva, ZachJKoshy,
 */
public class Contact implements Comparable<Contact>{
    private Department department;
    private String email;

    /**
     * Test constructor for Contact class.
     */
    public Contact(){   // Good
        this.department = Department.CS;
        this.email = "cs@rutgers.edu";
    }

    /**
     * Parameterized constructor for Contact class, which takes a department and email.
     * @param department the department
     * @param email the email
     */
    public Contact(Department department, String email){ // Good
        this.department = department;
        this.email = email;
    }

    /**
     * Checks if the contact is valid.
     * @return true if the contact is valid, false otherwise
     */
    public boolean isValid() {
        //FIXME: Is this complete?
            //FIXME: implement proper code "could not figure it out yet"
        if((this.department == Department.EE && this.email.equals("ee@rutgers.edu")) ||
                (this.department == Department.MATH && this.email.equals("math@rutgers.edu")) ||
                (this.department == Department.CS && this.email.equals("cs@rutgers.edu")) ||
                (this.department == Department.BAIT && this.email.equals("bait@rutgers.edu")) ||
                (this.department == Department.ITI && this.email.equals("iti@rutgers.edu")) ) {
            return true;
        }
        return false;
    }

    /**
     * returns the department and email of the contact as a string.
     * @return the department and email of the contact as a string
     */
    @Override
    public String toString(){
        return department.getFullName() + ", " + email;
    }

    /**
     * Compares two Contacts to see if they are equal.
     * @param contact the object to be compared.
     * @return 0 if the objects are equal, -1 if the object is less than the argument, 1 if the object is greater than the argument
     */
    @Override
    public int compareTo(Contact contact){
        return this.department.getFullName().compareTo(contact.department.getFullName());
    }

    /**
     * Testbed main() for Contact class.
     * @param args the command line arguments
     */
    public static void main(String[] args){
        System.out.println("\n--Testing Contact.java class--");

        Contact defaultContact = new Contact();
        Contact cs = new Contact(Department.CS, "cs@rutgers.edu");
        Contact math = new Contact(Department.MATH, "math@rutgers.edu");
        Contact ee = new Contact(Department.EE, "ee@rutgers.edu");
        Contact bait = new Contact(Department.BAIT, "bait@rutgers.edu");
        Contact iti = new Contact(Department.ITI, "iti@rutgers.edu");

        System.out.println("Test isValid():\t\t" + defaultContact.isValid());
        System.out.println("Test toString():\t" + defaultContact.toString());

        System.out.println("Test isValid():\t\t" + cs.isValid());
        System.out.println("Test toString():\t" + cs.toString());

        System.out.println("Test isValid():\t\t" + math.isValid());
        System.out.println("Test toString():\t" + math.toString());

        System.out.println("Test isValid():\t\t" + ee.isValid());
        System.out.println("Test toString():\t" + ee.toString());

        System.out.println("Test isValid():\t\t" + bait.isValid());
        System.out.println("Test toString():\t" + bait.toString());

        System.out.println("Test isValid():\t\t" + iti.isValid());
        System.out.println("Test toString():\t" + iti.toString());

        System.out.println("--Test Complete--");
    }
}
