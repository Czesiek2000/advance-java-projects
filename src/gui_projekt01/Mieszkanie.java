package gui_projekt01;

import java.util.HashMap;

public class Mieszkanie implements Comparable<Mieszkanie> {
    // Sugerowałem sie https://www.java-forums.org/new-java/25780-how-assign-unique-id-each-object-created-same-class.html przy implementacji id
    static int gid = 100;
    int id;
    int pomieszczenia;
    double powierzchnia;
    Osoba najemca;
    HashMap<Integer, Osoba> mieszkancy;
    int index;

    Mieszkanie(double powierzchnia, HashMap<Integer, Osoba> mieszkancy) {
        this.gid++;
        id = gid;
        this.powierzchnia = powierzchnia;
        this.mieszkancy = mieszkancy;
        this.najemca = mieszkancy.get(1);
        index = 0;
    }

    Mieszkanie(double dlugosc, double szerokosc, double wysokosc, HashMap<Integer, Osoba> mieszkancy) {
        double pole = dlugosc * szerokosc * wysokosc;
        this.powierzchnia = pole;
        this.gid++;
        id = gid;
        index = 0;
        this.mieszkancy = mieszkancy;
        this.najemca = mieszkancy.get(1);
    }

    public void zamelduj(Osoba o) {
        if (mieszkancy.size() > 10) {
            System.out.println("Wiecej niz 5 osob jest zameldowanych");
        }else  {
            mieszkancy.put(index, o);
            index++;
        }
    }

    public void zamelduj(HashMap<Integer, Osoba> o) {
        mieszkancy = o;
    }


    public void wymelduj(int index) {
        mieszkancy.remove(index);
    }

    public HashMap<Integer, Osoba> getMieszkancy() {
        return mieszkancy;
    }

    public double getPowierzchina(){
        return this.powierzchnia;
    }

    public int getId() {
        return this.id;
    }

    public Osoba getNajemca() {
        return najemca;
    }

    @Override
    public int compareTo(Mieszkanie mieszkanie) {
        if (this.getPowierzchina() < mieszkanie.getPowierzchina()) {
            return -1;
        }else if (this.getPowierzchina() > mieszkanie.getPowierzchina()) {
            return 1;
        }else {
            return 0;
        }
    }

    public String toString() {
        return "Id mieszkania " + getId() + "\n" + "powierzchni " + getPowierzchina() + "\n";
//        return "";
    }
}
