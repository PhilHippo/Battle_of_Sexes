import java.util.Random;

public class Fast extends Female {

    Random random = new Random();

    public Fast() {
        super(3);
    }

    @Override
    public void run() {
        try {
            sleep(0);//14
            super.run();

        } catch (InterruptedException e) {
        }
    }

    @Override
    public synchronized void giveBirth(Male gentleman) throws InterruptedException {

        if (isPhilanderer(gentleman.type)){
            gentleman.points += Population.a;
            this.points += (Population.a- Population.b);

            if(random.nextBoolean()){
                Fast pers = new Fast();
                pers.start();
            }
            else {
                Philanderer pers = new Philanderer();
                pers.start();
            }
        }

        if (isFaithful(gentleman.type)){
            gentleman.sleep(0);
            gentleman.points += (Population.a- Population.b/2);
            this.points += (Population.a- Population.b/2);

            if(random.nextBoolean()){
                Fast pers = new Fast();
                pers.start();
            }
            else{
                Faithful pers = new Faithful();
                pers.start();
            }
        }
        this.numberChildren++;
        gentleman.numberChildren++;
        this.notify();
    }
}
