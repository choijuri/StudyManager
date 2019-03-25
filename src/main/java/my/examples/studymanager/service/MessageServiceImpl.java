package my.examples.studymanager.service;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.domain.Message;
import my.examples.studymanager.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;

    @Override
    public void addMessage(String writerId, Message message, String senderId) {

    }

    @Override
    public List<Message> getMessagesByUser(String userId) {
        return null;
    }

    @Override
    public Message getMessageByMessageId(Long messageId) {
        return null;
    }

    @Override
    public void deleteMessage(Long messageId) {

    }
}
