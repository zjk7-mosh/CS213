package project1;

//FIXME: might want to add to javadoc comments before submission
/**
 * A class that holds DateConstants
 * //add more here
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
}
