package gui_projekt02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Menu extends JFrame {
    JButton jb1;
    JButton jb2;
    JButton jb3;
    JButton jb4;
    JButton jb5;
    JButton jb6;
    JButton jb7;

    public Menu(ArrayList<Magazyn> magazyny, ArrayList<Przedmiot> przedmioty) {

        setLayout(new FlowLayout());
        jb1 = new JButton("Wyswietlenie wszystkich magazynow");
        jb2 = new JButton("Lista wszystkich przedmiot");
        jb3 = new JButton("Dodanie nowego magazynu");
        jb4 = new JButton("Utworzenie nowego przedmiotu");
        jb5 = new JButton("Dodanie przedmiotu do konretnego magazynu");
        jb6 = new JButton("Zestawienie wszystkich magazynow i przedmioty znajdujace sie w nich");
        jb7 = new JButton("Zapis i wczytanie z/do pliku");
        jb1.setPreferredSize(new Dimension(100, 20));
        jb2.setPreferredSize(new Dimension(100, 20));
        jb3.setPreferredSize(new Dimension(100, 20));
        jb4.setPreferredSize(new Dimension(100, 20));
        jb5.setPreferredSize(new Dimension(100, 20));
        jb6.setPreferredSize(new Dimension(100, 20));
        jb7.setPreferredSize(new Dimension(100, 20));
        add(jb1);
        add(jb2);
        add(jb3);
        add(jb4);
        add(jb5);
        add(jb6);
        add(jb7);
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new ShowFrame(magazyny);
            }
        });

        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new ListFrame(przedmioty);
            }
        });

        jb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new AddMagazyn(magazyny);
            }
        });

        jb4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new AddPrzedmiot(przedmioty);
            }
        });

        jb5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new AddToSMag(przedmioty, magazyny);
            }
        });

        jb6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new ShowZestawienie(przedmioty, magazyny);
            }
        });

        jb7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new SaveAppToFile(magazyny, przedmioty);
            }
        });
        setLayout(new GridLayout(7,1));
        setTitle("Projekt 2 - Michał Czech");
        setSize(new Dimension(800, 800));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
