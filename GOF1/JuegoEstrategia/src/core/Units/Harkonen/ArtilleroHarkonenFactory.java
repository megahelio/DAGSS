package core.Units.Harkonen;

import core.Units.ArtilleroAbstractFactory;

public class ArtilleroHarkonenFactory implements ArtilleroAbstractFactory<ArtilleroHarkonen> {

    @Override
    public ArtilleroHarkonen recruit(String tipe) {
        return new ArtilleroHarkonen();
    }

}
