package Config;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import Program.Program;

public class ThreadRunner implements Runnable {
    private static ThreadRunner instance = null;
    private Boolean stop;
    private Map<Thread, Program> map;
    private Thread supervisor;

    private ThreadRunner() {
        this.stop = false;
        map = new ConcurrentHashMap<>();

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

    public void execute(Program programaToExecute) {
        Thread programaToExecuteThread = new Thread(programaToExecute);
        this.map.put(programaToExecuteThread, programaToExecute);
        programaToExecuteThread.start();
    }

    @Override
    public void run() {
        while (!this.stop) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            for (Thread thread : this.map.keySet()) {
                if (!thread.isAlive()) {
                    this.map.remove(thread);
                }
            }
        }
    }

}
