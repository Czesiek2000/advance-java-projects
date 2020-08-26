package gui_projekt02;

import java.util.ArrayList;

public class Magazyn {
    public int powierzchnia;
    public String lokalizacja;
    static int gid = 0;
    int id;

    public ArrayList<Przedmiot> przedmioty;

    public Magazyn(int powierzchnia, String lokalizacja) {
        this.powierzchnia = powierzchnia;
        this.lokalizacja = lokalizacja;
        gid++;
        this.id = gid;
        przedmioty = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Magazyn " + this.id + " powierzchnia " + this.powierzchnia + " miesci sie " + this.lokalizacja;
    }

    public void dodajPrzedmiot(Przedmiot p) {
        przedmioty.add(p);
    }
}
