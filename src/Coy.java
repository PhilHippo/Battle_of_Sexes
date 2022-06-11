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
    public synchronized void giveBirth(Male gentleman) throws InterruptedException{

        if (isFaithful(gentleman.type)){

            gentleman.points += (a-b/2-c);
            this.points += (a-b/2-c);
            //sleep(10); // courtship

            if(random.nextBoolean()){
                Coy ind = new Coy();
                ind.start();
            }
            else{
                Faithful ind = new Faithful();
                ind.start();
            }

            this.numberChildren++;
            gentleman.numberChildren++;
        }

        if (isPhilanderer(gentleman.type)){

            gentleman.points += a;
            this.points += (a-b);

            if(random.nextBoolean()){
                Coy ind = new Coy();
                ind.start();
            }
            else {
                Philanderer ind = new Philanderer();
                ind.start();
            }
        }



        //TODO
        // if (isPhilanderer(gentleman.type)) {}

        this.notify();
    }
}
