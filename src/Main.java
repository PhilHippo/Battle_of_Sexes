import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static boolean untilEquilibriumReached = true;

    /*  TYPES
    PHILANDERER 0
    FAITHFUL 1
    COY 2
    FAST 3
     */

    public static void main(String[] args) throws InterruptedException, IOException {

        Population p = new Population(100,100,100,100,15 , 20, 3, 30);
        Population.printMalesFemalesTot(); // initial condition
        Population.updateGraph(0); // graph at time zero

        int i = 0;
        while (i < 100) {
            i++;
            Time.dayTime(30); // true
            Time.nightTime(i); // false
            //Population.printMalesFemalesTot();
            //coy should be 83%, faithful should be 62%
        }
        Main.untilEquilibriumReached = false;

        Thread bodyGuard = new Thread(() -> {
            synchronized (Population.club) {
                Population.club.notifyAll();
            }
            for (Female f : Population.club) {
                f.interrupt();
            }

            System.out.println("The club is CLOSED!");
        });

        bodyGuard.start();
        //Thread.sleep(100); // just to wait for the bodyguard to finish
        System.out.println(); // so the prints at the end are in order and separated
        System.out.println(Arrays.toString(Population.numberIndividuals));
        Population.printMalesFemalesTot();
        //Population.printMatrix(Population.matrixCalculator());
        Population.printChart();
    }
}
