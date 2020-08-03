import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author tian
 * @date 2020/8/3
 */
public class TimeTest {
    public static void main(String[] args) {

//
//        ZonedDateTime zonedDateTime =ZonedDateTime.now();
//        System.out.println(zonedDateTime);
/*        Instant instant=clock.instant();

        Clock clock=Clock.fixed(instant, ZoneId.systemDefault());*/

//        System.out.println(Instant.now());
//        System.out.println(Instant.now(Clock.systemDefaultZone()));

        ZonedDateTime zonedDateTime=ZonedDateTime.of(2020,8,3,10,10,10,0, ZoneId.systemDefault());
        System.out.println(zonedDateTime);
    }

}
