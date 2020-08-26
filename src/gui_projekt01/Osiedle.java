package gui_projekt01;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Osiedle {
    int numerOsiedla;
    String uImie;
    boolean czyParking;
    Scanner scanner = new Scanner(System.in);
    int x;
    int choice;
    int index;
    String uNazwisko;
    int uPesel;
    String uAdres;
    String uDataUrodzenia;
    HashMap<Integer, Osoba> mieszkancy;
    Mieszkanie[] mieszkanie;
    Pojazd[] parking;

//    Osoba o = new Osoba(uImie, uNazwisko, uPesel, uAdres, uDataUrodzenia,czyParking);

    public Osiedle(int numerOsiedla, HashMap<Integer, Osoba> mieszkancy, Pojazd[] parking, Mieszkanie[] mieszkanie) {
        this.mieszkancy = mieszkancy;
        this.mieszkanie = mieszkanie;
        this.parking = parking;
        this.mieszkanie = mieszkanie;
        this.numerOsiedla = numerOsiedla;

        wyswietlanie();

        x = -1;
         while(x != 0) {
             System.out.print("Twoj wybor: ");
             x = scanner.nextInt();
             if (x == 0) {
                 System.out.println("Zakonczyles program zegnaj");
             }else if (x == 1) {
                 System.out.print("Chesz powiedziec kim jestes prosze podac swoje id ");
                 if (mieszkancy == null) {
                     System.out.println("Przepraszam najpierw musisz podac jakies informacje ");
                 }else {
                     int uid = scanner.nextInt();
                     for (int i = 0; i < mieszkancy.size(); i++) {
                         if (uid == mieszkancy.get(i).printId()) {
                             System.out.println("Witaj " + mieszkancy.get(i).getImie());
                             return;
                         }
                     }
                 }
             }else if (x == 2) {
                 System.out.print("chcesz wypisac swoje dane prosze bardzo ");
                 System.out.print("podaj id ");
                 int userId = scanner.nextInt();
                 for (int i = 0; i < mieszkancy.size(); i++) {
                     if (userId == mieszkancy.get(i).printId()) {
                         System.out.println("Twoje dane: " + mieszkancy.get(i).getInfo());
                         return;
                     }
                 }

             }else if (x == 3) {
                 System.out.println("Chcesz wyswietlic wolne pomieszczenie prosze bardzo");
                 for (int i = 0; i < mieszkanie.length; i++) {
                     System.out.println(mieszkanie[i].najemca);
                 }

             }else if (x == 4) {
                 System.out.println("Chesz wyjac cos z garazu ok");
                 System.out.print("podaj miejsce parkingowe(index) z ktorego chcesz wziac samochod");
                 int choice = scanner.nextInt();
                 if (parking.length == 0) {
                     System.out.println("Pusty parking dodaj cos najpierw");
                 }

                 if (parking[choice] != null) {
                     parking[choice] = null;
                 }else {
                     System.out.println("Nic tu nie ma, sory ");
                 }

             }else if (x == 5) {
                 System.out.println("Chesz wyswietlic / dowiedziec sie kto wynajmuje dane pomieszczenie");
                 System.out.print("podaj numer mieszkania ");
                 int y = scanner.nextInt();
                 for (int i = 0; i < mieszkanie.length; i++) {
                    if (mieszkanie[i].getId() == y) {
                        System.out.println("Mieszkanie " + mieszkanie[i].getId() + " najemca jest " + mieszkanie[i].getNajemca());
                        return;
                    }else {
                        System.out.println("sorry nie znalazłem mieszkania ");
                    }
                 }
             }else if (x == 6) {
                 System.out.println("chcesz włozyc pojazdy do garazu ok");
                 System.out.print("Podaj typ pojazdu ");
                 System.out.print("1. Amfibia, 2. Lodz, 3. Motocykl, 4. Samochod Miejski, 5. Samochod Terenowy");
                 int typ = scanner.nextInt();
                 if (typ == 1) {
                     System.out.print("Podaj nazwe pojazdu ");
                     String nazwa = scanner.next();
                     System.out.println(nazwa);
                     System.out.print("podaj jak duzy jest twoj pojazd: ");
                     int powierzchnia = scanner.nextInt();
                     System.out.print("podaj ilosc Drzwi");
                     int iloscDrzwi = scanner.nextInt();
                     Amfibia p = new Amfibia(nazwa, powierzchnia, iloscDrzwi);
                     System.out.print("Wybierz sobie miejsce parkingowe ");
                     int miejsce = scanner.nextInt();
                     if (parking[miejsce] == null) {
                         parking[miejsce] = p;
                         System.out.println("dodano Amfibie do garazu");
                     }else {
                         System.out.println("Niestety cos stoi na tym miejscu i nie mozna dodac pojazdu na to miejsce" );
                     }
                 }else if (typ == 2) {
                     System.out.print("Podaj nazwe pojazdu ");
                     String nazwa = scanner.next();
                     System.out.print("podaj jak duzy jest twoj pojazd: ");
                     int powierzchnia = scanner.nextInt();
                     System.out.print("podaj typ pojazdu np.Diesel / benzyna");
                     String typPojazdu = scanner.next();
                     Lodz p = new Lodz(nazwa, powierzchnia, typPojazdu);
                     System.out.print("Wybierz sobie miejsce parkingowe ");
                     int miejsce = scanner.nextInt();
                     if (parking[miejsce] == null) {
                        parking[miejsce] = p;
                         System.out.println("dodano łodz do garazu");
                     }else {
                         System.out.println("Niestety cos stoi na tym miejscu i nie mozna dodac pojazdu na to miejsce");
                     }
                 }else if (typ == 3) {
                     System.out.print("Podaj nazwe pojazdu ");
                     String nazwa = scanner.next();
                     System.out.print("podaj jak duzy jest twoj pojazd: ");
                     int powierzchnia = scanner.nextInt();
                     System.out.print("podaj ilosc kol ");
                     int iloscKol = scanner.nextInt();
                     Motocykl p = new Motocykl(nazwa, powierzchnia, iloscKol);
                     System.out.print("Wybierz sobie miejsce parkingowe ");
                     int miejsce = scanner.nextInt();
                     if (parking[miejsce] == null) {
                         parking[miejsce] = p;
                         System.out.println("Dodano motocykl do garazu ");
                     }else {
                         System.out.println("Niestety cos stoi na tym miejscu i nie mozna dodac pojazdu na to miejsce");
                     }
                 }else if (typ == 4) {
                     // Samochod miejski
                     System.out.print("Podaj nazwe pojazdu ");
                     String nazwa = scanner.next();
                     System.out.print("podaj jak duzy jest twoj pojazd: ");
                     int powierzchnia = scanner.nextInt();
                     System.out.print("podaj typ silnika ");
                     TypSilnika typSilnika = TypSilnika.valueOf(scanner.next().toUpperCase());
                     SamochodMiejski p = new SamochodMiejski(nazwa, powierzchnia, typSilnika);
                     System.out.print("Wybierz sobie miejsce parkingowe ");
                     int miejsce = scanner.nextInt();
                     if (parking[miejsce] == null) {
                         parking[miejsce] = p;
                         System.out.println("Dodano samochod miejski do garazu ");
                     }else {
                         System.out.println("Niestety cos stoi na tym miejscu i nie mozna dodac pojazdu na to miejsce");
                     }

                     if (index > parking.length) {
                         System.out.println("przepraszam ale za duzo rzeczy wkladasz, garaz tyle nie pomiesci");
                     }

                 }else if (typ == 5) {
                     // Samochod terenowy
                     System.out.print("Podaj nazwe pojazdu ");
                     String nazwa = scanner.next();
                     System.out.print("podaj jak duzy jest twoj pojazd: ");
                     int powierzchnia = scanner.nextInt();
                     System.out.print("podaj konie mechaniczne samochodu ");
                     int konieMechaniczne = scanner.nextInt();
                     SamochodTerenowy p = new SamochodTerenowy(nazwa, powierzchnia, konieMechaniczne);
                     System.out.print("Wybierz sobie miejsce parkingowe ");
                     int miejsce = scanner.nextInt();
                     if (parking[miejsce] == null) {
                         parking[miejsce] = p;
                         System.out.println("Dodano samochod terenowy do garazu ");
                     }else {
                         System.out.println("Niestety cos stoi na tym miejscu i nie mozna dodac pojazdu na to miejsce");
                     }
                 }else {
                     System.out.println("Niestety taki typ pojazdu nie znajduje sie w bazie, sory");
                 }


             }else if (x == 7) {
                 System.out.println("chcesz wyjac cos z garazu super");
                 System.out.print("Podaj miejsce parkingowe swojego pojazdu ");
                 int miejsce = scanner.nextInt();
                 System.out.println("Twoj pojazd: " + parking[miejsce] + " zostaje usuniety z garazu");
                 parking[miejsce] = null;
             }else if (x == 8) {
                 System.out.println("chcesz zapisac osiedle, juz sie robi");
                 // Zapisywanie do pliku w projekcie https://www.w3schools.com/java/java_files_create.asp
                 try {
                     File f = new File("osiedle.txt");
                     if (f.createNewFile()) {
                         System.out.println("stan osiedla został zapisany tutaj: " + f.getName());
                     } else {
                         System.out.println("Osiedle juz istnieje ale zostało nadpisane przez nowe dane.");
                         FileWriter fw = new FileWriter("osiedle.txt");
                         fw.write("MIESZKANCY \n");
                         for (int i = 0; i < mieszkancy.size(); i++) {
                             fw.write("Mieszkaniec " + i+ "\n");
                             fw.write(mieszkancy.get(i).getInfo() + "\n");
                             System.out.println(mieszkancy.get(i).getInfo());
                         }
                         fw.write("POJAZDY \n");
                         for (int i = 0; i < parking.length; i++) {
                             fw.write("Miejsce Parkingowe " + i + "\n");
                             fw.write(parking[i] + "\n");
                         }
                         fw.write("MIESZKANIA \n");
                         Arrays.sort(mieszkanie);
                         for (int i = 0; i < mieszkanie.length; i++) {
                             fw.write("Mieszkanie " + i+ "\n");
                             fw.write(mieszkanie[i]+ "\n");
                         }
                         fw.close();
                     }
                 } catch (IOException e) {
                     System.out.println("An error occurred.");
                     e.printStackTrace();
                 }
             }
         }
    }

    public void wyswietlanie() {
        System.out.println("Witaj na osiedlu " + numerOsiedla);
        System.out.println("Nacisnij guzik aby wykonac operacje ");
        System.out.println("0 - zakonczenie programu");
        System.out.println("1 - powiedz kim jestes ");
        System.out.println("2 - wpisz swoje dane");
        System.out.println("3 - wyswietl wolne pomieszczenia");
        System.out.println("4 - wynajecie nowego pomieszczenia");
        System.out.println("5 - wyswietlenie pomieszczenia wynajmowanego przez kogos innego oraz wyswietlenie zawartosci pomieszczenia");
        System.out.println("6 - włozyc pojazdy / przedmioty, pamietaj aby nie wkładac za duzo");
        System.out.println("7 - wyjecie pojazdow lub przedmiotow");
        System.out.println("8 - zapisz aktualne osiedle do pliku");
    }

}
