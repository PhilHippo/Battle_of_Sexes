import java.util.ArrayList;

public class MyList extends ArrayList<Female> {

    public synchronized void push(Female female) throws InterruptedException {
        this.add(female);
        System.out.println("I'm in the club");
        notifyAll();
    }

    public synchronized Female pop() {
        if (this.isEmpty()) {
            try {
                System.out.println("Where is everybody?");
                wait();
            } catch (InterruptedException ignored) {}
        }
        return this.remove(0);
    }

    public void print() {
        for (Female f : this) {
            System.out.print(f.getName());
        }
    }
}
