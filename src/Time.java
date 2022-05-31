import java.util.ArrayList;
import java.util.Arrays;


//this class controls the behaviour of the people by letting them copulate during day and we save the current data during night
public class Time {

    public static Boolean day = true;

    public static void dayTime(int millis) throws InterruptedException{
        Thread.currentThread().sleep(millis);
        day = false;
    }

    public static void nightTime(Population p, ArrayList<int[]> trend_population, ArrayList<Integer> X_time, int counter) throws InterruptedException{
        p.iterazione++;
        System.out.println(Arrays.toString(Population.n_individuals));
        trend_population.add(Population.n_individuals.clone());
        X_time.add(counter);
        day = true;
    }
}
