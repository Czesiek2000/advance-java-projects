package gui_projekt02;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ListFrame extends JFrame {
    JPanel panel;
    JList jlist;
    JLabel label;
    public ListFrame(ArrayList<Przedmiot> przedmioty) {
        AbstractListModel<String> alm = new AbstractListModel<String>() {
            @Override
            public int getSize() {
                return przedmioty.size();
            }

            @Override
            public String getElementAt(int index) {
                Przedmiot p = przedmioty.get(index);
                return p.id + ". " + p.nazwa + ", zajmuje " + p.powierzchnia + ", opis: " + p.opis;
            }
        };

        jlist = new JList();
        panel = new JPanel();
        label = new JLabel();
        jlist.setModel(alm);
        panel.add(jlist);
        getContentPane().add(panel, BorderLayout.CENTER);

        setTitle("Wyswietlenie listy przedmiotow");
        setSize(new Dimension(500, 400));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
