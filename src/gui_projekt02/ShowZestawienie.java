package gui_projekt02;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ShowZestawienie extends JFrame {
    int index = 0;
    JTextArea jta;
    public ShowZestawienie(ArrayList<Przedmiot> przedmioty, ArrayList<Magazyn> magazyny) {
        jta = new JTextArea();
        for( Magazyn m : magazyny ) {
            for ( Przedmiot p : przedmioty ) {
                if (m.id == p.id) {
                    jta.append("Magazyn " + m.id + " przedmiot " + p.id + "\n");
                }
            }
        }

        getContentPane().add(jta);

        setTitle("Wyswietlenie zestawienia");
        setSize(new Dimension(500, 400));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
