import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Observable {
    private List<Observer> observers = new ArrayList<>();
    private AtomicInteger runningPrograms = new AtomicInteger();

    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    public void notifyObservers(Object data, Object isRunning) {
        String text = "";

        if (isRunning.equals(true)) {
            runningPrograms.incrementAndGet();
            text = "New program. Actualmente hay " + runningPrograms + " en curso.";
        } else {
            runningPrograms.decrementAndGet();
            text = "Terminando un programa. Actualmente hay " + runningPrograms + " en curso.";
        }

        for (Observer observer : observers) {
            observer.update(this, text);
        }
    }

}
