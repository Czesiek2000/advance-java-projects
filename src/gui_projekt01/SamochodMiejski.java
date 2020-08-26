package gui_projekt01;

public class SamochodMiejski extends Pojazd {
    TypSilnika typSilnika;

    public SamochodMiejski(String nazwa, double zajmowanaPowierzchnia, TypSilnika typSilnika) {
        super(nazwa, zajmowanaPowierzchnia);
        this.typSilnika = typSilnika;
    }

    public SamochodMiejski(String nazwa, double dlugosc, double szerokosc, double wysokosc, TypSilnika typSilnika) {
        super(nazwa, dlugosc, szerokosc, wysokosc);
        this.typSilnika = typSilnika;
    }

    public TypSilnika getTypSilnika() {
        return typSilnika;
    }

    @Override
    public String toString() {
        return "Typ: Samochod miejski \n" + "nazwa " + getNazwa() + "\n" + "silnik " + getTypSilnika() + "\n" + "zajmuje " + getZajmowanaPowierzchnia() + "\n";
    }

}
