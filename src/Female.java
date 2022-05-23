import java.util.ArrayList;
import java.util.Random;
public class Female extends Individual{

    private int success_rate_court;
    public Female(int tag, double points, Population p) {
        super(tag, points, p);
    }
    /*      PHILANDERERS=0
            FAITHFUL=1
            COY=2
            FAST=3 */

    public synchronized ArrayList<Individual> give_birth(Individual partner, int cross_rate, Population pop) throws InterruptedException {
        //per la mutazione serve un valore molto basso ma tra 0 e 100 (crossrate)
        ArrayList<Individual> kids = null;

        if (partner.tag != 2 & partner.tag != 3) {
            taken = true;
            double points_for_kid = 0; // da decide come dare
            // aggiungere il/i figlio/i nella popolazione, aumentare/diminuire gli opportuni valori
            Random rand = new Random();
            if (tag == 2) {
                sleep(200);
            }
            int n_bambini = rand.nextInt(0, 5);
            Individual born;
            for (int seggs = 1; seggs <= n_bambini; seggs++) { // questo crea figli un numero random di volte ma sempre meno di 5
                int x = rand.nextInt(0, 100);
                if (x < cross_rate) {
                    if (partner.tag == 0) {
                        born = new Philanderer(points_for_kid,pop);
                        born.start();
                    } else {
                        born = new Faithful(points_for_kid,pop);
                        born.start();
                    }
                } else {
                    if (tag == 2) {
                        born = new Coy( points_for_kid,pop);
                        born.start();
                    } else {
                        born = new Fast(points_for_kid,pop);
                        born.start();
                    }
                }
                kids.add(born);
                born.start();
            }

        }
        taken = false;
        return kids;
    }


    private int get_success_courtship(int tag){ //inutile : basta mettere tempi giusti nei vari casi diversi
        Random r = new Random();
        if(this.tag == 2){

        }
        return 0;
    }



}

