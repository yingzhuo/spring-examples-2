package spring.examples.quartz;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import spring.examples.quartz.task.MyJob;

import java.util.UUID;

@SpringBootApplication
public class ApplicationBoot implements ApplicationRunner {

    @Autowired
    private Scheduler scheduler;

    public static void main(String[] args) {
        SpringApplication.run(ApplicationBoot.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String jobKey = UUID.randomUUID().toString();
        String triggerKey = UUID.randomUUID().toString();

        JobDetail jobDetail = JobBuilder.newJob()
                .ofType(MyJob.class)
                .withIdentity(jobKey, MyJob.class.getName())
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(triggerKey, MyJob.class.getName())
                .startNow()
                .build();

        scheduler.scheduleJob(jobDetail, trigger);
    }

}
