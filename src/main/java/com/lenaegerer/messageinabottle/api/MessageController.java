package com.lenaegerer.messageinabottle.api;

import com.lenaegerer.messageinabottle.model.Message;
import com.lenaegerer.messageinabottle.service.MessageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MessageController {
    private final MessageMapper messageMapper;
    private final MessageService messageService;

    public MessageController(MessageMapper messageMapper, MessageService messageService) {
        this.messageMapper = messageMapper;
        this.messageService = messageService;
    }

    @GetMapping("/message-unread")
    public List<MessageDTO> getUnread(@RequestHeader String userId) {
        List<Message> unreadMessages = messageService.getUnread(userId);
        List<MessageDTO> unread = unreadMessages.stream().map(messageMapper::toDto).collect(Collectors.toList());
        return unread;
    }


    @PostMapping("/message")
    public void send(@RequestHeader String userId, @RequestBody MessageDTO body) {
        messageService.send(body.getText(), userId, body.getReceiverId());
    }

    @PutMapping("/markasread")
    public void markAsRead(String messageId) {
        messageService.markAsRead(messageId);
    }
}
