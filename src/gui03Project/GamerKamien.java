package gui03Project;

public class GamerKamien implements IGamer {
    String imie;
    final int znak = 1;

    public GamerKamien(String imie) {
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

    @Override
    public String toString() {
        return "Gracz " + imie() + " znak " + play();
    }
}
