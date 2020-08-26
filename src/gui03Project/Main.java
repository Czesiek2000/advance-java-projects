package gui03Project;

public class Main {
    private IGamer i;

    public static void main(String[] args) {
        // Kamien papier
        GamerKamien gk = new GamerKamien("Kamien");
//        System.out.println(gk.imie());
        GamerNozyce gn = new GamerNozyce("Nozyce");
        GamerPapier gp = new GamerPapier("Papier");
        GamerRandom gr = new GamerRandom();
        System.out.println(gr);
//        System.out.println(gn.imie());
        Arena a = new Arena();
        a.compare(gn, gk);
        a.fight(2);

        Arena2 test = new Arena2("Kamien", "Nozyce");
//        System.out.println("Fake " + test.play(1));
    }
}
