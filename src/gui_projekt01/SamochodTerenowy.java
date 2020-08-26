package gui_projekt01;

public class SamochodTerenowy extends Pojazd{
    int konieMechaniczne;

    public SamochodTerenowy(String nazwa, double zajmowanaPowierzchnia, int konieMechaniczne) {
        super(nazwa, zajmowanaPowierzchnia);
        this.konieMechaniczne = konieMechaniczne;
    }

    public SamochodTerenowy(String nazwa, double dlugosc, double szerokosc, double wysokosc, int konieMechaniczne) {
        super(nazwa, dlugosc, szerokosc, wysokosc);
        this.konieMechaniczne = konieMechaniczne;
    }

    public String getNazwa() {
        return nazwa;
    }

    public String getKonieMechaniczne() {
        return nazwa;
    }

    public double getZajmowanaPowierzchnia() {
        return zajmowanaPowierzchnia;
    }

    public String getInfo() {
        return "Samochod Terenowy " + getNazwa() + ", zajmuje powierzchnie " + getZajmowanaPowierzchnia() + ", posiada konie mechaniczne, " + getKonieMechaniczne();
    }

    @Override
    public String toString() {
        return "Typ: SamochodTerenowy " + "\n"+ "konie mechaniczne: " + konieMechaniczne + "\n" + "nazwa='" + nazwa + '\'' + "\n"+ "zajmowanaPowierzchnia=" + zajmowanaPowierzchnia + "\n";
    }
}
