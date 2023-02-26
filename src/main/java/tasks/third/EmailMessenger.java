package tasks.third;

public class EmailMessenger implements Messenger {
    @Override
    public void sendMessage(String message) {

    }

    @Override
    public String readMessage() {
        return "Hello from EmailMessenger";
    }
}