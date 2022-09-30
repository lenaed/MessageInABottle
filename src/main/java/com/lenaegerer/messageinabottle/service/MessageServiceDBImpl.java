package com.lenaegerer.messageinabottle.service;

import com.lenaegerer.messageinabottle.model.Message;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MessageServiceDBImpl implements MessageService {
    private final MessageRepository messageRepository;
    private final UserService userService;

    public MessageServiceDBImpl(MessageRepository messageRepository, UserService userService) {
        this.messageRepository = messageRepository;
        this.userService = userService;
    }

    @Override
    public void showAll() {

    }

    @Override
    public List<Message> getUnread() {
        String receiverId = userService.getCurrentUser().getId();
        List<Message> unread = messageRepository.findAllByReceiverIdAndIsRead(receiverId, false);
        return unread;
    }


    @Override
    public Message getById(String id) {
        Optional<Message> message = messageRepository.findById(id);
        return message.orElseThrow(() -> new RuntimeException("MessageId" + id + "doesn't exist!"));
    }

    @Override
    public void send(String text, String receiverId) {
        Message m = new Message(
                text,
                UUID.randomUUID().toString(),
                userService.getCurrentUser().getId(),
                receiverId,
                false
        );
        messageRepository.save(m);
    }

    @Override
    public void markAsRead(String id) {
        Message message = getById(id);
        message.setRead(true);
        messageRepository.save(message);
    }
}
