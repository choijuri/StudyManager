package my.examples.studymanager.service;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.domain.StudyUser;
import my.examples.studymanager.repository.StudyUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudyUserServiceImpl implements StudyUserService {
    private final StudyUserRepository studyUserRepository;

    @Override
    public void addStudyUser(String userId, Long studyId, String userRole) {

    }

    @Override
    public void deleteStudyUser(String userId, Long studyId) {

    }

    @Override
    public List<StudyUser> getStudyUsers(String userId) {
        return studyUserRepository.getStudyUserByUserId(userId);
    }
}
