package my.examples.studymanager.service;

import my.examples.studymanager.domain.Message;

import java.util.List;

public interface MessageService {
    public void addMessage(String writerId, Message message, String senderId);
    public List<Message> getMessagesByUser(String userId);
    public Message getMessageByMessageId(Long messageId);
    public void deleteMessage(Long messageId);
}
