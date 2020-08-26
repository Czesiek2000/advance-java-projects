package gui03Project;

public class Arena2 extends AdvancedGamer {
    String name;
    int fake;
    String gracz1 = "";
    String gracz2 = "";

    public Arena2(String gracz1, String gracz2) {
        this.gracz1 = gracz1; // "s20613";
        this.gracz2 = gracz2;
    }

    // zwraca nazwe gracza
    @Override
    public String name() {
        return "Gracz 1: " + this.gracz1 + " gracz2: " + this.gracz2;
    }

    // zwraca fałszywe zagranie gracza
    @Override
    public int fake() {
//        if (gp.znak == 3) {
//            fake = 2;
//        }else {
//            fake = 1;
//        }
//
//        if (gk.znak == 1) {
//            fake = 3;
//        }
//
//        if (gn.znak == 2) {
//            fake = 1;
//        }
//
//        if (gr.znak == 1) {
//            fake = 3;
//        }else if (gr.znak == 2) {
//            fake = 1;
//        }else {
//            fake = 2;
//        }

        if (gracz1 == "Kamien") {
            fake = 3;
        }else if (gracz1 == "Papier") {
            fake = 2;
        }else if (gracz1 == "Nozyce") {
            fake = 1;
        }

        if (gracz2 == "Kamien") {
            fake = 3;
        }else if (gracz2 == "Papier") {
            fake = 2;
        }else if (gracz2 == "Nozyce") {
            fake = 1;
        }

        return fake;
    }

    // zwraca zagranie danego gracza, przyjmuje argument zamarkowane zagranie przeciwnika
    @Override
    public int play(int fake) {
//        if (fake == 1) {
//            return 3;
//        }else if (fake == 2) {
//            return 1;
//        } else {
//            return
//        }
        return 1;
    }

    /*
    * score - wynik ostatniej potyczki
    * enemyMove - wzor wystawiony przez przeciwnika w ostatniej potyczce
    */
    @Override
    public void result(boolean score, int enemyMove) {

    }
}
