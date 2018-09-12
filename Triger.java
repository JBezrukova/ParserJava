import org.quartz.*;
import org.quartz.impl.StdScheduler;
import org.quartz.impl.StdSchedulerFactory;

public class Triger {

    public static void main(String[] args) {
        JobDetail jobDetail = JobBuilder.newJob(Parser.class).withIdentity("jobName", "group1").build();
        Trigger triger = TriggerBuilder.newTrigger().withIdentity("triggerName", "group1").withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(20).withRepeatCount(3)).build();
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        try {
            Scheduler scheduler = schedulerFactory.getScheduler();
            scheduler.start();
            scheduler.scheduleJob(jobDetail, triger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }
}

