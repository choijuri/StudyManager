package my.examples.studymanager.service;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.domain.StudyUser;
import my.examples.studymanager.domain.StudyUserId;
import my.examples.studymanager.repository.StudyRepository;
import my.examples.studymanager.repository.StudyUserRepository;
import my.examples.studymanager.repository.UserRepository;
import my.examples.studymanager.security.StudyManagerSecurityUser;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudyUserServiceImpl implements StudyUserService {
    private final StudyUserRepository studyUserRepository;
    private final StudyRepository studyRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public void addStudyUser(Long studyId, Long userId) {
        StudyUserId studyUserId = new StudyUserId();
        studyUserId.setStudy(studyRepository.getOne(studyId));
        studyUserId.setUser(userRepository.getOne(userId));

        StudyUser studyUser = new StudyUser();
        studyUser.setStudyUserId(studyUserId);
        studyUser.setUserRole("ADMIN");
        studyUserRepository.save(studyUser);
    }


    @Override
    @Transactional
    public void deleteStudyUser(Long userId, Long studyId) {
        studyUserRepository.delete(studyUserRepository.getStudyUserByUserIdStudyId(userId,studyId));
    }

    @Override
    @Transactional(readOnly = true)
    public List<StudyUser> getStudyUsers(Long userId) {
        return studyUserRepository.getStudyUserByUserId(userId);
    }
}
