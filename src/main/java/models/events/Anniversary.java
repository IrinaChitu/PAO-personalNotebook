package models.events;

//import java.text.ParseException;
import java.util.Date;

import static java.util.Objects.requireNonNull;

public class Anniversary extends Event {
    private static int id_DB;
    private String birthdayPerson;
    private String partyPlace;
    private String gift;
    private int id;

    public Anniversary() { super(); }

    public Anniversary(Date date, String birthdayPerson) {
        super(date);
//        this.id = id_DB++;
        this.birthdayPerson = requireNonNull(birthdayPerson);
    }

    public Anniversary(Date date, String description, String birthdayPerson) {
        super(date, description);
//        this.id = id_DB++;
        this.birthdayPerson = requireNonNull(birthdayPerson);
    }

    public Anniversary(Date date, String description, String birthdayPerson, String partyPlace, String gift) {
        super(date, description);
//        this.id = id_DB++;
        this.birthdayPerson = requireNonNull(birthdayPerson);
        this.partyPlace = partyPlace;
        this.gift = gift;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBirthdayPerson(String birthdayPerson) {
        this.birthdayPerson = requireNonNull(birthdayPerson);
    }

    public void setPartyPlace(String partyPlace) {
        this.partyPlace = partyPlace;
    }

    public void setGift(String gift) {
        this.gift = gift;
    }

    public String getBirthdayPerson() {
        return birthdayPerson;
    }

    public String getPartyPlace() {
        return partyPlace;
    }

    public String getGift() {
        return gift;
    }

    public static int getId_DB() {
        return ++Anniversary.id_DB;
    }

    @Override
    public void printEvent() {  //throws ParseException {
        super.printEvent();
        System.out.println("Birthday Person: " + birthdayPerson);
        if(partyPlace != null) {
            System.out.println("Party Place: " + partyPlace);
        }
        if(gift != null) {
            System.out.println("Gift: " + gift);
        }
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", birthdayPerson=" + birthdayPerson +
                ", partyPlace=" + partyPlace +
                ", gift=" + gift ;
    }
}
