import java.util.ArrayList;
import java.util.Random;
public class Female extends Individual{

    public Female(int tag, double points, Population p) {
        super(tag, points, p);
    }
        /*  TAG
        PHILANDERERS 0
        FAITHFUL 1
        COY 2
        FAST 3
         */
    public synchronized void give_birth(Individual partner, int cross_rate, Population pop) throws InterruptedException {
        //per la mutazione serve un valore molto basso ma tra 0 e 100 (crossrate)
        ArrayList<Individual> kids = null;

        if (partner.tag != 2 & partner.tag != 3) {
            taken = true;
            double points_for_kid = calculate_points(partner);
            Random rand = new Random();
            if (tag == 2) {
                sleep(000); //corteggiamento
            }
            int n_bambini = rand.nextInt(1, pop.settings.max_kids_possible);

            for (int i = 1; i <= n_bambini; i++) {
                boolean gender_reveal = rand.nextBoolean();
                int mutation = rand.nextInt(0, 101);
                if (mutation <= cross_rate){
                    this.mutation(partner,pop,points_for_kid);
                }
                else {
                    if (gender_reveal) {
                        if (partner.tag == 0) {
                            new Philanderer(points_for_kid,pop).start();
                        } else {
                            new Faithful(points_for_kid,pop).start();
                        }
                    } else {
                        if (tag == 2) {
                            new Coy( points_for_kid,pop).start();
                        } else {
                            new Fast(points_for_kid,pop).start();
                        }
                    }
                }
            }
        }
        taken = false;
    }



    public synchronized void mutation(Individual partner, Population p, double points_for_kids) throws InterruptedException{

    }




    public double calculate_points(Individual dad){
        double Tot_cost = p.settings.cost_child + p.settings.cost_birth;
        double resources = (p.settings.resources_available)/p.getIndividuals_n();


        //IF SHE IS A COY
        if (this.tag == 2){
            double points_parents = this.points + dad.points;
            double effective_points = points_parents - Tot_cost + resources;
            this.points -= Tot_cost/2;
            dad.points -= Tot_cost/2;
            // se il costo supera le loro possibilita economiche abortiscono, (YES IM PRO-CHOICE)
            if (dad.points <= 0 || this.points <= 0){
                this.points += Tot_cost/2-10;
                dad.points += Tot_cost/2-10;
                return 0;
            }
            return effective_points;
        }
        //IF SHE IS A FAST
        double effective_points = this.points - Tot_cost +resources;
        this.points -= Tot_cost;
        if ( this.points <= 0){
            this.points += Tot_cost-10;
            return 0;
        }
        return effective_points;
    }

}

