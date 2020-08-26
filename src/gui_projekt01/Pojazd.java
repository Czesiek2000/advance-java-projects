package gui_projekt01;

public abstract class Pojazd {
    String nazwa;
    double zajmowanaPowierzchnia;

    public Pojazd(String nazwa, double zajmowanaPowierzchnia) {
        this.nazwa = nazwa;
        this.zajmowanaPowierzchnia = zajmowanaPowierzchnia;
    }

    public Pojazd(String nazwa, double dlugosc, double szerokosc, double wysokosc) {
        this.nazwa = nazwa;
        double powierzchnia = dlugosc * szerokosc * wysokosc;
        this.zajmowanaPowierzchnia = powierzchnia;
    }

    public String getNazwa() {
        return nazwa;
    }

    public double getZajmowanaPowierzchnia() {
        return zajmowanaPowierzchnia;
    }

    public String getInfo() {
        return "Pojazd " + getNazwa() + " zajmuje powierzchnie " + getZajmowanaPowierzchnia();
    }
}
