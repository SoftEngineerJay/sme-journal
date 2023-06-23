package jay.smejournal;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class SmeJournalApplication {

    @PostConstruct
    public void init(){
        // Setting Spring Boot SetTimeZone
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8:00"));
    }

    public static void main(String[] args) {
        SpringApplication.run(SmeJournalApplication.class, args);
        System.out.println(TimeZone.getDefault().getDisplayName());
    }

}
