package gui03Project;

public class GamerNozyce implements IGamer {
    String imie;
    final int znak = 2;

    public GamerNozyce(String imie) {
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
