import java.util.ArrayList;


public class MyStack{
    protected static ArrayList<Female> nightClub = new ArrayList<>();

    public void push(Female person) {
        synchronized (Population.club) {
            nightClub.add(person);
            notifyAll();
        }
    }

    //todo: must synchronize men to different object of women(all men must be notified by push by waiting on pop)
    //todo: and women must be notified to wake up on pop (on club) by waiting on push
    public Female pop() throws InterruptedException {
        synchronized (Population.club) {
            while (nightClub.isEmpty()) {
                System.out.println("MYSTACK EMPTY and male WAITING");
                wait();
            }

            Female popValue = nightClub.get(0);
            nightClub.remove(0); // removes the popped element
            return popValue;
        }
    }


    boolean isEmpty() {
        return nightClub.isEmpty();
    }
}