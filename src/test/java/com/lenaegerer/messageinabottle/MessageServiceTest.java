//package com.lenaegerer.messageinabottle;
//
//import com.lenaegerer.messageinabottle.model.Message;
//import com.lenaegerer.messageinabottle.service.MessageService;
//import com.lenaegerer.messageinabottle.service.MessageServiceImpl;
//import com.lenaegerer.messageinabottle.service.UserService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//
//class MessageServiceTest {
//
//    private MessageService messageService;
//    private final static String SENDER_ID = "just_any_sender";
//    private final static String RECEIVER_ID = "just_any_receiver";
//
//    private String currentUserId;
//
//    private class MockUserService extends UserService {
//        @Override
//        public String getCurrentUserId() {
//            return currentUserId;
//        }
//    }
//
//
//    @BeforeEach
//    public void setUp() {
//        messageService = new MessageServiceImpl(new MockUserService());
//    }
//
//    @Test
//    public void getUnread_IfTHereAreNoMessagesForAUser_returnsEmptyList() {
//        currentUserId = SENDER_ID;
//        messageService.send("ciao", "another_user");
//
//        currentUserId = RECEIVER_ID;
//        List<Message> received = messageService.getUnread();
//
//        assert received.size() == 0;
//    }
//
//    @Test
//    public void getUnread_afterHavingSentAMessage_returnsTheMessageThatHasBeenSent() {
//        currentUserId = SENDER_ID;
//        messageService.send("ciao", RECEIVER_ID);
//
//        currentUserId = RECEIVER_ID;
//        List<Message> received = messageService.getUnread();
//
//        assert received.size() == 1;
//        assert received.get(0).getText().equals("ciao");
//        assert received.get(0).isRead() == false;
//    }
//
//    @Test
//    public void markAsRead_ifYouHaveAnUnreadMessage_marksAsRead() {
//        currentUserId = SENDER_ID;
//        messageService.send("moin", RECEIVER_ID);
//
//        currentUserId = RECEIVER_ID;
//        List<Message> unread = messageService.getUnread();
//        Message m1 = unread.get(0);
//        String id = m1.getId();
//        messageService.markAsRead(id);
//        m1 = messageService.getById(id);
//
//        assert m1.isRead();
//        assert messageService.getUnread().isEmpty();
//    }
//
//
//}
//
