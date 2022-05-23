public class Male extends Individual{

    public Male(double points, Population p, int tag){
        super(tag, points, p);
    }
    @Override

    public synchronized void give_birth(Individual partner, int cross_rate, Population pop) throws InterruptedException {
        if (partner.taken) {
            wait();
        }
        partner.give_birth(this , cross_rate, pop);
        return ;
    }


}
