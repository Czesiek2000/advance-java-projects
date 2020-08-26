package gui_projekt02;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Przedmiot p1 = new Przedmiot("Telefon", 10, "Telefon komorkowy");
        Przedmiot p2 = new Przedmiot("Samochod", 100, "Samochod osobowy");
        Przedmiot p3 = new Przedmiot("Amfibia", 20, "Piekna amfibia");
        Przedmiot p4 = new Przedmiot("Helikopter", 200, "Helikopter w garazu");
        Przedmiot p5 = new Przedmiot("Komputer", 300, "Komputer stacjonarny");
        Przedmiot p6 = new Przedmiot("Telefon", 5, "Telefon komorkowy");
        Przedmiot p7 = new Przedmiot("Monitor", 50, "Monitor do komputera");
        Przedmiot p8 = new Przedmiot("Zegarek", 1, "Zegarek na reke");
        Przedmiot p9 = new Przedmiot("Konsola", 600, "Konsola do gier");
        Przedmiot p10 = new Przedmiot("Słuchawki", 100, "Sluchawki do komputera");
        Magazyn m = new Magazyn(100, "Polska");
        Magazyn m1 = new Magazyn(200, "Rosja");
        Magazyn m2 = new Magazyn(300, "Chiny");
        ArrayList<Magazyn> magazyny = new ArrayList<>();
        ArrayList<Przedmiot> przedmioty = new ArrayList<>();
        magazyny.add(m);
        magazyny.add(m1);
        magazyny.add(m2);
        przedmioty.add(p1);
        przedmioty.add(p2);
        przedmioty.add(p3);
        przedmioty.add(p4);
        przedmioty.add(p5);
        przedmioty.add(p6);
        przedmioty.add(p7);
        przedmioty.add(p8);
        przedmioty.add(p9);
        przedmioty.add(p10);
        SwingUtilities.invokeLater(
                () -> {
                    Frame frame = new Frame(magazyny, przedmioty);
                }
        );
    }
}
