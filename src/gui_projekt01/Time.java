package gui_projekt01;

public class Time extends Thread {
    public static int dzien = 0;

    @Override
    public void run() {
        while (dzien != 31) {
            try {
                Thread.sleep(5000);
                setDzien();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static int getDzien() {
        return dzien;
    }

    public static void setDzien() {
        dzien+= 1;
    }

    public static void setZero() {
        dzien = 0;
    }
}
