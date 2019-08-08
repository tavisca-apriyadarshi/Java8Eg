package OptionalEg;

import java.util.HashMap;
import java.util.Optional;

public class SheduleReader {
    public static void main(String[] args) {
        SheduleReader reader = new SheduleReader();
        Optional<String> mayBeShedule = reader.getShedule("Friday");
        mayBeShedule.ifPresent(System.out::println);

        mayBeShedule = reader.getShedule("Sunday");
        mayBeShedule.ifPresent(System.out::println);

        new Thread(() -> new SheduleReader().getShedule("Wednesday").ifPresent(System.out::println)).start();
        new Thread(() -> new SheduleReader().getShedule("Saturday").ifPresent(System.out::println)).start();
        new Thread(() -> new SheduleReader().getShedule("Monday").ifPresent(System.out::println)).start();
    }

    private static HashMap<String, String> shedules = new HashMap<String, String>(){{
        put("Monday", "Heptic");
        put("Tuesday", "Busy");
        put("Wednesday", "Boaring");
        put("Thursday", "Aram");
        put("Friday", "Mozza hi Mozza");
    }};

    public Optional<String> getShedule(String day){
            String value = shedules.get(day);
            if(value != null)
                return Optional.of(value);
            else
                return Optional.empty();
    }
}
