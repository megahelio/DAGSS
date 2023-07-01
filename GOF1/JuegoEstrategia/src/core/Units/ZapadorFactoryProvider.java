package core.Units;

import core.Units.Atreides.ZapadorAtreidesFactory;
import core.Units.Fremen.ZapadorFremenFactory;
import core.Units.Harkonen.ZapadorHarkonenFactory;

public class ZapadorFactoryProvider {
    public static ZapadorAbstractFactory getFactory(String tipo) {

        switch (tipo) {
            case "Atreides":
                return new ZapadorAtreidesFactory();
            case "Harkonen":
                return new ZapadorHarkonenFactory();
            case "Frenen":
                return new ZapadorFremenFactory();
            default:
                return null;
        }
    }

}
