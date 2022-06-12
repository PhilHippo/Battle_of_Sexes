import java.util.Random;

public class Coy extends Female {

    Random random = new Random();

    public Coy () {
        super(2);
    }

    @Override
    public void run() {
        try {
            sleep(5); // troppo irrequieti
            super.run();

        } catch (InterruptedException e) {
        }
    }

    @Override
    public synchronized void giveBirth(Male gentleman) throws InterruptedException {

        if (isFaithful(gentleman.type)){
            sleep(10);
            gentleman.sleep(10);
            gentleman.points += (Population.a- Population.b/2- Population.c);
            this.points += (Population.a- Population.b/2- Population.c);

            if(random.nextBoolean()){
                Coy ind = new Coy();
                ind.start();
            }else{
                Faithful ind = new Faithful();
                ind.start();
            }
        }
        this.numberChildren++;
        gentleman.numberChildren++;
        this.notify();
    }
}
