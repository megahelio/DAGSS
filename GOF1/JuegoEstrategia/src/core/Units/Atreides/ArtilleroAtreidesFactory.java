package core.Units.Atreides;

import core.Units.ArtilleroAbstractFactory;

public class ArtilleroAtreidesFactory implements ArtilleroAbstractFactory<ArtilleroAtreides> {

    @Override
    public ArtilleroAtreides recruit(String tipe) {
        return new ArtilleroAtreides();
    }
    
}
