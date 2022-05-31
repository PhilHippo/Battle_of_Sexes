import java.util.Random;

public class Male extends Individual{

    public Male(double points, Population p, int tag){
        super(tag, points, p);
    }

    private void copulate(Female partner){
        partner.wake_up();
        //aspetta finchè il partner non ha partorito o aspetta per sempre se si sposano
    }

    @Override
    public void run() {
        Random random = new Random();
        while(this.points>0){
            while(Time.day) {

                try {
                    Female partner = (Female) Population.club.pop();
                    copulate(partner);
                    //System.out.println(partner.getName());
                } catch (InterruptedException ignored) {}}

                }
                while (!Time.day){

                }
            }






    @Override
    public synchronized void give_birth(Individual partner, int cross_rate, Population pop) throws InterruptedException {
        while (partner.taken) {
            wait();
        }
        if (partner.tag == 0 || partner.tag == 1) return;
        partner.give_birth(this , cross_rate, pop);

    }


}
