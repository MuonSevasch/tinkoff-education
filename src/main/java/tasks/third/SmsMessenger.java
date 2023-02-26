package tasks.third;

/**
 * Реализация методов для отправки и чтения сообщений по SMS
 */
public class SmsMessenger implements Messenger {
    @Override
    public void sendMessage(String message) {

    }

    @Override
    public String readMessage() {
        return "Hello from SmsMessenger";
    }
}
