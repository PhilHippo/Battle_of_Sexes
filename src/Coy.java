import java.util.Random;

public class Coy extends Female {

    Random random = new Random();

    public Coy () {
        super(2);
    }

    @Override
    public void run() {
        try {
            sleep(10); //12 troppo irrequieti
            super.run();

        } catch (InterruptedException e) {
            System.out.println("Interrupted coy");
        }
    }

    @Override
    public synchronized void giveBirth(Male gentleman) throws InterruptedException {
        if (isFaithful(gentleman.type)){
            sleep(20);
            gentleman.sleep(20);
            gentleman.points += (Population.a- Population.b/2- Population.c);
            this.points += (Population.a- Population.b/2- Population.c);

            if(random.nextBoolean()){
                Coy pers = new Coy();
                pers.start();
            }else{
                Faithful pers = new Faithful();
                pers.start();

            }
            this.numberChildren++;
            gentleman.numberChildren++;

        }
        this.notify();
    }
}
