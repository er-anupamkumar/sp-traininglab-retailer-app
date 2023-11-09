package mypackage;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Component
public class Timestamp {

    LocalDateTime timestamp = LocalDateTime.now();

    public LocalDate date(){
        return timestamp.toLocalDate();
    }

    public String time(){
        return timestamp.toLocalTime().format(DateTimeFormatter.ofPattern("hh:mm:ss"));
    }
}
