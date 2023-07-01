package core.Units.Fremen;

import core.Units.ArtilleroAbstractFactory;

public class ArtilleroFremenFactory implements ArtilleroAbstractFactory<ArtilleroFremen> {

    @Override
    public ArtilleroFremen recruit(String tipe) {
        return new ArtilleroFremen();
    }
    
}
