package tasks.third;

import org.junit.Test;
import static org.junit.Assert.*;


public class ClientTest {

    @Test
    public void testSendMessageAndReadMessage() {
        Messenger messenger = new EmailMessenger();
        Client client = new Client(messenger);
        client.sendMessage("Hello from client");
        String message = client.readMessage();

        assertEquals("Hello from EmailMessenger", message);
    }
}