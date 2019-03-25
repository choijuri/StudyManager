package my.examples.studymanager.service;


// 이건 studyService에서 쓰기.
public interface StudyUserService {
    public void addStudyUser(String userId, Long studyId, String userRole);
    public void deleteStudyUser(String userId, Long studyId);
}
