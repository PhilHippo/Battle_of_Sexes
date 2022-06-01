import java.util.ArrayList;

public class MyList extends ArrayList<Female> {

    public synchronized void push(Female female) {
        this.add(female);
        //System.out.println("I'm in the club");
        notifyAll();
    }

    public synchronized Female pop() throws InterruptedException{
        while (this.isEmpty()) {
            if (!Main.run) throw new InterruptedException(); // the club has been closed
            //System.out.println("Where is everybody?");
            wait();
        }
        return this.remove(0);
    }
}
