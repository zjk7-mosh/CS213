package project1;
/** //bs: ADD Javadoc comments. */
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


    public static void main(String[] args) {
        System.out.println("Department: " + Department.CS);
        System.out.println("Department: " + Department.EE);
        System.out.println("Department: " + Department.ITI);
        System.out.println("Department: " + Department.MATH);
        System.out.println("Department: " + Department.BAIT);
    }
}
