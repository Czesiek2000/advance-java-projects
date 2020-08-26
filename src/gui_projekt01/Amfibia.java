package gui_projekt01;

public class Amfibia extends Pojazd{
    int iloscDrzwi;

    public Amfibia(String nazwa, double zajmowanaPowierzchnia, int iloscDrzwi) {
        super(nazwa, zajmowanaPowierzchnia);
        this.iloscDrzwi = iloscDrzwi;
    }

    public Amfibia(String nazwa, double dlugosc, double szerokosc, double wysokosc, int iloscDrzwi) {
        super(nazwa, dlugosc, szerokosc, wysokosc);
        this.iloscDrzwi = iloscDrzwi;
    }

    public int getIloscDrzwi() {
        return iloscDrzwi;
    }

    public String getNazwa() {
        return super.getNazwa();
    }

    public double getPowierzchnia() {
        return super.getZajmowanaPowierzchnia();
    }

    @Override
    public String getInfo() {
        return "Amfibia " + getNazwa() + "\n" ;
    }

    @Override
    public String toString() {
        return "Typ: Amfibia" + "\n"+ "nazwa " + getNazwa() + "\n"+ "ilosc drzwi " + getIloscDrzwi() + "\n" + "zajmowana powierzchnia " + getZajmowanaPowierzchnia() + "\n";
    }
}
