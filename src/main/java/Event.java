import java.io.Serializable;
import java.util.Date;

public class Event implements Serializable {
    private static volatile int globalID = 0;

    private long id;
    private Date timeOfEvent;

    public Event(Date timeOfEvent) {
        synchronized (this) {
            globalID++;
            this.id = globalID;
            this.timeOfEvent = timeOfEvent;
        }
    }

    public Date getTimeOfEvent() {
        return timeOfEvent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (id != event.id) return false;
        return timeOfEvent != null ? timeOfEvent.equals(event.timeOfEvent) : event.timeOfEvent == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (timeOfEvent != null ? timeOfEvent.hashCode() : 0);
        return result;
    }
}
