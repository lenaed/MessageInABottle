package com.lenaegerer.messageinabottle.services;

import com.lenaegerer.messageinabottle.model.Message;

import java.util.List;

public interface MessageService {

    public void showAll();

    List<Message> getUnread();
    public Message getById(String id);
    void send(String text, String receiverId);
    public void markAsRead(String id);

}
