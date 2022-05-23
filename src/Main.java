import java.util.Arrays;

public class Main {
    //ci piace scopare ===> still no bitches tho
        public static void main(String[] args) throws InterruptedException {
        Settings sett = new Settings(0,0,0,0,100,10);
        Population p = new Population(1000,1000,sett);

        int a = 1;
        while (a == 1 ) {/*while there isn't stability or resources aren't finished
            resources are calculated and stored
            ogni iterazione è una generazione (scelta migliore) o un anno (scelta pessima)
            */
            a--;
            //p.haveseggs(); //method in population that tells every random individual to try to copulate
            p.iterazione++;
            System.out.println(p.getType_n() + " " + Arrays.toString(p.updatetype()) + " " + p.getIndividuals_n());

            Individual alfonso = new Philanderer(2,p);
            Individual puttana = new Fast(2,p);
            alfonso.give_birth(puttana, 3, p);
            System.out.println(p.getType_n()  + " " + Arrays.toString(p.updatetype()) + " " + p.getIndividuals_n());
        }





    }
}
