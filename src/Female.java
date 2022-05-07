import java.util.ArrayList;
import java.util.Random;
public class Female extends Individual{

    // visto che Coy and Fast fanno la stessa cosa basta che settiamo Coy SRC a 5-10 anni, e Fast a 0-1 anni    (per anni intendo iterazione)
    private int success_rate_court;

    public Female(int tag,int age,double points) {
        super(tag,age,points);
    }


    public synchronized ArrayList<Individual> Give_birth(Individual partner, int cross_rate) throws InterruptedException {
        //per la mutazione serve un valore molto basso ma tra 0 e 100 (crossrate)
        ArrayList<Individual> kids = null;
        if (partner.tag != 2 & partner.tag != 3) {
            double points_for_kid = 0; // da decide come dare
            // aggiungere il/i figlio/i nella popolazione, aumentare/diminuire gli opportuni valori
            Random rand = new Random();
            if (tag == 2) {
                sleep(100);
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
                    int t = this.tag;
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

        return kids;
    }

    @Override
    public void run() {
        super.run();
    }

    private int get_success_courtship(int tag){
        Random r = new Random();
        if(this.tag == 2){

        }
        return 0;
    }



}

