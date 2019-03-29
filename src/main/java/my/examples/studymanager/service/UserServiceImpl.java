package my.examples.studymanager.service;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.domain.User;
import my.examples.studymanager.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    @Transactional
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void modifyPasswd(String changePasswd, Long userId) {
        User user = userRepository.getOne(userId);
        user.setPasswd(changePasswd);
        userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserByEmail(Long userId) {
        User user = userRepository.getOne(userId);
        return user;
    }
}
