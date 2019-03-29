package my.examples.studymanager.service;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.domain.Message;
import my.examples.studymanager.repository.MessageRepository;
import my.examples.studymanager.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public void addMessage(Long writerId, String content, Long senderId) {
        Message message = new Message();
        message.setUser(userRepository.getOne(writerId));
        message.setUser1(userRepository.getOne(senderId));
        message.setMessageContent(content);
        messageRepository.save(message);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Message> getMessagesByUser(Long userId) {
        return messageRepository.getMessageByUser(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public Message getMessageByMessageId(Long messageId) {

        return messageRepository.getOne(messageId);
    }

    @Override
    @Transactional
    public void deleteMessage(Long messageId) {
        messageRepository.deleteById(messageId);
    }
}
