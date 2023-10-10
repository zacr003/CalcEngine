package com.pluralsight.calcengine.classesandobjects;

public class Passenger {

    private int checkedBags;
    private int freeBags;
    private double perBagFee;

    // Chaining constructors

    public Passenger() {

    }

    public Passenger(int freeBags) {
        this(freeBags > 1 ? 25.0f : 50.d);
        this.freeBags = freeBags;
    }
    public Passenger(int freeBags, int checkedBags) {
        this(freeBags);
        this.checkedBags = checkedBags;

    }

    private Passenger(double perBagFee) {
        this.perBagFee = perBagFee;
    }

    //getters and setters
    public int getCheckedBags() {
        return checkedBags;
    }

    public void setCheckedBags(int checkedBags) {
        this.checkedBags = checkedBags;
    }

    public int getFreeBags() {
        return freeBags;
    }

    public void setFreeBags(int freeBags) {
        this.freeBags = freeBags;
    }


}
