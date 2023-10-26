import dissimlab.broker.INotificationEvent;
import dissimlab.broker.IPublisher;
import dissimlab.monitors.MonitoredVar;
import dissimlab.random.RNGenerator;
import dissimlab.simcore.BasicSimObj;

import java.util.ArrayList;
import java.util.List;

public class Szlak extends BasicSimObj {
    RNGenerator rng;
    double minV = 1.0;
    double maxV = 5.0;
    List<Pieszy> piesi = new ArrayList<>();
    MonitoredVar czasPrzemarszu = new MonitoredVar();
    MonitoredVar liczbaPieszychNaSzlaku = new MonitoredVar();
    double minT = 1.0;
    double maxT = 3.0;
    double czasPojawieniaSieNowegoPieszego;
    int nastepneId = 1;
    double dlugosc;

    public Szlak(RNGenerator rng, double dlugosc) {
        this.rng = rng;
        this.dlugosc = dlugosc;
    }

    @Override
    public void reflect(IPublisher iPublisher, INotificationEvent iNotificationEvent) {

    }

    @Override
    public boolean filter(IPublisher iPublisher, INotificationEvent iNotificationEvent) {
        return false;
    }
}
