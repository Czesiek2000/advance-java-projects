package gui03Project;

public class GamerRandom implements IGamer{
    String imie = "Random";
    int znak;

    public GamerRandom()  {
       double rand = Math.random();
       if (rand < 0.34) {
           znak = 1;
       } else if (rand >= 0.67) {
           znak = 2;
       } else {
           znak = 3;
       }

    }

    public int play() {
        return this.znak;
    }

    public String imie() {
        return this.imie;
    }

//    public String toString() {
//        return "Gracz " +  imie() + " wystawił " + play();
//    }
}
