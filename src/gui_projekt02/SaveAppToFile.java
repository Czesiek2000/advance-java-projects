package gui_projekt02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SaveAppToFile extends JFrame {
    JPanel panel, panel2, panel3;
    JButton jb, jb1;
    String nazwaPliku;
    JTextArea jta;
    JTextField jtf;
    public SaveAppToFile(ArrayList<Magazyn> magazyny, ArrayList<Przedmiot> przedmioty) {
        setTitle("Zapis do aplikacji");
        setLayout(new GridLayout(2,1));
        panel = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();

        panel.setPreferredSize(new Dimension(400, 50));
        panel2.setPreferredSize(new Dimension(500, 1600));
        jta = new JTextArea();
        jtf = new JTextField();
        jtf.setPreferredSize(new Dimension(400, 30));
        jb = new JButton("Zapis do pliku ");
        jb1 = new JButton("Odczyt z pliku");
        panel.add(jb);
        panel.add(jb1);
        panel2.add(jta);
        panel3.add(jtf);
        JScrollPane jsp = new JScrollPane(panel2);
        jsp.setPreferredSize(new Dimension(400, 400));
        getContentPane().add(jsp);
//        getContentPane().add(panel3);
        getContentPane().add(panel);

        nazwaPliku = "F:\\Studia\\Gui\\guiProjects\\magazyn.txt";
//        nazwaPliku = jtf.getText();

        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                saveToFile(nazwaPliku, magazyny, przedmioty);
                System.out.println(nazwaPliku);
                JOptionPane.showMessageDialog(null, "Zapisano do pliku " + nazwaPliku);
            }
        });

        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                getFromFile(nazwaPliku);
                JOptionPane.showMessageDialog(null, "Wczytano z pliku " + nazwaPliku);
            }
        });
        setSize(new Dimension(500, 550));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void saveToFile(String nazwaPliku, ArrayList<Magazyn> magazyny, ArrayList<Przedmiot> przedmioty) {
        try {
            File f = new File(nazwaPliku);
            if (f.createNewFile()) {
                System.out.println("Zostałes zapisany tutaj " + f.getName());
            }else {
                System.out.println("Baza danych uzytkownikow zaktualizowana");
                FileWriter fw = new FileWriter(nazwaPliku);
                fw.write("MAGAZYN");

                for ( Magazyn m : magazyny ) {
                    fw.write("\n" + "ID " + m.id + "\n" + "powierzchnia " + m.powierzchnia + "\n" + "lokalizacja " + m.lokalizacja + "\n");
                }

                fw.write("\nPRZEDMIOT");
                for ( Przedmiot p : przedmioty ) {
                    fw.write("\n" + "Id: " + p.id + "\n" + "Nazwa " + p.nazwa + "\n" + "Powierzchnia " + p.powierzchnia + "\n" + "Opis " + p.opis + "\n");
                }

                fw.close();
            }
        } catch(IOException e) {
            System.out.println("Error occured");
            e.printStackTrace();
        }
    }

    public void getFromFile(String nazwaPliku) {
        try {
            File myObj = new File(nazwaPliku);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
//                String data = myReader.nextLine();
                String data = "";
                data += myReader.nextLine() + "\n";
//                System.out.println(data);
                jta.append(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
