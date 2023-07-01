package core.Units.Harkonen;

import core.Units.ZapadorAbstractFactory;

public class ZapadorHarkonenFactory implements ZapadorAbstractFactory<ZapadorHarkonen>{

    @Override
    public ZapadorHarkonen recruit(String tipe) {
        return new ZapadorHarkonen();
    }
    
}
