package spring.examples.logstash.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class ScheduledTasks {

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static final Logger LOGGER_A = LoggerFactory.getLogger("A");
    private static final Logger LOGGER_B = LoggerFactory.getLogger("B");

    @Scheduled(fixedRate = 3000)
    public void scheduleTaskWithFixedRate() {
        LOGGER_A.info("Fixed Rate Task :: Execution Time - {}", DATE_FORMAT.format(LocalDateTime.now()));
        LOGGER_B.info("Fixed Rate Task :: Execution Time - {}", DATE_FORMAT.format(LocalDateTime.now()));
    }

}
