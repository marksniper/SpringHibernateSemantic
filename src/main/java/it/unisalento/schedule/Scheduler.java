package it.unisalento.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class Scheduler {
    public static final Logger log = LoggerFactory.getLogger(Scheduler.class);

    @Scheduled(cron = "0 0/10 * 1/1 * ?")
    private void scheduleTaskUsingCronExpression() {
        log.info("Example scheduler");
        log.info("Every 10 minute the Cron start");
        log.info("It is possible to schedule a JOB.");
    }
}
