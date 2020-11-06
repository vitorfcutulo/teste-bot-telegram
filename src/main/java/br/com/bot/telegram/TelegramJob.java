package br.com.bot.telegram;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class TelegramJob implements Job {

	public void execute(JobExecutionContext context) throws JobExecutionException {
	     VfcTestBot bot = new VfcTestBot();
	     bot.enviaMensagem("Essa mensagem veio do JAVA para o canal");
	}
}
