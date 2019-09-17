package services;

import models.events.Academical;
import models.events.Anniversary;
import models.events.Event;
import models.events.Meeting;

import java.util.Arrays;
import java.util.List;

public class EventServiceDB {

    private static EventServiceDB eventInstance = new EventServiceDB();

    public static EventServiceDB getInstance() {
        return eventInstance;
    }

    private EventServiceDB() {}

    public void addAnniversary(Anniversary anniversary) {
        anniversary.setId((int)(Math.random() * ((200 - 1) + 1)) + 1);
        WriteDatabase.DatabaseWriter(Arrays.asList(anniversary));
    }

    public List<Anniversary> readAnniversary(String type, String birthdayPerson) {
        return ReadDatabase.DatabaseReader(type, birthdayPerson);
    }

    public void updateAnniversary(Anniversary anniversary) {
        UpdateDatabase.DatabaseUpdater(anniversary);
    }

    public void deleteAnniversary( int id) {
        DeleteDatabase.DatabaseDeleter("Anniversary", id);
    }

    public void addAcademical(Academical academical) {
        academical.setId((int)(Math.random() * ((200 - 1) + 1)) + 1);
        WriteDatabase.DatabaseWriter(Arrays.asList(academical));
    }

    public void addMeeting(Meeting meeting) {
        meeting.setId((int)(Math.random() * ((200 - 1) + 1)) + 1);
        WriteDatabase.DatabaseWriter(Arrays.asList(meeting));
    }

    public void updateMeeting(Meeting meeting) {
        UpdateDatabase.DatabaseUpdater(meeting);
    }

    public void deleteMeeting(int id) {
        DeleteDatabase.DatabaseDeleter("Meeting", id);
    }
}
