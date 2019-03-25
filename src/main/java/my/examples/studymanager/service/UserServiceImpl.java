package my.examples.studymanager.service;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.domain.User;
import my.examples.studymanager.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public void addUser(User user) {

    }

    @Override
    public void modifyUser(User user) {

    }

    @Override
    public User getUserByEmail(String userId) {
        return null;
    }
}
