import java.util.Date;

public interface EventLib {

    /**
    * Учесть событие.
    * @param timeOfEvent время события
    */
    void setEvent(Date timeOfEvent);

    /**
     * Получить число событий за последнюю минуту (60 секунд)
     * @return число событий
     */
    long getEventsPerMinute();

    /**
     * Получить число событий за последний час (60 минут)
     * @return число событий
     */
    long getEventsPerHour();

    /**
     * Получить число событий за последние сутки (24 часа)
     * @return число событий
     */
    long getEventsPerDay();
}
