package br.com.bot.telegram;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

public class MainClass {

	public static void main(String[] args) throws TelegramApiException {
		RegistraBot();
        try {
            SchedulerFactory schedFact = new StdSchedulerFactory();
            Scheduler sched = schedFact.getScheduler();
            sched.start();
            JobDetail job = JobBuilder.newJob(TelegramJob.class).withIdentity("chamaTelegramJob", "group1").build();
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity("triggerTelegramBot", "group1").withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ?")).build();
            //Trigger trigger = TriggerBuilder.newTrigger().withIdentity("triggerTelegramBot", "group1").withSchedule(CronScheduleBuilder.dailyAtHourAndMinute(8, 0)).build();
             sched.scheduleJob(job, trigger);
        } catch (Exception e) {
            System.out.println("erro");
            e.printStackTrace();
        }
	}
	
	public static void RegistraBot() {
		ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        VfcTestBot bot = new VfcTestBot();
		try {
			telegramBotsApi.registerBot(bot);
		} catch (TelegramApiRequestException e) {
			e.printStackTrace();
		}
	}
}
