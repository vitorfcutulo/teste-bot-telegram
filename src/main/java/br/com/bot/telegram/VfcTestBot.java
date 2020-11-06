package br.com.bot.telegram;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class VfcTestBot extends TelegramLongPollingBot {

	public void onUpdateReceived(Update update) {
		//esse método pode ser utilizado para validar o email digitado pelo cliente no primeiro acesso ao canal
	}

	public String getBotUsername() {
		return "xxxx";
	}

	@Override
	public String getBotToken() {
		return "xxxx";
	}
	
	public void enviaMensagem(String mensagem) {
        SendMessage msg = new SendMessage();
        msg.setText(mensagem);
        msg.setParseMode("html");
        msg.setChatId("xxxx");
       
        try {
            execute(msg);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
