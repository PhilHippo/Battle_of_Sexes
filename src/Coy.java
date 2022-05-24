import java.util.ArrayList;
import java.util.Random;


public class Coy  extends Female{
    public Coy(double points,Population p){
        super(2, points, p);
    }

    public synchronized void mutation(Individual partner, Population p, double points_for_kids) throws InterruptedException{
        Random x = new Random();
        // x%2 == 0 Philanderer
        // x%2 == 1 Fast
        if(x.nextInt(1,10)%2==0){
            new Philanderer(points_for_kids,p).start();
        }else{
            new Fast(points_for_kids,p).start();
        }
    }


}
