package gui_projekt02;

public class Przedmiot {
    public String nazwa;
    public int powierzchnia;
    public String opis;
    static int gid = 0;
    int id;

    public Przedmiot(String nazwa, int powierzchnia, String opis) {
        this.nazwa = nazwa;
        this.powierzchnia = powierzchnia;
        this.opis = opis;
        gid++;
        this.id = gid;
    }
}
