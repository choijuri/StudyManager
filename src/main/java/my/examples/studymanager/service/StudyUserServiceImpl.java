package my.examples.studymanager.service;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.domain.StudyUser;
import my.examples.studymanager.domain.StudyUserId;
import my.examples.studymanager.repository.StudyUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudyUserServiceImpl implements StudyUserService {
    private final StudyUserRepository studyUserRepository;

    @Override
    public void addStudyUser(StudyUser studyUser) {
        studyUserRepository.save(studyUser);
    }

    @Override
    public void deleteStudyUser(Long userId, Long studyId) {
        studyUserRepository.delete(studyUserRepository.getStudyUserByUserIdStudyId(userId,studyId));
    }

    @Override
    public List<StudyUser> getStudyUsers(Long userId) {
        return studyUserRepository.getStudyUserByUserId(userId);
    }
}
