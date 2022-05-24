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
            double points_for_kid = 0; // da decide come dare
            // aggiungere il/i figlio/i nella popolazione, aumentare/diminuire gli opportuni valori
            Random rand = new Random();
            if (tag == 2) {
                sleep(1000); //corteggiamento
            }
            int n_bambini = rand.nextInt(1, 4);

            for (int seggs = 1; seggs <= n_bambini; seggs++) { // questo crea figli un numero random di volte ma sempre meno di 5
                int x = rand.nextInt(0, 101);
                if (x < cross_rate) {
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
        taken = false;
    }




}

