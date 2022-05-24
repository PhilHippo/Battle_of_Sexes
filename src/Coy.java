import java.util.ArrayList;
import java.util.Random;


public class Coy  extends Female{
    public Coy(double points,Population p){
        super(2, points, p);
    }

    public synchronized void mutation(Individual partner, Population p, double points_for_kids) throws InterruptedException {
        Random x = new Random();

        if (x.nextBoolean()) {
            new Philanderer(points_for_kids, p).start();
        } else {
            new Fast(points_for_kids, p).start();
        }
    }
}
