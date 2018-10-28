import java.util.*;
import java.util.stream.Collectors;


public class EventLibImpl implements EventLib {

    private static final long MINUTE = 60000;
    private static final long HOUR = 60 * MINUTE;
    private static final long DAY = 24 *HOUR;

    private final List<Event> events;

    public EventLibImpl() {
        events = new ArrayList<>();
    }

    public void setEvent(Date timeOfEvent) {
        events.add(new Event(timeOfEvent));
    }

    public long getEventsPerMinute() {
        return getCountOfEventsByTime(getCurrTime() - MINUTE);
    }

    public long getEventsPerHour() {
        return getCountOfEventsByTime(getCurrTime() - HOUR);
    }

    public long getEventsPerDay() {
        return getCountOfEventsByTime(getCurrTime() - DAY);
    }

    private long getCurrTime() {
        return Calendar.getInstance().getTimeInMillis();
    }

    private long getCountOfEventsByTime(long time) {
        List<Event> resultEvents;
        synchronized (events) {
            resultEvents = events.stream()
                    .filter(event -> event.getTimeOfEvent().getTime() >= time)
                    .collect(Collectors.toList());
            }
        return resultEvents.size();
    }
}
