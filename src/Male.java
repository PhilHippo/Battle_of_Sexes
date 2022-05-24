public class Male extends Individual{

    public Male(double points, Population p, int tag){
        super(tag, points, p);
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
