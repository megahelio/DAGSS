package core.Units;

import core.Units.Atreides.ArtilleroAtreidesFactory;
import core.Units.Fremen.ArtilleroFremenFactory;
import core.Units.Harkonen.ArtilleroHarkonenFactory;

public class ArtilleroFactoryProvider {
    public static ArtilleroAbstractFactory getFactory(String tipo) {

        switch (tipo) {
            case "Atreides":
                return new ArtilleroAtreidesFactory();
            case "Harkonen":
                return new ArtilleroHarkonenFactory();
            case "Frenen":
                return new ArtilleroFremenFactory();

            default:
                return null;
        }
    }

}