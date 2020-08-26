package gui_projekt02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddMagazyn extends JFrame {
    JButton btn;
    JTextField powierzchnia, lokalizacja;
    JPanel panel, powierzchniaPanel, lokalizacjaPanel;
    JLabel powierzchnia_label, lokalizacja_label, confirm;
    public AddMagazyn(ArrayList<Magazyn> magazyny) {
        setLayout(new GridLayout(3,1));
        setTitle("Dodanie magazynu");
        btn = new JButton("Dodaj");
        powierzchnia = new JTextField();
        lokalizacja = new JTextField();
        powierzchnia_label = new JLabel("Powierzchnia");
        lokalizacja_label = new JLabel("Lokalizacja");
        panel = new JPanel();
        powierzchniaPanel = new JPanel();
        lokalizacjaPanel = new JPanel();
        confirm = new JLabel();

        powierzchnia.setPreferredSize(new Dimension(300, 30));
        lokalizacja.setPreferredSize(new Dimension(300, 30));
        btn.setPreferredSize(new Dimension(300, 20));
        powierzchniaPanel.setLayout(new FlowLayout());
        powierzchniaPanel.add(powierzchnia_label);
        powierzchniaPanel.add(powierzchnia);

        lokalizacjaPanel.setLayout(new FlowLayout());
        lokalizacjaPanel.add(lokalizacja_label);
        lokalizacjaPanel.add(lokalizacja);

        panel.add(powierzchniaPanel);
        panel.add(lokalizacjaPanel);
        panel.add(btn);
        getContentPane().add(panel);
        getContentPane().add(confirm);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (actionEvent.getSource() == btn) {
                    String powierzchniaValue = powierzchnia.getText();
                    String lokalizacjaValue = lokalizacja.getText();
                    if (lokalizacjaValue.equals("") || powierzchniaValue.equals("")) {
                        JOptionPane.showMessageDialog(null,"Prosze wprowadzic dane");
                    }else {
                        System.out.println("wprowadzono dane " + powierzchniaValue + " " + lokalizacjaValue);
                        int powierzchniaInt = Integer.parseInt(powierzchniaValue);
                        Magazyn magazyn = new Magazyn(powierzchniaInt, lokalizacjaValue);
                        magazyny.add(magazyn);
                        powierzchnia.setText("");
                        lokalizacja.setText("");
                        confirm.setText("Pomyslnie dodano dane");
                    }
                }
            }
        });

        setSize(new Dimension(500, 400));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
