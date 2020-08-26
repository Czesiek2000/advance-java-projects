package gui_projekt02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddToSMag extends JFrame {
    static int gid = 0;
    int id;
    ArrayList<Przedmiot> listaPrzedmiotow;
    JButton dodaj;
    JLabel nazwa, powierzchnia, opis, magazynID;
    JTextField pNazwa, pPowierzchnia, pOpis, magazynIDf;
    JPanel mainPanel, panel, panel2, panel3, panel4;
    public AddToSMag(ArrayList<Przedmiot> przedmioty, ArrayList<Magazyn> magazyny) {
        gid++;
        id = gid;
        listaPrzedmiotow = new ArrayList<>();
        dodaj = new JButton("Dodaj");
        nazwa = new JLabel("Nazwa przedmiotu");
        powierzchnia = new JLabel("Powierzchnia przedmiotu");
        opis = new JLabel("Opis przedmiotu");

        magazynID = new JLabel("Numer magazynu ");
        pNazwa = new JTextField();
        pPowierzchnia = new JTextField();
        pOpis = new JTextField();
        magazynIDf = new JTextField();
        mainPanel = new JPanel();
        panel = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();

        dodaj.setPreferredSize(new Dimension(300, 20));
        pNazwa.setPreferredSize(new Dimension(300, 30));
        pPowierzchnia.setPreferredSize(new Dimension(300, 30));
        pOpis.setPreferredSize(new Dimension(300, 30));
        magazynIDf.setPreferredSize(new Dimension(300, 30));

        panel.setLayout(new FlowLayout());
        panel.add(nazwa);
        panel.add(pNazwa);

        panel2.setLayout(new FlowLayout());
        panel2.add(powierzchnia);
        panel2.add(pPowierzchnia);

        panel3.setLayout(new FlowLayout());
        panel3.add(opis);
        panel3.add(pOpis);

        panel4.setLayout(new FlowLayout());
        panel4.add(magazynID);
        panel4.add(magazynIDf);

        mainPanel.add(panel);
        mainPanel.add(panel2);
        mainPanel.add(panel3);
        mainPanel.add(panel4);
        mainPanel.add(dodaj);
        setLayout(new GridLayout(1,6));
        getContentPane().add(mainPanel);

        dodaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (actionEvent.getSource() == dodaj) {
                    String przedmiotNazwaValue = pNazwa.getText();
                    String przedmiotPowierzchniaValue = pPowierzchnia.getText();
                    String przedmiotOpisValue = pOpis.getText();
                    Integer powierzchniaInt = Integer.parseInt(przedmiotPowierzchniaValue);
                    int magazyn = Integer.parseInt(magazynIDf.getText());
                    if (przedmiotNazwaValue.equals("") || przedmiotPowierzchniaValue.equals("") || przedmiotOpisValue.equals("")){
                        JOptionPane.showMessageDialog(null, "Wprowadzono błędne dane, wprowadź poprawne dane");
                    }else {
                        System.out.println("Add przedmiot: wprowadzono poprawne dane");
                        Przedmiot p = new Przedmiot(przedmiotNazwaValue, powierzchniaInt, przedmiotOpisValue);
                        for (Magazyn m : magazyny) {
                            if (m.id == magazyn){
                                m.dodajPrzedmiot(p);
                            }
                        }
                        pNazwa.setText("");
                        pPowierzchnia.setText("");
                        pOpis.setText("");
                        magazynIDf.setText("");

                    }
                }
            }
        });

        setTitle("Dodanie do konretnego magazynu");
        setSize(new Dimension(500, 400));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
