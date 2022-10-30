import java.util.ArrayList;

public abstract class Trabajo implements Runnable {

    protected ArrayList<Thread> programas;

    public Trabajo() {

    }

    public void run() {

    }

    protected abstract void add(Runnable r);

}
