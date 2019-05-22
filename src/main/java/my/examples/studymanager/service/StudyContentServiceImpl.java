package my.examples.studymanager.service;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.domain.StudyContent;
import my.examples.studymanager.dto.StudyContentDto;
import my.examples.studymanager.repository.CurriculumDetailRepository;
import my.examples.studymanager.repository.StudyContentRepository;
import my.examples.studymanager.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StudyContentServiceImpl implements StudyContentService {
    private final StudyContentRepository studyContentRepository;
    private final UserRepository userRepository;
    private final CurriculumDetailRepository curriculumDetailRepository;

    @Override
    @Transactional(readOnly = true)
    public StudyContent getStudyContentByCurriculumDetailId(Long curriculumDetailId) {
        return studyContentRepository.getStudyContentByCurriculumDetailId(curriculumDetailId);
    }

    @Override
    @Transactional
    public void modifyStudyContent(StudyContent studyContent) {
        StudyContent updateStudyContent = studyContentRepository.getOne(studyContent.getStudyContentId());
        updateStudyContent.setContent(studyContent.getContent());
        studyContentRepository.save(updateStudyContent);
    }

    @Override
    @Transactional
    public Long addStudyContent(StudyContentDto studyContentDto, Long userId) {
        StudyContent studyContent = new StudyContent();
        studyContent.setContent(studyContentDto.getContent());
        studyContent.setCurriculumDetail(curriculumDetailRepository.getOne(studyContentDto.getCurriculumDetailId()));
        studyContent.setUser(userRepository.getOne(userId));
        studyContentRepository.save(studyContent);
        return studyContent.getStudyContentId();
    }
}
