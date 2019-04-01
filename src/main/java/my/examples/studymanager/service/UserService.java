package my.examples.studymanager.service;

import my.examples.studymanager.domain.User;

import java.util.List;

public interface UserService {
    public User addUser(User user);
    public void modifyPasswd(String changePasswd, Long userId);
    public User getUserByEmail(Long userId);
    public int emailChk(String email);

}