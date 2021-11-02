package chap7;

import java.time.Instant;
import java.time.Duration;

public class ParkingLot {
    int capacity;
    ParkingLotSpace[] places;
    int charge;

    public ParkingLot(int cap, ParkingLotSpace[] places){
        capacity=cap;
        this.places=places;
    }

    /**
     * Places names can be like A1, A2, ... B1, B2, ... and so on
     *
     */

    /**
     * Occupy first unoccupied place
     */
    public void occupyPlace(int i){
        if(places[i].occupied) {
            System.out.println("This place is occupied, choose another one please");
            return;
        }
        places[i].occupied=true;
        places[i].usedFrom= Instant.now();
    }

    public void disoccupyPlace(int i){
        if(!places[i].occupied){
            System.out.println("Not occupied, cannot do this op");
            return;
        }
        Instant now = Instant.now();
        long secondsOccupied = now.getEpochSecond() -places[i].usedFrom.getEpochSecond();
        long minutesOccupied = secondsOccupied/60;
    }


}
