package project1;
//FIXME: remove unused imports before submitting
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Calendar;
import java.text.DecimalFormat;

//FIXME: enum Department INCORRECT OUTPUT - Only gives the acronym instead of the department
    //see 2_OOP.pdf pg. 20 for Enum example adn notes
/** FIXME: add javadoc comments */
public enum Department {
    CS("computer science"),
    EE ("electrical engineering"),
    ITI ("information technology and informatics"),
    MATH ("mathematics"),
    BAIT ("business analytics and information technology");
    private final String fullname;

    Department (String fullname) {
        this.fullname = fullname;
    }

    //FIXME: REMOVE THIS MAIN METHOD BEFORE SUBMIT
    public static void main(String[] args) {
        System.out.println("Department: " + Department.CS);
        System.out.println("Department: " + Department.EE);
        System.out.println("Department: " + Department.ITI);
        System.out.println("Department: " + Department.MATH);
        System.out.println("Department: " + Department.BAIT);
    }
}
