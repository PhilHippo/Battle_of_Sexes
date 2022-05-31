import java.util.ArrayList;
import java.util.Arrays;

// this class alternates day and night
// day: individuals copulate
// night: we collect data while individuals sleep
public class Time {

    public static Boolean day = true;
    // true = day
    // false = night

    public static void dayTime(long millis) throws InterruptedException{
        Thread.sleep(millis);
        day = false; // becomes night

    }

    public static void nightTime(Population p, ArrayList<int[]> trend_population, ArrayList<Integer> X_time, int counter){
        p.iterazione++;
        System.out.println(Arrays.toString(Population.n_individuals));
        trend_population.add(Population.n_individuals.clone());
        X_time.add(counter);

        day = true; // becomes day
    }
}
