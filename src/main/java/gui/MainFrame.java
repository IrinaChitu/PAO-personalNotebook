package gui;


import java.awt.*;
import javax.swing.*;


public class MainFrame
{
    JFrame mainFrame = new JFrame("My Personal Notebook");
    JPanel mainPanel = new JPanel();
    JLabel jlabel = new JLabel("Hello! What is your name?");
    JTextField text1 = new JTextField();
    JButton b = new JButton("Heyo!");



    JButton button1 = new JButton("Button 1");
    JButton button2 = new JButton("Button 2");

    public MainFrame()
    {
        text1.setBounds(130,100, 200,30);

        text1.setAlignmentY(Component.CENTER_ALIGNMENT);
        text1.setAlignmentX(Component.CENTER_ALIGNMENT);
        jlabel.setAlignmentY(Component.CENTER_ALIGNMENT);
        jlabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        button1.setAlignmentX(Component.CENTER_ALIGNMENT);
        button2.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(jlabel);
        mainFrame.add(text1);
        mainFrame.add(b);

        mainPanel.add(button1);
        mainPanel.add(button2);
        mainFrame.add(mainPanel);
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}


