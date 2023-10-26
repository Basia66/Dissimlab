import dissimlab.monitors.Diagram;
import dissimlab.monitors.Statistics;
import dissimlab.random.RNGenerator;
import dissimlab.simcore.SimControlException;
import dissimlab.simcore.SimManager;

import java.awt.*;

public class Main {
    public static void main(String[] args) throws SimControlException {
        SimManager sm = SimManager.getInstance();
        sm.setEndSimTime(100.0);
        double dlugoscSzlaku = 70;

        RNGenerator rng = new RNGenerator();
        Szlak szlak = new Szlak(rng, dlugoscSzlaku);
        NowyPieszyEvent ev1 = new NowyPieszyEvent(szlak, null,0.1);
        RuchPieszegoEvent ev2 = new RuchPieszegoEvent(szlak, null, 0.1);

        sm.startSimulation();

        System.out.println("Średnia liczba pieszych na trasie: " +  Statistics.weightedMean(szlak.liczbaPieszychNaSzlaku));
        System.out.println("Średni czas przejścia: " + Statistics.arithmeticMean(szlak.czasPrzemarszu));

        Diagram d1 = new Diagram(Diagram.DiagramType.TIME, "Liczba pieszych");
        d1.add(szlak.liczbaPieszychNaSzlaku, Color.RED);
        d1.show();

        Diagram d2 = new Diagram(Diagram.DiagramType.DISTRIBUTION, "Czasu przemarszu");
        d2.add(szlak.czasPrzemarszu, Color.BLUE);
        d2.show();
    }
}
