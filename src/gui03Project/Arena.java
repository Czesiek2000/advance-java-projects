package gui03Project;

public class Arena { // implements IGamer{
    IGamer ig;
    IGamer ig2;
    int wynik1;
    int wynik2;

//    public Arena(IGamer i, IGamer i2) {
//        this.ig = i;
//        this.ig2 = i2;
//    }

    /*
    * Kamien papier => papier
    * Kamien nozyce => kamien
    * Nozyce papier => nozyce
    * nozyce Kamien => kamien
    */
    public void compare(GamerKamien gk, GamerPapier gp){

        if (gk.znak == 2 && gp.znak == 3) {
            System.out.println("Papier wygrał");
        }
    }

    public void compare(GamerKamien gk, GamerNozyce gn){

        if (gk.znak == 1 && gn.znak == 2) {
            System.out.println("Kamien wygrały");
        }
    }

    public void compare(GamerNozyce gn, GamerPapier gp){

        if (gp.znak == 3 && gn.znak == 2) {
            System.out.println("Nozyce wygrały");
        }
    }

    public void compare(GamerNozyce gn, GamerKamien gk){

        if (gk.znak == 1 && gn.znak == 2) {
            System.out.println("Kamien wygrał");
        }
    }

    public void compare(GamerRandom gr, GamerPapier gp) {
        if (gr.znak == 3 && gp.znak == 3) {
            System.out.println("Remis");
        }else if (gr.znak == 2 && gp.znak == 3) {
            System.out.println("Random wygrał");
        }else {
            System.out.println("Papier wygrał");
        }
    }

    public void compare(GamerRandom gr, GamerKamien gk) {
        if (gr.znak == 1 && gk.znak == 1) {
            System.out.println("Remis");
        }else if (gr.znak == 2 && gk.znak == 1) {
            System.out.println("Kamien wygrał");
        }else {
            System.out.println("Random wygrał");
        }
    }

    public void compare(GamerRandom gr, GamerNozyce gn) {
        if (gr.znak == 2 && gn.znak == 2) {
            System.out.println("Remis");
        } else if (gr.znak == 1 && gn.znak == 2) {
            System.out.println("Random wygrał");
        } else {
            System.out.println("Nozyce wygrały");
        }
    }

    public void fight(int liczbaRund) {
        System.out.println("Runda " + liczbaRund);
        if (this.wynik1 > this.wynik2) {
            System.out.println("Wygrał zawodnik 1");
        } else if (this.wynik1 == this.wynik2) {
            System.out.println("Remis");
        } else {
            System.out.println("Wygrał zawodnik 2");
        }
    }

//    @Override
//    public int play() {
//        return 0;
//    }
//
//    @Override
//    public String imie() {
//        return null;
//    }
}
