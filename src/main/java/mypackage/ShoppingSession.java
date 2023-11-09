package mypackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class ShoppingSession {

    String displayTimestampMode = "both";

    public ShoppingSession(@Autowired ApplicationArguments arguments) {
        if(arguments.containsOption("displayTimestampMode")){
            displayTimestampMode = arguments.getOptionValues("displayTimestampMode").get(0);
        }
    }

    @Value("#{timestamp.date()}")
    private LocalDate startDate;
    @Value("#{timestamp.time()}")
    private LocalTime startTime;

    public void displayStartDateTime(){
        switch (displayTimestampMode){
            case "date":
                System.out.printf("Session Started on %s",startDate);
                break;
            case "time":
                System.out.printf("Session Started on %s",startTime);
                break;
            case "both":
                System.out.printf("Session Started on %s at %s",startDate,startTime);
                break;
            case "none":
                System.out.printf("Session Started");
                break;
        }

    }


}