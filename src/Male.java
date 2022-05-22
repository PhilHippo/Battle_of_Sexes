import java.util.ArrayList;

public class Male extends Individual{
    public Male(int tag,int age,double points){
        super(tag,age,points);
    }
    public void segs () {}
    @Override
    public void run() {
        super.run();
    } //non so se mettere run solo a indivduo o anche ai 4 tipi
    public synchronized ArrayList<Individual> give_birth(Individual partner, int cross_rate, Population pop) throws InterruptedException {
        if (partner.taken) {
            wait();
        }
        return partner.give_birth(this , cross_rate, pop);
    }


}
