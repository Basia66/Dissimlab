package podzadanie1;
import dissimlab.random.RNGenerator;

public class CalkaMonteCarlo {
    double calculate(double a, double b, IFunc f, int rep){
        RNGenerator gen = new RNGenerator(RNGenerator.generateSeed());
        double fMax = f.max(a, b);
        int k=0;
        for (int i=0; i < rep; i++){
            double x = gen.uniform(a, b);
            double y = gen.uniform(0, fMax);
            if (y <= f.func(x)){
                k++;
            }
        }
        return ((double)k) / rep * (b - a) * fMax;
    }
}
