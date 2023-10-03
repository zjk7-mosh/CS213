package project1;

//FIXME: might want to add to javadoc comments before submission
/**
 * Enum class that holds DateConstants for each month of the year and the full year.
 * @author FelipePDaSilva, ZachJKoshy
 */
public enum DateConstants {

    JANUARY (31),
    FEBRUARY (28),
    MARCH (31),
    APRIL (30),
    MAY (31),
    JUNE (30),
    JULY (31),
    AUGUST (31),
    SEPTEMBER (30),
    OCTOBER (31),
    NOVEMBER (30),
    DECEMBER (31),
    FULLYEAR (12);

    private final int max;

    /**
     * Parameterized constructor for DateConstants class.
     * @param max the max number of days in a month
     */
    DateConstants (int max){
        this.max = max;
    }

    /**
     * Returns the max number of days in a month.
     * @return the max number of days in a month
     */
    public int getMax(){
        return this.max;
    }
/*

    public static int monthMax(int month) { //FIXME: does this indentation of a helper method meet codingStandard?
        switch (month) {
            case 1 -> {return DateConstants.JANUARY.getMax();}
            case 2 -> {return DateConstants.FEBRUARY.getMax();}
            case 3 -> {return DateConstants.MARCH.getMax();}
            case 4 -> {return DateConstants.APRIL.getMax();}
            case 5 -> {return DateConstants.MAY.getMax();}
            case 6 -> {return DateConstants.JUNE.getMax();}
            case 7 -> {return DateConstants.JULY.getMax();}
            case 8 -> {return DateConstants.AUGUST.getMax();}
            case 9 -> {return DateConstants.SEPTEMBER.getMax();}
            case 10 -> {return DateConstants.OCTOBER.getMax();}
            case 11 -> {return DateConstants.NOVEMBER.getMax();}
            case 12 -> {return DateConstants.DECEMBER.getMax();}
        }
        return 31;
    }
    */


}
