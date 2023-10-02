package project1;
//FIXME: remove unused imports before submitting
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Calendar;
import java.text.DecimalFormat;

//FIXME: enum Department INCORRECT OUTPUT - Only gives the acronym instead of the department
    //see 2_OOP.pdf pg. 20 for Enum example adn notes

/**
 * A class that represents the Department abstract data type with fields; acronym and fullName.
 * @author FelipePDaSilva, ZachJKoshy,
 */
public enum Department {
    CS("Computer Science"),
    EE ("Electrical Engineering"),
    ITI ("Information Technology and Informatics"),
    MATH ("Mathematics"),
    BAIT ("Business Analytics and Information Technology");
    private final String fullName;

    /**
     * Parameterized constructor for Department class.
     * @param fullName the full name of the department
     */
    Department (String fullName) {
        this.fullName = fullName;
    }

    /**
     * Returns the full name of the department.
     * @return the full name of the department
     */
    public String getFullName(){
        return this.fullName;
    }

    //Fil: Are you sure we have to remove it?
    //Fil: I thought all class file need to have their own "testbed" main driver method?
    //ZK: we may not have to remove it, although it's worth noting:
        //According to writeup:
        //Testbed main() in the following Java classes implementing the test cases listed in your test specification.
        //        (a) Date class [15 points]
        //        (b) Event class [5 points]
    //SO, we may not need to remove it, but testbed main()'s aren't required for other classes,
    // although they are still helpful for troubleshooting

    /**
     * Testbed main() for Department class.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Department: " + Department.CS);
        System.out.println("Department: " + Department.EE);
        System.out.println("Department: " + Department.ITI);
        System.out.println("Department: " + Department.MATH);
        System.out.println("Department: " + Department.BAIT);

        System.out.println("Department: " + Department.CS.fullName);
        System.out.println("Department: " + Department.EE.fullName);
        System.out.println("Department: " + Department.ITI.fullName);
        System.out.println("Department: " + Department.MATH.fullName);
        System.out.println("Department: " + Department.BAIT.fullName);
    }
}
