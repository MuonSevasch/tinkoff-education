package tasks.third;

public class Client {
    private Messenger messenger;

    public Client(Messenger messenger) {
        this.messenger = messenger;
    }

    public void sendMessage(String message) {
        messenger.sendMessage(message);
    }

    public String readMessage() {
        return messenger.readMessage();
    }
}
