package Config;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import Observer.ObserverInterface;
import ProgramObjects.Programa;

public class ThreadRunner implements Runnable {
    private static ThreadRunner instance = null;
    private Boolean stop;
    private ConcurrentHashMap<Thread, Programa> map;
    private AtomicInteger totalProgramas;
    private List<ObserverInterface> observers;
    private Thread supervisor;

    /**
     * @return the supervisor
     */
    public Thread getSupervisor() {
        return supervisor;
    }

    private ThreadRunner() {
        this.observers = new ArrayList<>();
        this.stop = false;
        this.map = new ConcurrentHashMap<>();
        this.totalProgramas = new AtomicInteger();
        this.totalProgramas.set(0);

        supervisor = new Thread(this);
        supervisor.start();
    }

    public static ThreadRunner getInstance() {
        if (instance == null) {
            instance = new ThreadRunner();
        }
        return instance;
    }

    public void stop() {
        this.stop = true;
    }

    public void execute(Programa programaToExecute) {
        Thread programaToExecuteThread = new Thread(programaToExecute);
        this.map.put(programaToExecuteThread, programaToExecute);
        this.notificarProgramaCreado(this.totalProgramas.incrementAndGet(), programaToExecute);
        programaToExecuteThread.start();
    }

    // Supervisor que notifica de programas (hilos) finalizados
    @Override
    public void run() {
        // Comprobamos si se manda parar el supervisor y si queda algun programa en
        // ejecucion, la segunda comprobación es necesaria para que se notifique la
        // finalizacion del ultimo programa.
        while (!this.stop || this.map.keySet().size() != 0) {

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            for (Thread thread : this.map.keySet()) {
                if (!thread.isAlive()) {
                    notificarProgramaDestruido(this.totalProgramas.decrementAndGet(), this.map.get(thread));
                    this.map.remove(thread);
                }
            }
        }
    }

    private void notificarProgramaDestruido(Integer totalProgramas, Programa programa) {
        for (ObserverInterface observador : this.observers) {
            observador.programaDestruido(totalProgramas, programa);
        }
    }

    private void notificarProgramaCreado(Integer totalProgramas, Programa programa) {
        for (ObserverInterface observador : this.observers) {
            observador.programaCreado(totalProgramas, programa);
        }
    }

    public void addObserver(ObserverInterface observer) {
        this.observers.add(observer);
    }

    public void removeObserver(ObserverInterface observer) {
        this.observers.remove(observer);
    }

}
