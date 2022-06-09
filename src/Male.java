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
                    if (this.points < 1) {
                        synchronized (Population.numberIndividuals) {
                            Population.numberIndividuals[this.type]--;
                        }
                        return;
                    }
                    sleep(25); // troppo irrequieti
                } catch (InterruptedException dying) {}
            }

            // it is night here: does nothing
        }
        // todo per ora muoiono solo le fast
    }
}
