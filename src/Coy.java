import java.util.Random;

public class Coy extends Female {
    Random random = new Random();

    public Coy () {
        super(2);
    }

    @Override
    public void run() {
        super.run();
    }

    @Override
    public synchronized void giveBirth(Male gentleman){

        if (isPhilanderer(gentleman.type)){
            gentleman.points += (a-b/2-c);
            if(random.nextBoolean()){
                Coy ind = new Coy();
                ind.start();
            }else{
                Philanderer ind = new Philanderer();
                ind.start();

            }

        }
        if (isFaithful(gentleman.type)){

        }

        this.notify();
    }
}
