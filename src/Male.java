public class Male extends Individual{

    public Male (int type) {
        super(type);
    }

    @Override
    public void run() {
        life();
        //System.out.println("male");
        //todo la morte non funziona bene
    }

    private void life(){
        while(Main.run) {

            while(Time.day) {
                try {
                    Female myGirl = Population.club.pop();
                    myGirl.giveBirth(this);
                    if (this.points < 1) {
                        System.out.println("maschio morto");
                        Population.numberIndividuals[this.type]--;
                        return;
                    }
                    sleep(10);
                } catch (InterruptedException dying) {}
            }
            while(!Time.day) {
                // night
                if(!Main.run) break; // am I alive?
            }
        }
    }
}
