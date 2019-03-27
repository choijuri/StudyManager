package my.examples.studymanager.service;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.domain.StudyContent;
import my.examples.studymanager.repository.StudyContentRepository;
import my.examples.studymanager.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StudyContentServiceImpl implements StudyContentService {
    private final StudyContentRepository studyContentRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public StudyContent getStudyContentByCurriculumId(Long curriculumdetailId) {
        return studyContentRepository.getStudyContentByCurriculumDetailId(curriculumdetailId);
    }

    @Override
    @Transactional
    public void modifyStudyContent(StudyContent studyContent) {

    }

    @Override
    @Transactional
    public void addStudyContent(StudyContent studyContent, String userId) {
        studyContent.setUser(userRepository.getOne(userId));
        studyContentRepository.save(studyContent);
    }
}
