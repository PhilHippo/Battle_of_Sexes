import java.util.ArrayList;
import java.util.Random;

public class MyList extends ArrayList<Female> {

    public synchronized void push(Female female) {
        this.add(female);
        //System.out.println("I'm in the club");
        notifyAll();
    }

    public synchronized Female pop() throws InterruptedException{
        while (this.isEmpty()) {
            if (!Main.untilEquilibriumReached) throw new InterruptedException(); // the club has been closed
            //System.out.println("Where is everybody?");
            wait();
        }
        Random r = new Random();
        //r.nextInt(0, this.size())
        return this.remove(this.size()-1);
    }
}
