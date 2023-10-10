package com.pluralsight.calcengine.classesandobjects;

public class Flight {

    //State of the class
   private int passengers;
    private int seats = 150;

    private int flightNumber;
    private char flightClass;
    private boolean[] isSeatAvailable = new boolean[seats];



    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }




    {
        for (int i = 0; i < seats; i++) {
            isSeatAvailable[i] = true;
        }
    }

    public boolean hasRoom(Flight f2) {
     int total = this.passengers + f2.passengers;
     return total <= seats;
    }

   // Methods
   public void add1Passenger() {
        if(passengers < seats) {
            passengers += 1;
        } else {
            handleTooMany();
        }
    }

    private void handleTooMany() {
        System.out.println("Too many passengers");
    }
}
