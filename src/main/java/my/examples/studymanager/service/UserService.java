package my.examples.studymanager.service;

import my.examples.studymanager.domain.User;

public interface UserService {
    public void addUser(User user);
    public void modifyPasswd(User user);
    public User getUserByEmail(String userId);
}