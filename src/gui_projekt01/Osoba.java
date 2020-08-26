package gui_projekt01;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Osoba implements Runnable{
    String imie;
    static int gid = 0;
    int id;
    String nazwisko;
    int pesel;
    String adres;
    String dataUrodzenia;

    int dataRozpoczeciaNaj = 0;
    int dataZakonczeniaNaj;
    int obecnyDzien;
    boolean czyPosiadaParking;
    File pismo;
    Mieszkanie[] mieszkania;
    Pojazd[] p;


    public Osoba(String imie, String nazwisko, int pesel, String adres, String dataUrodzenia, boolean czyPosiadaParking) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.dataUrodzenia = dataUrodzenia;
        this.czyPosiadaParking = czyPosiadaParking;
        this.adres = adres;
        this.obecnyDzien = Time.getDzien();
        this.gid++;
        this.id = gid;
    }

    @Override
    public void run(){
        if (Time.getDzien() == 31) {
            Time.setZero();
        }

        if (obecnyDzien > dataRozpoczeciaNaj) {
            Time.setDzien();
        }
        System.out.println(Time.getDzien());

        if (Time.getDzien() == 30) {
            try {
                File f = new File("pismo.txt");
                if (f.createNewFile()) {
                    System.out.println("stworzono pismo: " + f.getName());
                } else {
                    System.out.println("Pismo juz istnieje ale zostało nadpisane przez nowe dane.");
                    FileWriter fw = new FileWriter("pismo.txt");
                    fw.write("testowy");
                    fw.close();
                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

        }

    }

    public void start() {
        System.out.println("obecnyDzien " + obecnyDzien);
    }

    public int printId(){
        return this.id;
    }

    public String getImie() {
        return this.imie;
    }

    public int getId() {
        return id;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public int getPesel() {
        return pesel;
    }

    public String getAdres() {
        return adres;
    }

    public String getDataUrodzenia() {
        return dataUrodzenia;
    }

    public String getParking() {
        if (this.czyPosiadaParking == true){
            return "posiada ";
        }
        return "nie posiada ";
    }

    public String getInfo() {
        return "Imie " + this.getImie() + "\n"
                +"nazwisko " + getNazwisko() + "\n"
                + "pesel " + getPesel() +"\n"
                + "urodzony " + getDataUrodzenia() + "\n"
                + "adres " + getAdres() + "\n"
                + getParking() + "miejsce parkingowe " + "\n";
    }

    public Mieszkanie[] getMieszkania() {
        return this.mieszkania;
    }

    public String toString() {
        return "Imie osoby: " + getImie();
    }


}
