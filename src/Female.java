public class Female extends Individual{

    public Female (int type) {
        super(type);
    }

    @Override
    public synchronized void run() {
        life();
        //System.out.println("female");
        //todo la morte non funziona bene
    }

    private void life(){
        while(Main.run) {
            while(Time.day) {
                Population.club.push(this);
                try {
                    wait();
                    if (this.points < 1) {
                         Population.numberIndividuals[this.type]--;
                        return;}
                    sleep(10); // troppo irrequieti
                } catch (InterruptedException dying) {}
            }
            while(!Time.day){
                // night
                if(!Main.run) break; // am I alive?
            }
        }
    }

    public synchronized void giveBirth(Male gentleman){}
}
