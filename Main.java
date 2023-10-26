package podzadanie1;

public class Main {
    public static void main(String[] args) {
        CalkaMonteCarlo calkaMonteCarlo = new CalkaMonteCarlo();
        FunkcjaA funkcjaA = new FunkcjaA();

        System.out.println("Funkcja A" + "\n");
        double wynik = calkaMonteCarlo.calculate(1, Math.E, funkcjaA, 100);
        System.out.println("Wartość całki: " + wynik);
        System.out.println("Wartosc bledu względnego dla 100 prob: " + Math.abs((3 - wynik)) / 3);

        double wynik2 = calkaMonteCarlo.calculate(1, Math.E, funkcjaA, 10);
        System.out.println("Wartość całki: " + wynik2);
        System.out.println("Wartosc bledu względnego dla 10 prob: " + Math.abs((3 - wynik2)) / 3);

        double wynik3 = calkaMonteCarlo.calculate(1, Math.E, funkcjaA, 50);
        System.out.println("Wartość całki: " + wynik3);
        System.out.println("Wartosc bledu względnego dla 50 prob: " + Math.abs((3 - wynik3)) / 3);

        double wynik4 = calkaMonteCarlo.calculate(1, Math.E, funkcjaA, 1000);
        System.out.println("Wartość całki: " + wynik4);
        System.out.println("Wartosc bledu względnego dla 1000 prob: " + Math.abs((3 - wynik4)) / 3);

        System.out.println("\n" + "Funkcja B" + "\n");

        FunkcjaB funkcjaB = new FunkcjaB();
        double wynik5 = calkaMonteCarlo.calculate(-3, 3, funkcjaB, 10000);
        System.out.println("Wartość całki: " + wynik5);

    }
}
