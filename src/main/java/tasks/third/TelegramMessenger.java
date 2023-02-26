package tasks.third;

/**
 * Реализация методов для отправки и чтения сообщений в Telegram
 */
public class TelegramMessenger implements Messenger {
    @Override
    public void sendMessage(String message) {

    }

    @Override
    public String readMessage() {
        return "Hello from TelegramMessenger";
    }
}