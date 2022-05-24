import java.util.ArrayList;
import java.util.Random;

public class Fast extends Female{
    public Fast(double points, Population p) {
        super(3, points, p);
    }

    public synchronized void mutation(Individual partner, Population p, double points_for_kids) throws InterruptedException{
        Random x = new Random();
        // x%2 == 0 Faithful
        // x%2 == 1 Coy
        if(x.nextBoolean()){
            new Faithful(points_for_kids,p).start();
        }else{
            new Coy(points_for_kids,p).start();
        }
    }




}
