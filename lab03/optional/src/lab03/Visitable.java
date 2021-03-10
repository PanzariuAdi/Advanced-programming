package lab03;

import java.time.Duration;
import java.time.LocalTime;

public interface Visitable {
    LocalTime getOpenTime();
    LocalTime getCloseTime();

//    Create default methods in the interface Visitable, with the opening hour 09:30 and the closing hour 20:00.
    default LocalTime DefaultOpenTime() { return LocalTime.of(9, 30); }
    default LocalTime DefaultCloseTime() { return LocalTime.of(20, 0); }

    //   Create a static method getVisitingDuration,in the interface Visitable, that returns a Duration object, representing how long a location is opened during a day.
    static Duration getVisitingDuration(Duration duration, Visitable l1) {
        return Duration.between(l1.getOpenTime(), l1.getCloseTime());
    }
}
