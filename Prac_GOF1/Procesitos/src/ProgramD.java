public class ProgramD extends Observable implements Runnable {
    public void run() {
        try {
            System.out.println("[INICIO] ProgramaD");
            notifyObservers(this, true);

            Thread.sleep(10);

            System.out.println("[FIN] ProgramaD");
            notifyObservers(this, false);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}