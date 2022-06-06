import java.io.IOException;

public class Main {

    public static boolean run = true;

    /*  TYPES
    PHILANDERER 0
    FAITHFUL 1
    COY 2
    FAST 3
     */

    public static void main(String[] args) throws InterruptedException, IOException {

        Population p = new Population(10,10,10,10);
        Population.printMalesFemalesTot(); // initial condition

        int i = 0;
        Time.nightTime(i);
        while (i < 10) {
            i++;
            Time.dayTime(50); // true
            Time.nightTime(i); // false
            //Thread.sleep(1000);

        }
        Main.run = false;
        //Population.wakeUpEverybody();

        Thread bodyGuard = new Thread(() -> {
            synchronized (Population.club) {
                Population.club.notifyAll();
            }
            for (Female f : Population.club) {
                f.interrupt();
            }

            Population.printMatrix(Population.matrixCalculator(Individual.a, Individual.b, Individual.c));
            System.out.println("The club is CLOSED, GET ALL THE FUCK OUT!");
        });



        bodyGuard.start();
        Population.printMalesFemalesTot();
        Population.printChart();
        //System.out.println(Population.trendPopulation.toString());
    }
}
