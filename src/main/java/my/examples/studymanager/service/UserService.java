package my.examples.studymanager.service;

import my.examples.studymanager.domain.User;

public interface UserService {
    public void addUser(User user);
    public void modifyPasswd(String changePasswd, Long userId);
    public User getUserByEmail(Long userId);
}