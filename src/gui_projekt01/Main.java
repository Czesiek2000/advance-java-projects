package gui_projekt01;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Time t = new Time();
//        t.run();
        Osoba o = new Osoba("Jan", "Kowalski", 1234567890,"Krucza 2","22-04-2020",true);
        Osoba o1 = new Osoba("Marek", "Nowak", 1122334455, "Biała 1", "21-04-2020", false);
        Osoba o2 = new Osoba("Kazimierz", "Kwiat", 1111111111, "Koszykowa 90", "28-04-2020", true);
        Osoba o3 = new Osoba("Jan", "Kalafior", 222222222, "Wiatraczna 2", "28-03-2020", false);

        HashMap<Integer, Osoba> mieszkancy = new HashMap<>();
        mieszkancy.put(1, o);
        mieszkancy.put(2, o1);
        mieszkancy.put(3, o2);
        mieszkancy.put(4, o3);

        Mieszkanie m = new Mieszkanie(300, 300, 100, mieszkancy);
        Mieszkanie m1 = new Mieszkanie(100, 200, 200, mieszkancy);
        Mieszkanie m2 = new Mieszkanie(1000, mieszkancy);
        Mieszkanie m3 = new Mieszkanie(2000, mieszkancy);
        Mieszkanie[] mieszkanie = {m, m1, m2, m3};
        m.zamelduj(o);

        MiejsceParkingowe mp = new MiejsceParkingowe(1000.5, mieszkancy);
        SamochodTerenowy st = new SamochodTerenowy("Terenowy", 1000, 1000);
        SamochodTerenowy st1 = new SamochodTerenowy("Terenowy1", 1002, 2000);
        SamochodTerenowy st2 = new SamochodTerenowy("Terenowy2", 1003, 3000);
        SamochodMiejski sm = new SamochodMiejski("Miejski", 10001, TypSilnika.DIESEL);
        Amfibia a = new Amfibia("A", 100, 2);
        Motocykl mo = new Motocykl("M", 100, 2);
        Lodz l = new Lodz("L", 100, "lodz");

        Pojazd[] parking = {st, sm, a, mo, l};
        try {
            mp.dodajSamochod(sm);
            mp.dodajSamochod(st1);
            mp.dodajSamochod(st);
            mp.dodajSamochod(st2);
        }catch (TooManyThingsException e) {
            e.getMessage();
        }

        Osiedle osiedle = new Osiedle(1, mieszkancy, parking, mieszkanie);

    }
}
