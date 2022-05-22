public class Main {

    //ci piace scopare

    public static void main(String[] args) {
        Settings sett = new Settings(0,0,0,0,100,10);
        Population p = new Population(1001,1000,sett);
        System.out.println(p.get_n_individual());
        int a = 1;
        while (a > 0 ) {/*while there isn't stability or resources aren't finished
             resources are calculated and stored
             ogni iterazione è una generazione (scelta migliore) o un anno (scelta pessima)
            */
            a--;
            p.haveseggs(); //method in population that tells every random individual to try to copulate
            p.iterazione++;
            System.out.println(p.get_n_individual());

        }





    }
}
