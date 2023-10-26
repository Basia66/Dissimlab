import dissimlab.simcore.BasicSimEvent;
import dissimlab.simcore.SimControlException;

public class RuchPieszegoEvent extends BasicSimEvent<Szlak, Object> {
    public RuchPieszegoEvent(Szlak entity, Object o, double delay) throws SimControlException {
        super(entity, o, delay);
    }

    @Override
    protected void stateChange() throws SimControlException {
        Szlak szlak = getSimObj();

        for (Pieszy pieszy : szlak.piesi) {
            pieszy.przebytaDroga += pieszy.predkosc;
            System.out.println("[" + simTime() + "] RuchPieszegoEvent id: " + pieszy.id + " pokonał: " + pieszy.przebytaDroga);
            if (pieszy.przebytaDroga > szlak.dlugosc) {
                szlak.czasPrzemarszu.setValue(simTime() - pieszy.czasPojawienia, simTime());
                System.out.println("[" + simTime() + "] RuchPieszegoEvent id: " + pieszy.id + " skończył szlak");
            }
        }

        szlak.piesi.removeIf(x -> x.przebytaDroga > szlak.dlugosc);
        szlak.liczbaPieszychNaSzlaku.setValue(szlak.piesi.size(), simTime());
    }

    @Override
    protected void onTermination() throws SimControlException {

    }

    @Override
    public Object getEventParams() {
        return null;
    }
}
