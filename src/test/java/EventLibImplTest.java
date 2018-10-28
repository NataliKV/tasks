import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class EventLibImplTest {
    private EventLibImpl eventLibImpl;

    @Before
    public void init() {
        eventLibImpl = new EventLibImpl();
        for (int i=0; i < 10; i++){
            eventLibImpl.setEvent(new Date());
        }
    }

    @Test
    public void getEventsPerMinuteTest(){
        assertEquals(10L, eventLibImpl.getEventsPerMinute());
    }

    @Test
    public void getEventsPerHourTest(){
        assertEquals(10L, eventLibImpl.getEventsPerHour());
    }

    @Test
    public void getEventsPerDayTest(){
        eventLibImpl.setEvent(new Date());
        assertEquals(11L, eventLibImpl.getEventsPerDay());
    }

}
