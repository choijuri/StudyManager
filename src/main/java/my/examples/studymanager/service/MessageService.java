package my.examples.studymanager.service;

import my.examples.studymanager.domain.Message;
import my.examples.studymanager.dto.SendMessageDto;

import java.util.List;

public interface MessageService {
    public void addMessage(SendMessageDto sendMessageDto);
    public List<Message> getMessagesByUser(Long userId);
    public Message getMessageByMessageId(Long messageId);
    public void deleteMessage(Long messageId);
}
