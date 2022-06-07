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

        if (isFaithful(gentleman.type)){

            gentleman.points += (a-b/2-c);
            this.points += (a-b/2-c);

            if(false){
                Coy ind = new Coy();
                ind.start();
            }
            else{
                Faithful ind = new Faithful();
                ind.start();
            }
        }

        //TODO
        // if (isPhilanderer(gentleman.type)) {}

        this.notify();
    }
}
