import java.util.ArrayList;
import java.util.Random;
public class Female extends Individual{

    private boolean status;
    private int age;
    private double death_rate;
    private Individual coniuge;
    private ArrayList<Individual> children;
    private int tag;
    // visto che Coy and Fast fanno la stessa cosa basta che settiamo Coy SRC a 5-10 anni, e Fast a 0-1 anni    (per anni intendo iterazione)
    private int success_rate_court;

    public Female(int tag,int age,int points) {
        super(tag,age,points);

    }


    // I dont know how to write efficient mutation
    public void Give_birth(){
        Random rand = new Random();
        // x%2=0 male
        // x%2=1 female
        int x = rand.nextInt(0,100);
        if (x%2==0){
            int t = this.coniuge.getTag();
            if( t == 0){
                Philanderer p = new Philanderer(0,0);
                this.children.add(p);
            }else{
                Faithful f = new Faithful(1,0);
                this.children.add(f);
            }
        }else{
            int t = this.tag;
            if (tag == 2 ){
                Coy c = new Coy(2,0);
                this.children.add(c);
            }else{
                Fast f = new Fast(3,0);
                this.children.add(f);
            }
        }
    }


    private int get_success_courtship(int tag){

    }



}

