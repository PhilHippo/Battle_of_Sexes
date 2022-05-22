import java.util.ArrayList;
import java.util.Random;
public class Female extends Individual{


    private int success_rate_court;
    /*      PHILANDERERS=0
            FAITHFUL=1
            COY=2
            FAST=3
             */
    public Female(int tag,int age,double points) {
        super(tag,age,points);
        if (tag == 2)  {this.success_rate_court = 10;} //costo della corteggiamentazione
        else {this.success_rate_court = 0;}
    }
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
            for (int seggs = 0; seggs <= n_bambini; seggs++) { // questo crea figli un numero random di volte ma sempre meno di 5
                int x = rand.nextInt(0, 100);
                if (x < cross_rate) {
                    int t = this.coniuge.getTag();
                    if (t == 0) {
                        born = new Philanderer(0, 0, points_for_kid);
                        this.children.add(born);
                        born.start();
                    } else {
                        born = new Faithful(1, 0, points_for_kid);
                        this.children.add(born);
                        born.start();
                    }
                } else {
                    if (tag == 2) {
                        born = new Coy(2, 0, points_for_kid);
                        this.children.add(born);
                        born.start();
                    } else {
                        born = new Fast(3, 0, points_for_kid);
                        this.children.add(born);

                    }
                }
                kids.add(born);
                born.start();
            }

        }
        taken = false;
        return kids;
    }

    @Override
    public void run() {
        super.run();
    }//non so se mettere run solo a indivduo o anche ai 4 tipi

    private int get_success_courtship(int tag){ //inutile : basta mettere tempi giusti nei vari casi diversi
        Random r = new Random();
        if(this.tag == 2){

        }
        return 0;
    }



}

