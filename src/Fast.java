import java.util.Random;

public class Fast extends Female {

    private Random random = new Random();

    public Fast() {
        super(3);
    }

    @Override
    public void run() {
        try {
            sleep(10);//
            super.run();

        } catch (InterruptedException e) {
            //System.out.println("Interrupted fast");g
        }
    }

    @Override
    public synchronized void giveBirth(Male gentleman) throws InterruptedException {

        if (isPhilanderer(gentleman.type)){
            gentleman.points += Population.a;
            this.points += (Population.a - Population.b);

           /* if(random.nextInt(0,100)==10){
                if(random.nextBoolean()){
                    Coy pers = new Coy();
                    pers.start();
                }
                else {
                    Faithful pers = new Faithful();
                    pers.start();
                }
                return;
            }*/

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

            int wait_time = (int)((Population.payoff_FC*100f)/(Population.payoff_FC+Population.payoff_FS));
            gentleman.sleep(wait_time);
            this.sleep(wait_time);
            gentleman.points += (Population.payoff_FS);
            this.points += (Population.payoff_FS);
            /*gentleman.sleep(70);
            gentleman.points += (Population.a- Population.b/2);
            this.points += (Population.a- Population.b/2);*/

            /*if(random.nextInt(0,100)==10){
                mutation(gentleman);
                return;
            }*/

            if(random.nextBoolean()){
                Fast pers = new Fast();
                pers.start();
            }else{
                Faithful pers = new Faithful();
                pers.start();
            }
        }
        this.notify();
    }
}
