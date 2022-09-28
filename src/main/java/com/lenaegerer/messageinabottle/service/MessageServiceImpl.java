package com.lenaegerer.messageinabottle.service;

import com.lenaegerer.messageinabottle.model.Message;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MessageServiceImpl implements MessageService {

   List<Message> messages = new ArrayList<>();

    public MessageServiceImpl() {
        addMessagesForTesting();
    }

    public void addMessagesForTesting() {
        Message m1 = new Message("Hallo", "4", "5", "3", false);
        Message m2 = new Message("Halloooooo", "43", "5", "5", false);
        Message m3 = new Message("Hallaaaaaaaa", "45", "3", "5", false);
        messages.add(m1);
        messages.add(m2);
        messages.add(m3);
    }

    @Override
    public void showAll() {
        for (Message m : messages) {
            System.out.println(m);
        }
    }


    @Override
    public List<Message> getUnread(String receiverId) {
        List<Message> unread = new ArrayList();

        for (Message m : messages) {
            if (m.getReceiverId().equals(receiverId) && !m.isRead()) {
                unread.add(m);
            }
        }
        return unread;
    }

    @Override
    public Message getById(String id) {
        Message which = null;
        for (Message m : messages) {
            if (m.getId().equals(id)) {
                which = m;
            }
        }
        return which;
    }

    int count;

    @Override
    public void send(String text, String senderId, String receiverId) {
        Message m = new Message(text, UUID.randomUUID().toString(), senderId, receiverId, false);
        messages.add(m);
        count++;
    }

    @Override
    public void markAsRead(String id) {
        for (Message m : messages) {
            if (m.getId().equals(id) && !m.isRead()) {
                m.setRead(true);
            }
        }

    }
}
