import java.util.Random;

public class Coy extends Female {

    Random random = new Random();

    public Coy () {
        super(2);
    }

    @Override
    public void run() {
        try {
            sleep(20); //12 troppo irrequieti
            super.run();

        } catch (InterruptedException e) {
        }
    }

    @Override
    public synchronized void giveBirth(Male gentleman) throws InterruptedException {

        if (isFaithful(gentleman.type)){
            sleep(30);
            gentleman.sleep(30);
            gentleman.points += (Population.a- Population.b/2- Population.c);
            this.points += (Population.a- Population.b/2- Population.c);

            if(random.nextBoolean()){
                new Coy().start();
            }else{
                new Faithful().start();
            }
        }
        this.numberChildren++;
        gentleman.numberChildren++;
        this.notify();
    }
}
