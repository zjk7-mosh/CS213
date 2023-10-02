package project1;

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

    DateConstants (int max){
        this.max = max;
    }

    public int getMax(){
        return this.max;
    }
}
