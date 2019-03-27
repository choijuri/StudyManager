package my.examples.studymanager.service;


import my.examples.studymanager.domain.StudyUser;

import java.util.List;

// 이건 studyService에서 쓰기.
public interface StudyUserService {
    public void addStudyUser(Long userId, Long studyId, String userRole);
    public void deleteStudyUser(Long userId, Long studyId);
    public List<StudyUser> getStudyUsers(Long userId);
}
