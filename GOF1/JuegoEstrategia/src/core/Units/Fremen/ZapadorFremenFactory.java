package core.Units.Fremen;

import core.Units.ZapadorAbstractFactory;

public class ZapadorFremenFactory implements ZapadorAbstractFactory<ZapadorFremen> {

    @Override
    public ZapadorFremen recruit(String tipe) {
        return new ZapadorFremen();
    }
    
}
