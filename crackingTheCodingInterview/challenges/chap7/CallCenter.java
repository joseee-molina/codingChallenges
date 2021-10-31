package chap7;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;

public class  CallCenter {
    public static boolean respondentOccupied;
    public static boolean managerOccupied;
    public static boolean directorOccupied;
    public static Instant managerTime;
    public static LocalDate respondentTime;
    public static Instant directorTime;
    public CallCenter(){

    }

    public static void dispatchCall(Call call){

        if(!respondentOccupied){
            respondentOccupied=true;
        }
        else if(!managerOccupied){
            managerOccupied=true;
        }
        else if (!directorOccupied){
            directorOccupied=true;
        }
        else{
            /**
             * wait
             */
        }

    }


}
