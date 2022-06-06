import java.util.ArrayList;
import java.util.Arrays;

// this class alternates day and night
// day: individuals copulate
// night: we collect data while individuals sleep
public class Time {

    public static volatile Boolean day = false;
    // true = day
    // false = night

    public static void dayTime(long millis) throws InterruptedException{
        day = true;
        //System.out.println("It is day");
        Thread.sleep(millis);
    }

    public static void nightTime(int gen){
        day = false;
        //System.out.print("It is night ");
        System.out.println(Arrays.toString(Population.numberIndividuals));
        Population.updateTrendPopulation();
        Population.X_time.add(gen);
    }
}
