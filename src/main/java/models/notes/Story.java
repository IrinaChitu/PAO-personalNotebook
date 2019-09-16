package models.notes;

import java.util.ArrayList;
import java.util.HashSet;;
import java.util.Set;

public class Story extends Notes {
    private String place;
    private Set<String> peopleInvolved = new HashSet<String>();

    public Story() {}
    public Story(String name, String text, String place) {
        super(name, text);
        this.place = place;
        this.peopleInvolved = peopleInvolved;
    }
    public Story(String name, String text, String place, Set<String> peopleInvolved) {
        super(name, text);
        this.place = place;
        this.peopleInvolved = peopleInvolved;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setPeopleInvolved(Set<String> peopleInvolved) {
        this.peopleInvolved = peopleInvolved;
    }

    public String getPlace() {
        return place;
    }

    public Set<String> getPeopleInvolved() {
        return peopleInvolved;
    }

    @Override
    public void printNote() {
        super.printNote();
        if(place != null) {
            System.out.println("Place: " + place);
        }
        if(peopleInvolved != null) {
            for(String person: peopleInvolved) {
                System.out.print(person + " ");
            }
            System.out.println();
        }
    }
}
