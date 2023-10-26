package podzadanie1;

public class FunkcjaB implements IFunc{
    @Override
    public double func(double x) {
        return (1/Math.sqrt(2*Math.PI)) * Math.pow(Math.E,(-x*x/2));
    }

    @Override
    public double max(double a, double b) {
        if (a < 0 && b >= 0){
            return func(0);
        }
        else{
            if(Math.abs(a) > Math.abs(b)) return func(b);
            else return func(a);
        }

    }
}
