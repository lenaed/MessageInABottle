package com.lenaegerer.messageinabottle.api;

import com.lenaegerer.messageinabottle.model.Message;
import com.lenaegerer.messageinabottle.services.MessageService;
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
    public List<MessageDTO> getUnread() {
        List<Message> unreadMessages = messageService.getUnread();
        List<MessageDTO> unread = unreadMessages.stream().map(messageMapper::toDto).collect(Collectors.toList());
        return unread;
    }


    @PostMapping("/message")
    public void send(@RequestBody MessageDTO body) {
        messageService.send(body.getText(), body.getReceiverId());
    }

    @PutMapping("/markasread")
    public void markAsRead(
            @RequestParam String messageId,
            @RequestParam String receiver,
            @RequestHeader("sender-id") String senderId
    ) {
        ///
    }

    @PutMapping("/message/{id}/receiver")
    public void getReceiver(@PathVariable("id") String messageId) {
        ///
    }
}
