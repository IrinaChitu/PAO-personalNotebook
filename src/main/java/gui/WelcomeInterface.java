package gui;

import javax.swing.*;
import java.awt.*;

public class WelcomeInterface {

    public WelcomeInterface() {
        // String name = text1.getSource();
        JFrame welcome = new JFrame("Name's Personal Notebook");
        welcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcome.setSize(new Dimension(400,400));
        welcome.setLayout(new FlowLayout());
//                JPanel panou=new JPanel();
//                panou.setBackground(Color.BLUE);
        JLabel welcome_label =  new JLabel("Welcome back, Name!");
        welcome_label.setBounds(10, 10, 200, 30);
        welcome.add(welcome_label);
        JLabel question_label =  new JLabel("What would you like to do?");
        question_label.setBounds(200, 100, 200, 30);
        welcome.add(question_label);

        JButton bevent = new JButton("Add an event!");
        bevent.setBounds(350,300,95,30);
        welcome.add(bevent);

        // dupa te duce intr un mentiu cu cele posibile
        JButton bnote = new JButton("Add a note!");
        bnote.setBounds(150,400,95,30);
        welcome.add(bnote);

        JButton getAnniversaries = new JButton("Add a note!");
        getAnniversaries.setBounds(150,400,95,30);
        welcome.add(getAnniversaries);

        JButton getMeetings = new JButton("Add a note!");
        getMeetings.setBounds(150,400,95,30);
        welcome.add(getMeetings);

        JButton findBirthdayPersonByDate = new JButton("Add a note!");
        findBirthdayPersonByDate.setBounds(150,400,95,30);
        welcome.add(findBirthdayPersonByDate);

        JButton findEventsByDate = new JButton("Add a note!");
        findEventsByDate.setBounds(150,400,95,30);
        welcome.add(findEventsByDate);

        welcome.setVisible(true);
    }
}
