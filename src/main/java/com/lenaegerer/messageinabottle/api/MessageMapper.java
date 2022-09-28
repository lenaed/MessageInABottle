package com.lenaegerer.messageinabottle.api;

import com.lenaegerer.messageinabottle.model.Message;
import org.springframework.stereotype.Service;

@Service
public class MessageMapper {

    public MessageDTO toDto(Message message){
        MessageDTO dto = new MessageDTO();
        dto.setText(message.getText());
        dto.setId(message.getId());
        dto.setSenderId(message.getSenderId());
        dto.setReceiverId(message.getReceiverId());
        dto.setRead(message.isRead());
        return dto;
    }
}
