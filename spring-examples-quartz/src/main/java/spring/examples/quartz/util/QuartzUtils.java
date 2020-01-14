package spring.examples.quartz.util;

import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

import java.text.ParseException;
import java.util.Date;

public final class QuartzUtils {

    public static JobDetail createJob(Class<? extends QuartzJobBean> jobClass, boolean isDurable, ApplicationContext context, String jobName, String jobGroup) {
        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
        factoryBean.setJobClass(jobClass);
        factoryBean.setDurability(isDurable);
        factoryBean.setName(jobName);
        factoryBean.setGroup(jobGroup);
        factoryBean.setApplicationContext(context);
//        factoryBean.setJobDataAsMap(); TODO
        factoryBean.afterPropertiesSet();

        return factoryBean.getObject();
    }

    public static Trigger createSimpleTrigger(String triggerName, Date startTime, int repeatCount, long repeatInterval, int misfireInstruction) {
        SimpleTriggerFactoryBean factoryBean = new SimpleTriggerFactoryBean();
        factoryBean.setName(triggerName);
        factoryBean.setStartTime(startTime);
        factoryBean.setRepeatCount(repeatCount);
        factoryBean.setRepeatInterval(repeatInterval);
        factoryBean.setMisfireInstruction(misfireInstruction);
        factoryBean.afterPropertiesSet();
        return factoryBean.getObject();
    }

    public static Trigger createCronTrigger(String triggerName, Date startTime, String cronExp, int misfireInstruction) {
        CronTriggerFactoryBean factoryBean = new CronTriggerFactoryBean();
        factoryBean.setName(triggerName);
        factoryBean.setStartTime(startTime);
        factoryBean.setCronExpression(cronExp);
        factoryBean.setMisfireInstruction(misfireInstruction);
        try {
            factoryBean.afterPropertiesSet();
        } catch (ParseException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
        return factoryBean.getObject();
    }

    private QuartzUtils() {
    }
}
