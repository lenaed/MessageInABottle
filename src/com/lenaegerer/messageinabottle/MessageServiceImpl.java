package com.lenaegerer.messageinabottle;

import com.lenaegerer.messageinabottle.Message;
import com.lenaegerer.messageinabottle.MessageService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MessageServiceImpl implements MessageService {
List <Message> messages = new ArrayList<>();

    @Override
    public void showAll() {
        for(Message m : messages){
            System.out.println(m);
        }
    }

    @Override
    public List<Message> getUnread(String receiverId) {
        List<Message>unread = new ArrayList();

        for(Message m : messages){
            if(m.getReceiverId().equals(receiverId) && !m.isRead()){
                unread.add(m);
            }
        }
        return unread;
    }

    @Override
    public Message getById(String id) {
        Message which = null;
        for(Message m:messages){
            if(m.getId().equals(id)){
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
        for(Message m:messages){
            if(m.getId().equals(id) && !m.isRead()){
                m.setRead(true);
            }
        }

    }
}
