package gui_projekt02;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ShowFrame extends JFrame {
    DefaultListModel<Magazyn> magazynModel;
    JList<Magazyn> magazynList;
    public ShowFrame(ArrayList<Magazyn> magazyny) {
        MyTableModel mtm = new MyTableModel();
        mtm.addMagazyn(magazyny);
        JTable table = new JTable();
        table.setModel(mtm);

        getContentPane().add(table);
        getContentPane().add(table.getTableHeader(), BorderLayout.NORTH);
        setTitle("Wyswitlenie magazynow");
        setSize(new Dimension(500, 400));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
