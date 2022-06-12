public class Male extends Individual{

    public Male (int type) {
        super(type);
    }

    @Override
    public void run() {
        while(Main.untilEquilibriumReached) {

            while(Time.day) {
                try {
                    Female myGirl = Population.club.pop();
                    myGirl.giveBirth(this);
                    // start check points || this.numberChildren >= Population.maxChildren
                    if (this.points < 1) {
                        synchronized (Population.numberIndividuals) {
                            Population.numberIndividuals[this.type]--;
                        }
                        interrupt();
                        return;
                    }

                } catch (InterruptedException dying) {}
            }
            this.points-= Population.d;
        }
    }
}
