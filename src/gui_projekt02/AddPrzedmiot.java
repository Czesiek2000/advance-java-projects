package gui_projekt02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddPrzedmiot extends JFrame {

    JButton btn;
    JTextField przedmiotNazwa, przedmiotPowierzchnia, przedmiotOpis;
    JPanel panel, panelNazwa, powierzchniaPanel, opisPanel;
    JLabel nazwa_label, powierzchnia_label, opis_label, confirm;
    public AddPrzedmiot(ArrayList<Przedmiot> przedmioty) {
        btn = new JButton("Dodaj");
        przedmiotPowierzchnia = new JTextField();
        przedmiotNazwa = new JTextField();
        przedmiotOpis= new JTextField();
        nazwa_label = new JLabel("Nazwa");
        powierzchnia_label = new JLabel("Powierzchnia");
        opis_label = new JLabel("Opis przedmiotu");
        confirm = new JLabel();

        panel = new JPanel();
        panelNazwa = new JPanel();
        powierzchniaPanel = new JPanel();
        opisPanel = new JPanel();

        przedmiotPowierzchnia.setPreferredSize(new Dimension(300, 30));
        przedmiotNazwa.setPreferredSize(new Dimension(300, 30));
        przedmiotOpis.setPreferredSize(new Dimension(300, 30));
        btn.setPreferredSize(new Dimension(300, 20));

        panelNazwa.setLayout(new FlowLayout());
        panelNazwa.add(nazwa_label);
        panelNazwa.add(przedmiotNazwa);

        powierzchniaPanel.setLayout(new FlowLayout());
        powierzchniaPanel.add(powierzchnia_label);
        powierzchniaPanel.add(przedmiotPowierzchnia);

        opisPanel.setLayout(new FlowLayout());
        opisPanel.add(opis_label);
        opisPanel.add(przedmiotOpis);


        panel.add(panelNazwa);
        panel.add(powierzchniaPanel);
        panel.add(opisPanel);
        panel.add(btn);
        getContentPane().add(panel);
        getContentPane().add(confirm);


        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (actionEvent.getSource() == btn) {
                    String przedmiotNazwaValue = przedmiotNazwa.getText();
                    String przedmiotPowierzchniaValue = przedmiotPowierzchnia.getText();
                    String przedmiotOpisValue = przedmiotOpis.getText();
                    Integer powierzchniaInt = Integer.parseInt(przedmiotPowierzchniaValue);
                    if (przedmiotNazwaValue.equals("") || przedmiotPowierzchniaValue.equals("") || przedmiotOpisValue.equals("")){
                            JOptionPane.showMessageDialog(null, "Wprowadzono błędne dane, wprowadź poprawne dane");
                    }else {
                        Przedmiot p = new Przedmiot(przedmiotNazwaValue, powierzchniaInt, przedmiotOpisValue);
                        przedmioty.add(p);
                        przedmiotNazwa.setText("");
                        przedmiotPowierzchnia.setText("");
                        przedmiotOpis.setText("");
                        confirm.setText("Pomyslnie dodano dane");
                    }
                }
            }
        });
        setLayout(new GridLayout(4,1));
        setTitle("Stworzenie przedmiotu przedmiotu");

        setSize(new Dimension(500, 800));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
