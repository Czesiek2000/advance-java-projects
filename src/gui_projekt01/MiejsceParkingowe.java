package gui_projekt01;

import java.util.HashMap;

public class MiejsceParkingowe extends Mieszkanie{
    static int gid = 0;
    int id;
    static Pojazd[] pojazdy;
    int index;
    double powierzchnia;

    public MiejsceParkingowe(double powierzchnia, HashMap<Integer, Osoba> mieszkancy) {
        super(powierzchnia, mieszkancy);
        this.pojazdy = new Pojazd[10];
        this.index = 0;
        this.gid++;
        this.id = gid;
    }

    public MiejsceParkingowe(double dlugosc, double szerokosc, double wysokosc, HashMap<Integer, Osoba> mieszkancy) {
        super(dlugosc, szerokosc, wysokosc, mieszkancy);
        this.pojazdy = new Pojazd[10];
        this.index = 0;
        this.gid++;
        this.id = gid;
    }

    public void dodajSamochod(Pojazd pojazd) throws TooManyThingsException {
        try {
            if (index < pojazdy.length) {
                pojazdy[index] = pojazd;
                index++;
            }else  {
                throw new TooManyThingsException();
            }
        }catch (TooManyThingsException e) {
            e.getMessage();
        }
    }

    public void usunSamochod(int index) {
        pojazdy[index] = null;
    }

    public static Pojazd[] getPojazdy() {
        return pojazdy;
    }

    public void wlozDoGarazu(Pojazd p) {
        for ( Pojazd pojazd : pojazdy ) {
            if (pojazd == null) {
                pojazd = p;
            }else {
                System.out.println("Tu juz jest pojazd");
            }
        }
    }


}
