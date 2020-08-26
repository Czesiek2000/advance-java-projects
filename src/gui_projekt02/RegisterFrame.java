package gui_projekt02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RegisterFrame extends JFrame{
    JButton register;
    JLabel username, password, message;
    JTextField userField;
    JPasswordField userPassword;
    JPanel mainP, registerP, userP, passP;
    public RegisterFrame() {
        register = new JButton("Register");
        username = new JLabel("User name");
        password = new JLabel("Password");
        userField = new JTextField();
        userPassword = new JPasswordField();

        registerP = new JPanel();
        userP = new JPanel();
        passP = new JPanel();
        mainP = new JPanel();

        userP.setLayout(new GridLayout(1,2));
        userP.add(username);
        userP.add(userField);
        passP.setLayout(new GridLayout(1,2));
        passP.add(password);
        passP.add(userPassword);
        mainP.add(userP);
        mainP.add(passP);
        mainP.add(register);
        message = new JLabel();
        mainP.add(message);
        mainP.setLayout(new GridLayout(4,1));
        getContentPane().add(mainP, BorderLayout.CENTER);

        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (actionEvent.getSource() == register) {
                    saveToFile(userField.getText(), String.valueOf(userPassword.getPassword()));
                    userField.setText("");
                    userPassword.setText("");
                }
                dispose();
            }
        });

        setSize(new Dimension(500, 400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);


    }

    // Funkcje logowania zaczerpniete i zmodyfikowane z tego filmu https://www.youtube.com/watch?v=XrktMbcoeis&t=703s
    public void saveToFile(String userName, String passwd) {
        try {
            File f = new File("db.txt");
            if (f.createNewFile()) {
                System.out.println("Zostałes zapisany tutaj " + f.getName());
            }else {
                String text = userName + ", " + passwd;
                System.out.println("Baza danych uzytkownikow zaktualizowana");
                BufferedWriter writer = new BufferedWriter(new FileWriter("db.txt", true));
                writer.newLine();
                writer.append(text);
                writer.close();
            }
        } catch(IOException e) {
            System.out.println("Error occured");
            e.printStackTrace();
        }
    }
}
