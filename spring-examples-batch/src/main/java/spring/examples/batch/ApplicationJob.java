package spring.examples.batch;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.UUID;

@Slf4j
@Configuration
@EnableBatchProcessing
class ApplicationJob {

    @Bean
    TaskExecutor taskExecutor() {
        return new SimpleAsyncTaskExecutor("spring-example-batch-");
    }

    @Autowired
    private JobBuilderFactory jobBuilder;

    @Autowired
    private StepBuilderFactory stepBuilder;

    @Autowired
    private JobExplorer jobExplorer;

    @Autowired
    private JobLauncher jobLauncher;

    @PostConstruct
    private void init() throws Exception {
        val step1 = stepBuilder.get("step1")
                .tasklet((contribution, chunkContext) -> {
                    final String s = (String) chunkContext.getStepContext().getJobParameters().get("p");
                    System.out.println("step2 " + s);
                    return RepeatStatus.FINISHED;
                })
                .build();

        val step2 = stepBuilder.get("step2")
                .tasklet((contribution, chunkContext) -> {
                    final String s = (String) chunkContext.getStepContext().getJobParameters().get("p");
                    System.out.println("step2 " + s);
                    return RepeatStatus.FINISHED;
                })
                .build();

        val job = jobBuilder.get("job" + UUID.randomUUID())
                .start(step1)
                .next(step2)
                .build();

        val jobExecution = jobLauncher.run(job,
                new JobParameters(Collections.singletonMap("p", new JobParameter("hello", false)))
        );

        System.out.println(
                jobExecution.getJobInstance().getInstanceId()
        );
    }

}
