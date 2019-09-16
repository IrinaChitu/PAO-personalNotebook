package gui;

import services.EventService;
import services.NoteService;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;



public class Interfata_JFrame {

    public Interfata_JFrame() {
        JFrame frame = new JFrame("My Personal Notebook");

        JTextField text1;
        JLabel jlabel = new JLabel("Hello! What is your name?");
        jlabel.setBounds(165,50, 200,30);
        frame.getContentPane().add(jlabel);
        text1 = new JTextField();
        text1.setBounds(140,100, 200,30);
        frame.add(text1);

        JButton b = new JButton("Heyo!");
        b.setBounds(190,150,95,30);

        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);

                String name = text1.getText();
                JFrame welcome = new JFrame(name + "'s Personal Notebook");
                JPanel buttons = new JPanel();


                JLabel welcome_label =  new JLabel("Welcome back, " + name+ "! What would you like to do?");

//                JLabel question_label =  new JLabel("");
//                question_label.setBounds(200, 100, 200, 30);
//                welcome.add(question_label);

                JButton bevent = new JButton("Add an event!");
                bevent.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent addEv){
                        JFrame addEvframe = new JFrame(name + "'s Personal Notebook");
                        JLabel event =  new JLabel("Add event:");
                        event.setBounds(0, 0, 200, 30);
                        addEvframe.add(event);

                        JTextField getdate = new JTextField("Data");
                        getdate.setBounds(100,40, 200,30);

                        JTextField getdesc = new JTextField("Description");
                        getdesc.setBounds(100,70, 200,30);

                        JTextField getbirthdayPerson = new JTextField("Person");
                        getbirthdayPerson.setBounds(100,110, 200,30);

                        JTextField getpartyPlace = new JTextField("Place");
                        getpartyPlace.setBounds(100,150, 200,30);

                        JTextField getgift = new JTextField("gift");
                        getgift.setBounds(100,190, 200,30);

                        addEvframe.getContentPane().add(getdate);
                        addEvframe.getContentPane().add(getdesc);
                        addEvframe.getContentPane().add(getbirthdayPerson);
                        addEvframe.getContentPane().add(getpartyPlace);
                        addEvframe.getContentPane().add(getgift);

                        addEvframe.setSize(new Dimension(600,400));
                        addEvframe.setVisible(true);
                    }

                });

                // dupa te duce intr un mentiu cu cele posibile
                JButton bnote = new JButton("Add a note!");
//                bnote.setBounds(150,400,95,30);

                JButton getAnniversaries = new JButton("getAnniversaries");
                getAnniversaries.setBounds(150,400,95,30);
                getAnniversaries.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent evAnniv){
                        JFrame getAniv = new JFrame(name + "'s Personal Notebook");
                        JLabel annivs =  new JLabel("Anniversaries:");
                        annivs.setBounds(0, 0, 200, 30);
                        getAniv.add(annivs);

                        EventService eventService = EventService.getInstance();
                        JTextArea area=new JTextArea(eventService.objectToString(eventService.getAnniversaries()));
                        area.setBounds(10,50, 200,200);
                        getAniv.add(area);

                        getAniv.setSize(new Dimension(200,400));
                        getAniv.setVisible(true);
                    }

                });
                getAnniversaries.setSize(new Dimension(400,400));

                JButton getMeetings = new JButton("getMeetings");
                getMeetings.setBounds(150,400,95,30);
                getMeetings.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent evMeet){
                        JFrame getMeet = new JFrame(name + "'s Personal Notebook");
                        JLabel meets =  new JLabel("Meetings:");
                        meets.setBounds(0, 0, 200, 30);
                        getMeet.add(meets);

                        EventService eventService = EventService.getInstance();
                        JTextArea area = new JTextArea(eventService.objectToString(eventService.getMeetings()));
                        area.setBounds(10,50, 200,200);
                        getMeet.add(area);

                        getMeet.setSize(new Dimension(200,400));
                        getMeet.setVisible(true);
                    }

                });


                JButton getQuotes = new JButton("getQuotes");
                getQuotes.setBounds(150,400,95,30);
                getQuotes.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent evQuote){
                        JFrame getQuo = new JFrame(name + "'s Personal Notebook");
                        JLabel quo =  new JLabel("Quotes:");
                        quo.setBounds(0, 0, 200, 30);
                        getQuo.add(quo);

                        NoteService noteService = NoteService.getInstance();
                        JTextArea area = new JTextArea(noteService.objectToString(noteService.getQuotes()));
                        area.setBounds(10,50, 200,200);
                        getQuo.add(area);

                        getQuo.setSize(new Dimension(200,400));
                        getQuo.setVisible(true);
                    }

                });

                JButton findBirthdayPersonByDate = new JButton("findBirthdayPersonByName");
                findBirthdayPersonByDate.setBounds(150,400,95,30);
                findBirthdayPersonByDate.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent evBirthDay){
                        JFrame getBirthday = new JFrame(name + "'s Personal Notebook");
                        JLabel births =  new JLabel("BirthdayPersonByDate:");
                        births.setBounds(0, 0, 200, 30);
                        getBirthday.add(births);

                        JTextField nametext = new JTextField("Insert Name");

                        nametext.setBounds(130,100, 200,30);
                        getBirthday.add(nametext);


                        JButton insertname = new JButton("search");
//                        insertdate.setBounds(150,400,95,30);
                        insertname.setSize(20,20);
                        insertname.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent evsearch) {
                                String name = nametext.getText();
                                System.out.println(name);
                                EventService eventService = EventService.getInstance();
                                System.out.println(eventService.objectToString(eventService.findBirthdayPersonByName(name)));
                                JTextArea area = new JTextArea(eventService.objectToString(eventService.findBirthdayPersonByName(name)));
                                area.setBounds(10,50, 200,200);
                                getBirthday.add(area);
                            }
                        });

                        getBirthday.getContentPane().setLayout(null);
                        getBirthday.getContentPane().add(insertname);



                        getBirthday.setSize(new Dimension(400,400));
                        getBirthday.setVisible(true);
                    }

                });

                JButton findEventsByDate = new JButton("findEventsByDate");
//                findEventsByDate.setBounds(150,400,95,30);
                findEventsByDate.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent findEvevent){
                        JFrame findEv = new JFrame(name + "'s Personal Notebook");
                        JLabel meets =  new JLabel("Events on:");
                        meets.setBounds(0, 0, 200, 30);
                        findEv.add(meets);

                        JTextField datetext = new JTextField("Insert Date");

                        datetext.setBounds(130,100, 200,30);
                        findEv.add(datetext);

                        JButton insertdate = new JButton("search");
                        insertdate.setSize(20,20);
                        insertdate.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent evsearchh) {
                                String dateTemp = datetext.getText();
                                Date date = null;
                                try {
                                    date = new SimpleDateFormat("dd/MM/yyyy").parse(dateTemp);
                                } catch (ParseException e1) {
                                    e1.printStackTrace();
                                }
                                EventService eventService = EventService.getInstance();
                                System.out.println(date);
                                System.out.println(eventService.objectToString(eventService.findByDate(date)));
                                JTextArea area = new JTextArea(eventService.objectToString(eventService.findBirthdayPersonByName(name)));
                                area.setBounds(10,50, 200,200);
                                findEv.add(area);
                            }
                        });

                        findEv.getContentPane().setLayout(null);
                        findEv.getContentPane().add(insertdate);

                        findEv.setSize(new Dimension(200,400));
                        findEv.setVisible(true);
                    }

                });

                welcome_label.setAlignmentX(Component.CENTER_ALIGNMENT);

                welcome_label.setSize(200, 30);
//                welcome.add(welcome_label);

                bevent.setAlignmentX(Component.CENTER_ALIGNMENT);
                bnote.setAlignmentX(Component.CENTER_ALIGNMENT);
                getAnniversaries.setAlignmentX(Component.CENTER_ALIGNMENT);
                getMeetings.setAlignmentX(Component.CENTER_ALIGNMENT);
                getQuotes.setAlignmentX(Component.CENTER_ALIGNMENT);
                findBirthdayPersonByDate.setAlignmentX(Component.CENTER_ALIGNMENT);
                findEventsByDate.setAlignmentX(Component.CENTER_ALIGNMENT);

                buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));

                buttons.add(welcome_label);
                buttons.add(bevent);
                buttons.add(bnote);
                buttons.add(getAnniversaries);
                buttons.add(getMeetings);
                buttons.add(getQuotes);
                buttons.add(findBirthdayPersonByDate);
                buttons.add(findEventsByDate);

//                welcome.setLayout(new FlowLayout());
                welcome.add(buttons);
                welcome.setSize(new Dimension(600,700));
                welcome.setLocationRelativeTo(null);
                welcome.setVisible(true);
                welcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


            }
        });
        frame.add(b);

        frame.setLocationByPlatform(true);
        frame.setSize(new Dimension(500, 300));
        frame.getContentPane().setBackground(Color.WHITE);

        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


//        JFrame f= new JFrame("Prima aplicatie grafica!");
//        f.setSize(new Dimension(300, 300));
//        f.getContentPane().setBackground(Color.YELLOW);
//        f.getContentPane().setLayout(new FlowLayout());
//        f.getContentPane().add(new JLabel("Prima eticheta"));
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        f.setVisible(true);
//
//        JFrame formular=new JFrame("Prima aplicatie grafica");
//        formular.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        formular.setSize(new Dimension(300,300));
//        formular.setLayout(new FlowLayout());
//        JPanel panou=new JPanel();
//        panou.setBackground(Color.BLUE);
//        panou.add(new Label("Eticheta"));
//        formular.setContentPane(panou);
//        formular.setVisible(true);
    }

}
