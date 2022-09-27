import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


class MessageServiceTest {

    private MessageService messageService;
    private final static String SENDER_ID = "just_any_sender";
    private final static String RECEIVER_ID = "just_any_receiver";

    @BeforeEach
    public void setUp() {
        messageService = new MessageServiceImpl();
    }

    @Test
    public void getUnread_IfTHereAreNoMessagesForAUser_returnsEmptyList() {
        messageService.send("ciao", SENDER_ID, RECEIVER_ID);

        List<Message> received = messageService.getUnread(RECEIVER_ID);

        assert received.size() == 0;
    }

    @Test
    public void getUnread_afterHavingSentAMessage_returnsTheMessageThatHasBeenSent() {
        messageService.send("ciao", SENDER_ID, RECEIVER_ID);

        List<Message> received = messageService.getUnread(RECEIVER_ID);

        assert received.size() == 1;
        assert received.get(0).getText().equals("ciao");
        assert received.get(0).isRead() == false;
    }

    @Test
    public void markAsRead_ifYouHaveAnUnreadMessage_marksAsRead() {
        messageService.send("moin", SENDER_ID, RECEIVER_ID);

        List<Message> unread = messageService.getUnread(RECEIVER_ID);
        Message m1 = unread.get(0);
        String id = m1.getId();
        messageService.markAsRead(id);
        m1 = messageService.getById(id);

        assert m1.isRead();
        assert messageService.getUnread(RECEIVER_ID).isEmpty();
    }


}