package my.examples.studymanager.service;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.domain.Message;
import my.examples.studymanager.repository.MessageRepository;
import my.examples.studymanager.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;
    private final UserRepository userRepository;

    @Override
    public void addMessage(Long writerId, String content, Long senderId) {
        Message message = new Message();
        message.setUser(userRepository.getOne(writerId));
        message.setUser1(userRepository.getOne(senderId));
        message.setMessageContent(content);
        messageRepository.save(message);
    }

    @Override
    public List<Message> getMessagesByUser(Long userId) {
        return messageRepository.getMessageByUser(userId);
    }

    @Override
    public Message getMessageByMessageId(Long messageId) {

        return messageRepository.getOne(messageId);
    }

    @Override
    public void deleteMessage(Long messageId) {
        messageRepository.deleteById(messageId);
    }
}
