import java.util.Random;

public class Fast extends Female {

    Random random = new Random();

    public Fast() {
        super(3);
    }

    @Override
    public void run() {
        try {
            sleep(10);
            super.run();

        } catch (InterruptedException e) {
        }
    }

    @Override
    public synchronized void giveBirth(Male gentleman){

        if (isPhilanderer(gentleman.type)){
            gentleman.points += Population.a;
            this.points += (Population.a- Population.b);

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

            gentleman.points += (Population.a- Population.b/2);
            this.points += (Population.a- Population.b/2);

            if(random.nextBoolean()){
                Fast ind = new Fast();
                ind.start();
            }
            else{
                Faithful ind = new Faithful();
                ind.start();
            }
        }
        this.numberChildren++;
        gentleman.numberChildren++;
        this.notify();
    }
}
