package podzadanie1;

public class FunkcjaA implements IFunc{
    @Override
    public double func(double x) {
        return 3/x;
    }

    @Override
    public double max(double a, double b) {
        if (a > b){
            double tmp = a;
            a = b;
            b = tmp;
        }
        return func(a);
    }
}
