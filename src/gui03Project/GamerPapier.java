package gui03Project;

public class GamerPapier implements IGamer {
    String imie;
    final int znak = 3;

    public GamerPapier(String imie) {
        this.imie = imie;
    }

    @Override
    public int play() {
        return znak;
    }

    @Override
    public String imie() {
        return imie;
    }

    public String toString() {
        return "Gracz " + imie() + " znak " + play();
    }
}
