package gui_projekt01;

public class Motocykl extends Pojazd {
    int iloscKol;

    public Motocykl(String nazwa, double zajmowanaPowierzchnia, int iloscKol) {
        super(nazwa, zajmowanaPowierzchnia);
        this.iloscKol = iloscKol;
    }

    public Motocykl(String nazwa, double dlugosc, double szerokosc, double wysokosc, int iloscKol) {
        super(nazwa, dlugosc, szerokosc, wysokosc);
        this.iloscKol = iloscKol;
    }

    public int getIloscKol() {
        return iloscKol;
    }

    @Override
    public String getNazwa() {
        return super.getNazwa();
    }

    @Override
    public double getZajmowanaPowierzchnia() {
        return super.getZajmowanaPowierzchnia();
    }

    public String toString() {
        return "Typ: Motocykl" + "\n"+ "nazwa " + getNazwa() + "\n"+ "zajmowana powierzchnia " + getZajmowanaPowierzchnia() + "\n" + "ilosc kol " + getIloscKol() + "\n";
    }
}
