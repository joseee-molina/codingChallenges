package chap7;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.Temporal;
import java.time.temporal.ChronoUnit;

public class Call {
    Duration d;

    public Call(int durationTime){
        d = Duration.ofSeconds(durationTime);
    }

}
