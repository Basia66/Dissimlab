import dissimlab.simcore.BasicSimEvent;
import dissimlab.simcore.SimControlException;

public class NowyPieszyEvent extends BasicSimEvent<Szlak, Object> {
    public NowyPieszyEvent(Szlak entity, Object o, double delay) throws SimControlException {
        super(entity, o, delay);
    }

    @Override
    protected void stateChange() throws SimControlException {
        Szlak szlak = getSimObj();

//        if (szlak.czasPojawieniaSieNowegoPieszego > simTime())
//            return;
        if(szlak.czasPojawieniaSieNowegoPieszego <= simTime()){
            szlak.piesi.add(new Pieszy(szlak.nastepneId, szlak.rng.uniform(szlak.minV, szlak.maxV), simTime()));
            System.out.println("[" + simTime() + "] NowyPieszyEvent id: " + szlak.nastepneId);

            szlak.nastepneId++;
            szlak.liczbaPieszychNaSzlaku.setValue(szlak.liczbaPieszychNaSzlaku.getValue() + 1, simTime());
            szlak.czasPojawieniaSieNowegoPieszego = simTime() + szlak.rng.uniform(szlak.minT, szlak.maxT);
        }

//        szlak.piesi.add(new Pieszy(szlak.nastepneId, szlak.rng.uniform(szlak.minV, szlak.maxV), simTime()));
//        System.out.println("[" + simTime() + "] NowyPieszyEvent id: " + szlak.nastepneId);
//
//        szlak.nastepneId++;
//        szlak.liczbaPieszychNaSzlaku.setValue(szlak.liczbaPieszychNaSzlaku.getValue() + 1, simTime());
//        szlak.czasPojawieniaSieNowegoPieszego = simTime() + szlak.rng.uniform(szlak.minT, szlak.maxT);
    }

    @Override
    protected void onTermination() throws SimControlException {

    }

    @Override
    public Object getEventParams() {
        return null;
    }
}
