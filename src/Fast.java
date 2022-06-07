import java.util.Random;

public class Fast extends Female {

    Random random = new Random();

    public Fast() {
        super(3);
    }

    @Override
    public void run() {
        super.run();
    }

    @Override
    public synchronized void giveBirth(Male gentleman){

        if (isPhilanderer(gentleman.type)){

            gentleman.points += a;
            this.points += (a-b);

            if(random.nextBoolean()){
                Fast ind = new Fast();
                ind.start();
            }
            else {
                Philanderer ind = new Philanderer();
                ind.start();
            }
        }

        if (isFaithful(gentleman.type)){

            gentleman.points += (a-b/2);
            this.points += (a-b/2);

            if(random.nextBoolean()){
                Fast ind = new Fast();
                ind.start();
            }
            else{
                Faithful ind = new Faithful();
                ind.start();
            }
        }

        this.notify();
    }
}
