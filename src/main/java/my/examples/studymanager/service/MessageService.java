package my.examples.studymanager.service;

import my.examples.studymanager.domain.Message;

import java.util.List;

public interface MessageService {
    public void addMessage(Long writerId, String content, Long senderId);
    public List<Message> getMessagesByUser(Long userId);
    public Message getMessageByMessageId(Long messageId);
    public void deleteMessage(Long messageId);
}
