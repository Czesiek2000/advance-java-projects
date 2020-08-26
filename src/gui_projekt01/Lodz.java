package gui_projekt01;

public class Lodz extends Pojazd {
    String typPojazdu;

    public Lodz(String nazwa, double zajmowanaPowierzchnia, String typPojazdu) {
        super(nazwa, zajmowanaPowierzchnia);
        this.typPojazdu = typPojazdu;
    }

    public Lodz(String nazwa, double dlugosc, double szerokosc, double wysokosc, String typPojazdu) {
        super(nazwa, dlugosc, szerokosc, wysokosc);
        this.typPojazdu = typPojazdu;
    }

    public String getTypPojazdu() {
        return typPojazdu;
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
        return "Typ: Lodz " + "\n"+ "nazwa: " + getNazwa() + "\n"+ "zajmowana powierzchnia " + getZajmowanaPowierzchnia() + "\n"+ "typ pojazdu " + getTypPojazdu() + "\n";
    }
}
