package my.examples.studymanager.service.impl;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.domain.User;
import my.examples.studymanager.repository.UserRepository;
import my.examples.studymanager.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    @Transactional
    public User addUser(User user) {
       return userRepository.save(user);
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
    public User getUserById(Long userId) {
        User user = userRepository.getOne(userId);
        return user;
    }

    @Override
    @Transactional(readOnly = true)
    public int emailChk(String email){
        int result = userRepository.emailChk(email);
        return result;
    }

    @Override
    public Long getUserIdByEmail(String email) {
        return userRepository.getUserIdByEmail(email);
    }
}
