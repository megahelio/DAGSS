public class ProgramA extends Observable implements Runnable {

    public void run() {
        try {
            System.out.println("[INICIO] ProgramaA");
            notifyObservers(this, true);

            Thread.sleep(10);

            System.out.println("[FIN] ProgramaA");

            notifyObservers(this, false);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}