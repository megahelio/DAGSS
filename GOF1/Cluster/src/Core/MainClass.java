package Core;

import Config.ConfReader;

public class MainClass {
    public static void main(String[] args) throws Exception {
        //new ObserverInvitado();
        Mediator mediator = new Mediator(new ConfReader());

        mediator.runCluster();

    }

}
