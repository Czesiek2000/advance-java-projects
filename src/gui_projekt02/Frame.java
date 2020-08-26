package gui_projekt02;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Frame extends JFrame {
    JButton login, register;
    JTextField jtf;
    JPasswordField jtf2, jtfc;
    JPanel panel, userPanel, passwordPanel, loginPanel;
    JLabel user_label, password_label, message;
    public static Scanner x;

    public Frame(ArrayList<Magazyn> magazyny, ArrayList<Przedmiot> przedmioty) {
        setTitle("Login");
        user_label = new JLabel();
        user_label.setText("User name: ");

        jtf = new JTextField();

        password_label = new JLabel();
        password_label.setText("Password: ");
        jtf2 = new JPasswordField();

        login = new JButton();
        login.setText("Login");
        login.setSize(400, 1);

        register = new JButton();
        register.setText("Register");

        userPanel = new JPanel();
        passwordPanel = new JPanel();
        panel = new JPanel();
        userPanel.add(user_label);
        userPanel.add(jtf);
        jtf.setPreferredSize(new Dimension(250, 40));

        userPanel.setLayout(new FlowLayout());
        userPanel.setBorder(new EmptyBorder(10, 10, 0, 10));

        passwordPanel.add(password_label);
        passwordPanel.add(jtf2);
        jtf2.setPreferredSize(new Dimension(250, 40));

        passwordPanel.setLayout(new FlowLayout());
        passwordPanel.setBorder(new EmptyBorder(0, 20, 0, 10));

        loginPanel = new JPanel();
        loginPanel.setBorder(new EmptyBorder(0, 10, 0, 10));

        loginPanel.setLayout(new FlowLayout());
        login.setPreferredSize(new Dimension(250, 28));

        register.setPreferredSize(new Dimension(250, 28));
        loginPanel.add(login);
        loginPanel.add(register);

        panel.setLayout(new GridLayout(4,1));
        panel.add(userPanel);
        panel.add(passwordPanel);
        panel.add(loginPanel);

        message = new JLabel();
        message.setBorder(new EmptyBorder(-140, 40, 0, 0));
        panel.add(message);

        getContentPane().add(panel, BorderLayout.CENTER);
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == login){
                    String userName = jtf.getText();
                    String password = String.valueOf(jtf2.getPassword());

                    jtf.setBorder(new LineBorder(Color.black,1));
                    jtf2.setBorder(new LineBorder(Color.black,1));
                    if (verifyLogin(userName, password)) {
                        System.out.println("Uzyskano dostep");
                        new Menu(magazyny, przedmioty);
                        dispose();
                    } else if (userName.equals("")) {
                        message.setText("Prosze wprowadzic nazwe uzytkownika");
                        jtf.setBorder(new LineBorder(Color.red, 1));
                    } else if (password.equals("")) {
                        message.setText("Prosze wprowadzic hasło");
                        jtf2.setBorder(new LineBorder(Color.red, 1));
                    } else {
                        message.setText("Błedne hasło wprowadz ponownie");
                        JOptionPane.showMessageDialog(null, "Błedne hasło");
                        jtf.setText("");
                        jtf2.setText("");
                        jtf.setBorder(new LineBorder(Color.red, 1));
                        jtf2.setBorder(new LineBorder(Color.red, 1));
                    }
                }
            }
        });

        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new RegisterFrame();
            }
        });

        setSize(new Dimension(800, 800));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

    }


    // Funkcje logowania zaczerpniete i zmodyfikowane z tego filmu https://www.youtube.com/watch?v=XrktMbcoeis&t=703s
    public static boolean verifyLogin(String username, String password) {
        boolean found = false;
        String tmpUser = "";
        String tmpPass = "";

        try {
            x = new Scanner(new File("db.txt"));
            x.useDelimiter("[,\n]");

            while (x.hasNext() && !found){
                tmpUser = x.next();
                tmpPass = x.next();

                if (tmpUser.trim().equals(username.trim()) && tmpPass.trim().equals(password.trim())){
                    found = true;
                }
            }
            x.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return found;
    }
}
