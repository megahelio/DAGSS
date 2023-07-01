package core.Units.Atreides;

import core.Units.ZapadorAbstractFactory;

public class ZapadorAtreidesFactory implements ZapadorAbstractFactory<ZapadorAtreides> {

    @Override
    public ZapadorAtreides recruit(String tipe) {
        return new ZapadorAtreides();
    }
    
}
