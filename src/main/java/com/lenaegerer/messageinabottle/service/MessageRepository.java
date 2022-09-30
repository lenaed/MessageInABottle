package com.lenaegerer.messageinabottle.service;

import com.lenaegerer.messageinabottle.model.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, String> {
    List<Message>findAllByReceiverIdAndIsRead(String receiverId, boolean isRead);

}
