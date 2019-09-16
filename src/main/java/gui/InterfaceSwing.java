package gui;

import models.events.Academical;
import models.notes.Quotes;
import models.notes.Story;
import services.EventService;
import services.NoteService;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;



public class InterfaceSwing {

    public InterfaceSwing() {
        EventService eventService = EventService.getInstance();
        NoteService noteService = NoteService.getInstance();


        JFrame frame = new JFrame("My Personal Notebook");

        JTextField insertName;
        JLabel welcomeText = new JLabel("Hello! What is your name?");
        welcomeText.setBounds(165,50, 200,30);
        frame.getContentPane().add(welcomeText);
        insertName = new JTextField();
        insertName.setBounds(140,100, 200,30);
        frame.getContentPane().add(insertName);

        JButton welcomeButton = new JButton("Heyo!");
        welcomeButton.setBounds(190,150,95,30);

        welcomeButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);

                String name = insertName.getText();
                JFrame menuFrame = new JFrame(name + "'s Personal Notebook");
                JPanel buttons = new JPanel();
                buttons.add(Box.createVerticalStrut(100));
                JLabel welcome_label =  new JLabel("Welcome back, " + name+ "! What would you like to do today?");
                JButton addEventButton = new JButton("Add an event!");
                JButton addNoteButton = new JButton("Add a note!");
                JButton updateEventButton = new JButton("Update an event!");
                JButton updateNoteButton = new JButton("Update a note!");
                JButton deleteEventButton = new JButton("Delete an event!");
                JButton deleteNoteButton = new JButton("Delete a note!");
                JButton readEventButton = new JButton("Show all future events!");
                JButton readNoteButton = new JButton("Show all my notes!");

// de vazut cum pot redimensiona butoanele
//                addEventButton.setSize(300, 200);
//                addNoteButton.setSize(300, 200);
//                updateEventButton.setSize(300, 200);
//                updateNoteButton.setSize(new Dimension(300,200));
//                deleteEventButton.setSize(new Dimension(300,200));
//                deleteNoteButton.setSize(new Dimension(300,200));
//                readEventButton.setSize(new Dimension(300,200));
//                readNoteButton.setSize(new Dimension(300,200));
                welcome_label.setBounds(145, 30, 400, 30);

                addEventButton.setAlignmentX(Component.CENTER_ALIGNMENT);
                addNoteButton.setAlignmentX(Component.CENTER_ALIGNMENT);
                updateEventButton.setAlignmentX(Component.CENTER_ALIGNMENT);
                updateNoteButton.setAlignmentX(Component.CENTER_ALIGNMENT);
                deleteEventButton.setAlignmentX(Component.CENTER_ALIGNMENT);
                deleteNoteButton.setAlignmentX(Component.CENTER_ALIGNMENT);
                readEventButton.setAlignmentX(Component.CENTER_ALIGNMENT);
                readNoteButton.setAlignmentX(Component.CENTER_ALIGNMENT);

                addEventButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent addAnEvent) {
                        JFrame eventFrame = new JFrame("Adding an event");
                        JPanel eventAddingOptions = new JPanel();

                        JButton addAcademical = new JButton("Add an academical event!");
                        JButton addAnniversary = new JButton("Add an anniversary!");
                        JButton addMeeting = new JButton("Add a meeting!");
                        JButton addOther = new JButton("Add a random event!");

                        addAcademical.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent addAcademicalEvent) {
                                JFrame addAcademicalFrame = new JFrame("Adding an academical event");
                                JPanel academicalFields = new JPanel();

                                JLabel datefield = new JLabel("DATE");
                                JLabel descriptionfield = new JLabel("DESCRIPTION");
                                JLabel typefield = new JLabel("TYPE");
                                JLabel fieldfield = new JLabel("FIELD");
                                JLabel placefield = new JLabel("PLACE");
                                JLabel startTimefield = new JLabel("STARTING TIME");
                                JLabel endTimefield = new JLabel("ENDING TIME");
                                JTextField insertdate = new JTextField();
                                JTextField insertdescription = new JTextField();
                                JTextField inserttype = new JTextField();
                                JTextField insertfield = new JTextField();
                                JTextField insertplace = new JTextField();
                                JTextField insertstartTime = new JTextField();
                                JTextField insertendTime = new JTextField();
                                JButton addButton = new JButton("Add!");

                                addButton.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent addingEvent) {
                                        try {
                                            eventService.addEvent(new Academical(
                                                    new SimpleDateFormat("dd/MM/yyyy").parse(insertdate.getText()),
                                                    insertdescription.getText(),
                                                    inserttype.getText(),
                                                    insertfield.getText(),
                                                    insertplace.getText(),
                                                    Integer.parseInt(insertstartTime.getText()),
                                                    Integer.parseInt(insertendTime.getText())
                                            ));
                                        } catch (ParseException e1) {
                                            e1.printStackTrace();
                                        }

                                        // in servicii modifica a.i. sa apeleze DB

                                        addAcademicalFrame.setVisible(false);
                                    }
                                });

                                insertdate.setAlignmentX(Component.CENTER_ALIGNMENT);
                                insertdescription.setAlignmentX(Component.CENTER_ALIGNMENT);
                                inserttype.setAlignmentX(Component.CENTER_ALIGNMENT);
                                insertfield.setAlignmentX(Component.CENTER_ALIGNMENT);
                                insertplace.setAlignmentX(Component.CENTER_ALIGNMENT);
                                insertstartTime.setAlignmentX(Component.CENTER_ALIGNMENT);
                                insertendTime.setAlignmentX(Component.CENTER_ALIGNMENT);

                                academicalFields.setLayout(new BoxLayout(academicalFields, BoxLayout.Y_AXIS));

                                academicalFields.add(datefield);
                                academicalFields.add(insertdate);
                                academicalFields.add(descriptionfield);
                                academicalFields.add(insertdescription);
                                academicalFields.add(typefield);
                                academicalFields.add(inserttype);
                                academicalFields.add(fieldfield);
                                academicalFields.add(insertfield);
                                academicalFields.add(placefield);
                                academicalFields.add(insertplace);
                                academicalFields.add(startTimefield);
                                academicalFields.add(insertstartTime);
                                academicalFields.add(endTimefield);
                                academicalFields.add(insertendTime);

                                academicalFields.add(addButton);

                                addAcademicalFrame.getContentPane().add(academicalFields);

                                addAcademicalFrame.setSize(new Dimension(300,500));
                                addAcademicalFrame.setLocationRelativeTo(null);
                                addAcademicalFrame.setVisible(true);
                            }
                        });

                        addAnniversary.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent addAniversary) {
                                JFrame addAniversaryFrame = new JFrame("Adding an aniversary");
                                JPanel aniversaryFields = new JPanel();

                                JLabel datefield = new JLabel("DATE");
                                JLabel descriptionfield = new JLabel("DESCRIPTION");
                                JLabel birthdayPersonfield = new JLabel("BIRTHDAY PERSON");
                                JLabel partyPlacefield = new JLabel("PARTY PLACE");
                                JLabel giftfield = new JLabel("GIFT");
                                JTextField insertdate = new JTextField();
                                JTextField insertdescription = new JTextField();
                                JTextField insertbirthdayPerson = new JTextField();
                                JTextField insertpartyPlace = new JTextField();
                                JTextField insertgift = new JTextField();
                                JButton addButton = new JButton("Add!");

                                addButton.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent addingEvent) {
                                        try {
                                            eventService.addEvent(new Academical(
                                                    new SimpleDateFormat("dd/MM/yyyy").parse(insertdate.getText()),
                                                    insertdescription.getText(),
                                                    insertbirthdayPerson.getText(),
                                                    insertpartyPlace.getText(),
                                                    insertgift.getText()
                                            ));
                                        } catch (ParseException e1) {
                                            e1.printStackTrace();
                                        }

                                        // in servicii modifica a.i. sa apeleze DB

                                        addAniversaryFrame.setVisible(false);
                                    }
                                });

                                insertdate.setAlignmentX(Component.CENTER_ALIGNMENT);
                                insertdescription.setAlignmentX(Component.CENTER_ALIGNMENT);
                                insertbirthdayPerson.setAlignmentX(Component.CENTER_ALIGNMENT);
                                insertpartyPlace.setAlignmentX(Component.CENTER_ALIGNMENT);
                                insertgift.setAlignmentX(Component.CENTER_ALIGNMENT);

                                aniversaryFields.setLayout(new BoxLayout(aniversaryFields, BoxLayout.Y_AXIS));

                                aniversaryFields.add(datefield);
                                aniversaryFields.add(insertdate);
                                aniversaryFields.add(descriptionfield);
                                aniversaryFields.add(insertdescription);
                                aniversaryFields.add(birthdayPersonfield);
                                aniversaryFields.add(insertbirthdayPerson);
                                aniversaryFields.add(partyPlacefield);
                                aniversaryFields.add(insertpartyPlace);
                                aniversaryFields.add(giftfield);
                                aniversaryFields.add(insertgift);

                                aniversaryFields.add(addButton);

                                addAniversaryFrame.getContentPane().add(aniversaryFields);

                                addAniversaryFrame.setSize(new Dimension(300,500));
                                addAniversaryFrame.setLocationRelativeTo(null);
                                addAniversaryFrame.setVisible(true);
                            }
                        });

                        addAcademical.setAlignmentX(Component.CENTER_ALIGNMENT);
                        addAnniversary.setAlignmentX(Component.CENTER_ALIGNMENT);
                        addMeeting.setAlignmentX(Component.CENTER_ALIGNMENT);
                        addOther.setAlignmentX(Component.CENTER_ALIGNMENT);

                        eventAddingOptions.setLayout(new BoxLayout(eventAddingOptions, BoxLayout.Y_AXIS));

                        eventAddingOptions.add(Box.createVerticalStrut(50));
                        eventAddingOptions.add(addAcademical);
                        eventAddingOptions.add(Box.createVerticalStrut(10));
                        eventAddingOptions.add(addAnniversary);
                        eventAddingOptions.add(Box.createVerticalStrut(10));
                        eventAddingOptions.add(addMeeting);
                        eventAddingOptions.add(Box.createVerticalStrut(10));
                        eventAddingOptions.add(addOther);

                        eventFrame.getContentPane().add(eventAddingOptions);

                        eventFrame.setSize(new Dimension(300,300));
                        eventFrame.setLocationRelativeTo(null);
                        eventFrame.setVisible(true);

                    }
                });

                addNoteButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent addANote) {
                        JFrame noteFrame = new JFrame("Adding a note");
                        JPanel noteAddingOptions = new JPanel();

                        JButton addQuote = new JButton("Add a quote!");
                        JButton addStory= new JButton("Add a story!");
                        JButton addTask= new JButton("Add a task!");
                        JButton addThoughts= new JButton("Add a random thought!");

                        addQuote.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent addQuoteNote) {
                                JFrame addQuoteFrame = new JFrame("Adding a quote");
                                JPanel quoteFields = new JPanel();

                                JLabel nameField = new JLabel("NAME");
                                JLabel textField = new JLabel("TEXT");
                                JLabel autohrField = new JLabel("AUTHOR");
                                JTextField insertname = new JTextField();
                                JTextField inserttext = new JTextField();
                                JTextField insertauthor = new JTextField();
                                JButton addButton = new JButton("Add!");

                                addButton.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent addingEvent) {
                                        noteService.addNote(new Quotes(
                                                insertname.getText(),
                                                inserttext.getText(),
                                                insertauthor.getText()
                                        ));

                                        // in servicii modifica a.i. sa apeleze DB

                                        addQuoteFrame.setVisible(false);

                                    }
                                });

                                insertname.setAlignmentX(Component.CENTER_ALIGNMENT);
                                inserttext.setAlignmentX(Component.CENTER_ALIGNMENT);
                                insertauthor.setAlignmentX(Component.CENTER_ALIGNMENT);

                                quoteFields.setLayout(new BoxLayout(quoteFields, BoxLayout.Y_AXIS));

                                quoteFields.add(nameField);
                                quoteFields.add(insertname);
                                quoteFields.add(textField);
                                quoteFields.add(inserttext);
                                quoteFields.add(autohrField);
                                quoteFields.add(insertauthor);

                                quoteFields.add(addButton);


                                addQuoteFrame.getContentPane().add(quoteFields);

                                addQuoteFrame.setSize(new Dimension(300,300));
                                addQuoteFrame.setLocationRelativeTo(null);
                                addQuoteFrame.setVisible(true);
                            }
                        });

                        addStory.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent addStoryNote) {
                                JFrame addStoryFrame = new JFrame("Adding a story");
                                JPanel storyeFields = new JPanel();

                                JLabel nameField = new JLabel("NAME");
                                JLabel textField = new JLabel("TEXT");
                                JLabel placeField = new JLabel("PLACE");
                                JLabel peopleInvolvedField = new JLabel("PEOPLE IN THIS STORY");
                                JTextField insertname = new JTextField();
                                JTextField inserttext = new JTextField();
                                JTextField insertplace = new JTextField();
                                JTextField insertpeopleInvolved = new JTextField();
                                JButton addButton = new JButton("Add!");

                                addButton.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent addANote) {
                                        String[] people = insertpeopleInvolved.getText().split(", ");
                                        Set<String> peopleInvolved = new HashSet<String>();
                                        for (String person: people) {
                                            peopleInvolved.add(person);
                                        }

                                        noteService.addNote(new Story(
                                                insertname.getText(),
                                                inserttext.getText(),
                                                insertplace.getText(),
                                                peopleInvolved
                                        ));

                                        // in servicii modifica a.i. sa apeleze DB

                                        addStoryFrame.setVisible(false);

                                    }
                                });

                                insertname.setAlignmentX(Component.CENTER_ALIGNMENT);
                                inserttext.setAlignmentX(Component.CENTER_ALIGNMENT);
                                insertplace.setAlignmentX(Component.CENTER_ALIGNMENT);
                                insertpeopleInvolved.setAlignmentX(Component.CENTER_ALIGNMENT);

                                storyeFields.setLayout(new BoxLayout(storyeFields, BoxLayout.Y_AXIS));

                                storyeFields.add(nameField);
                                storyeFields.add(insertname);
                                storyeFields.add(textField);
                                storyeFields.add(inserttext);
                                storyeFields.add(placeField);
                                storyeFields.add(insertplace);
                                storyeFields.add(peopleInvolvedField);
                                storyeFields.add(insertpeopleInvolved);

                                storyeFields.add(addButton);


                                addStoryFrame.getContentPane().add(storyeFields);

                                addStoryFrame.setSize(new Dimension(300,300));
                                addStoryFrame.setLocationRelativeTo(null);
                                addStoryFrame.setVisible(true);
                            }
                        });

                        addQuote.setAlignmentX(Component.CENTER_ALIGNMENT);
                        addStory.setAlignmentX(Component.CENTER_ALIGNMENT);
                        addTask.setAlignmentX(Component.CENTER_ALIGNMENT);
                        addThoughts.setAlignmentX(Component.CENTER_ALIGNMENT);

                        noteAddingOptions.setLayout(new BoxLayout(noteAddingOptions, BoxLayout.Y_AXIS));

                        noteAddingOptions.add(Box.createVerticalStrut(50));
                        noteAddingOptions.add(addQuote);
                        noteAddingOptions.add(Box.createVerticalStrut(10));
                        noteAddingOptions.add(addStory);
                        noteAddingOptions.add(Box.createVerticalStrut(10));
                        noteAddingOptions.add(addTask);
                        noteAddingOptions.add(Box.createVerticalStrut(10));
                        noteAddingOptions.add(addThoughts);

                        noteFrame.getContentPane().add(noteAddingOptions);

                        noteFrame.setSize(new Dimension(300,300));
                        noteFrame.setLocationRelativeTo(null);
                        noteFrame.setVisible(true);

                    }
                });

                updateEventButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent updateAnEvent) {
                        JFrame eventFrame = new JFrame("Updating an event");
                        JPanel eventUpdatingOptions = new JPanel();

                        JButton updateAcademical = new JButton("Update an academical event!");
                        JButton updateAnniversay = new JButton("Update an anniversary!");
                        JButton updateMeeting = new JButton("Update a meeting!");
                        JButton updateOther = new JButton("Update a random event!");

                        updateAcademical.setAlignmentX(Component.CENTER_ALIGNMENT);
                        updateAnniversay.setAlignmentX(Component.CENTER_ALIGNMENT);
                        updateMeeting.setAlignmentX(Component.CENTER_ALIGNMENT);
                        updateOther.setAlignmentX(Component.CENTER_ALIGNMENT);

                        eventUpdatingOptions.setLayout(new BoxLayout(eventUpdatingOptions, BoxLayout.Y_AXIS));

                        eventUpdatingOptions.add(Box.createVerticalStrut(50));
                        eventUpdatingOptions.add(updateAcademical);
                        eventUpdatingOptions.add(Box.createVerticalStrut(10));
                        eventUpdatingOptions.add(updateAnniversay);
                        eventUpdatingOptions.add(Box.createVerticalStrut(10));
                        eventUpdatingOptions.add(updateMeeting);
                        eventUpdatingOptions.add(Box.createVerticalStrut(10));
                        eventUpdatingOptions.add(updateOther);

                        eventFrame.getContentPane().add(eventUpdatingOptions);

                        eventFrame.setSize(new Dimension(300,300));
                        eventFrame.setLocationRelativeTo(null);
                        eventFrame.setVisible(true);

                    }
                });

                updateNoteButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent updateAnEvent) {
                        JFrame noteFrame = new JFrame("Updating a note");
                        JPanel noteUpdatingOptions = new JPanel();

                        JButton updateQuote = new JButton("Update a quote!");
                        JButton updateStory= new JButton("Update a story!");
                        JButton updateTask= new JButton("Update a task!");
                        JButton updateThoughts= new JButton("Update a random thought!");

                        updateQuote.setAlignmentX(Component.CENTER_ALIGNMENT);
                        updateStory.setAlignmentX(Component.CENTER_ALIGNMENT);
                        updateTask.setAlignmentX(Component.CENTER_ALIGNMENT);
                        updateThoughts.setAlignmentX(Component.CENTER_ALIGNMENT);

                        noteUpdatingOptions.setLayout(new BoxLayout(noteUpdatingOptions, BoxLayout.Y_AXIS));

                        noteUpdatingOptions.add(Box.createVerticalStrut(50));
                        noteUpdatingOptions.add(updateQuote);
                        noteUpdatingOptions.add(Box.createVerticalStrut(10));
                        noteUpdatingOptions.add(updateStory);
                        noteUpdatingOptions.add(Box.createVerticalStrut(10));
                        noteUpdatingOptions.add(updateTask);
                        noteUpdatingOptions.add(Box.createVerticalStrut(10));
                        noteUpdatingOptions.add(updateThoughts);

                        noteFrame.getContentPane().add(noteUpdatingOptions);

                        noteFrame.setSize(new Dimension(300,300));
                        noteFrame.setLocationRelativeTo(null);
                        noteFrame.setVisible(true);

                    }
                });
                deleteEventButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent deleteAnEvent) {
                        JFrame eventFrame = new JFrame("Delete an event");
                        JPanel eventDeletingOptions = new JPanel();

                        JButton deleteAcademical = new JButton("Delete an academical event!");
                        JButton deleteAnniversay = new JButton("Delete an anniversary!");
                        JButton deleteMeeting = new JButton("Delete a meeting!");
                        JButton deleteOther = new JButton("Delete a random event!");

                        deleteAcademical.setAlignmentX(Component.CENTER_ALIGNMENT);
                        deleteAnniversay.setAlignmentX(Component.CENTER_ALIGNMENT);
                        deleteMeeting.setAlignmentX(Component.CENTER_ALIGNMENT);
                        deleteOther.setAlignmentX(Component.CENTER_ALIGNMENT);

                        eventDeletingOptions.setLayout(new BoxLayout(eventDeletingOptions, BoxLayout.Y_AXIS));

                        eventDeletingOptions.add(Box.createVerticalStrut(50));
                        eventDeletingOptions.add(deleteAcademical);
                        eventDeletingOptions.add(Box.createVerticalStrut(10));
                        eventDeletingOptions.add(deleteAnniversay);
                        eventDeletingOptions.add(Box.createVerticalStrut(10));
                        eventDeletingOptions.add(deleteMeeting);
                        eventDeletingOptions.add(Box.createVerticalStrut(10));
                        eventDeletingOptions.add(deleteOther);

                        eventFrame.getContentPane().add(eventDeletingOptions);

                        eventFrame.setSize(new Dimension(300,300));
                        eventFrame.setLocationRelativeTo(null);
                        eventFrame.setVisible(true);

                    }
                });

                deleteNoteButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent deleteAnEvent) {
                        JFrame noteFrame = new JFrame("Updating a note");
                        JPanel noteDeletingOptions = new JPanel();

                        JButton deleteQuote = new JButton("Delete a quote!");
                        JButton deleteStory= new JButton("Delete a story!");
                        JButton deleteTask= new JButton("Delete a task!");
                        JButton deleteThoughts= new JButton("Delete a random thought!");

                        deleteQuote.setAlignmentX(Component.CENTER_ALIGNMENT);
                        deleteStory.setAlignmentX(Component.CENTER_ALIGNMENT);
                        deleteTask.setAlignmentX(Component.CENTER_ALIGNMENT);
                        deleteThoughts.setAlignmentX(Component.CENTER_ALIGNMENT);

                        noteDeletingOptions.setLayout(new BoxLayout(noteDeletingOptions, BoxLayout.Y_AXIS));

                        noteDeletingOptions.add(Box.createVerticalStrut(50));
                        noteDeletingOptions.add(deleteQuote);
                        noteDeletingOptions.add(Box.createVerticalStrut(10));
                        noteDeletingOptions.add(deleteStory);
                        noteDeletingOptions.add(Box.createVerticalStrut(10));
                        noteDeletingOptions.add(deleteTask);
                        noteDeletingOptions.add(Box.createVerticalStrut(10));
                        noteDeletingOptions.add(deleteThoughts);

                        noteFrame.getContentPane().add(noteDeletingOptions);

                        noteFrame.setSize(new Dimension(300,300));
                        noteFrame.setLocationRelativeTo(null);
                        noteFrame.setVisible(true);

                    }
                });


                buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));

                buttons.add(addEventButton);
                buttons.add(Box.createVerticalStrut(25));
                buttons.add(addNoteButton);
                buttons.add(Box.createVerticalStrut(25));
                buttons.add(updateEventButton);
                buttons.add(Box.createVerticalStrut(25));
                buttons.add(updateNoteButton);
                buttons.add(Box.createVerticalStrut(25));
                buttons.add(deleteEventButton);
                buttons.add(Box.createVerticalStrut(25));
                buttons.add(deleteNoteButton);
                buttons.add(Box.createVerticalStrut(25));
                buttons.add(readEventButton);
                buttons.add(Box.createVerticalStrut(25));
                buttons.add(readNoteButton);

                menuFrame.getContentPane().add(welcome_label);
                menuFrame.getContentPane().add(buttons);
                menuFrame.setSize(new Dimension(600,700));
                menuFrame.setLocationRelativeTo(null);
                menuFrame.setVisible(true);
                menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
        frame.getContentPane().add(welcomeButton);

        frame.setLocationByPlatform(true);
        frame.setSize(new Dimension(500, 300));
        frame.getContentPane().setBackground(Color.WHITE);

        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(InterfaceSwing::new);
    }


}
