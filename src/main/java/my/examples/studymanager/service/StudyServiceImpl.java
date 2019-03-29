package my.examples.studymanager.service;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.domain.Study;
import my.examples.studymanager.domain.StudyUser;
import my.examples.studymanager.dto.StudyDto;
import my.examples.studymanager.repository.StudyRepository;
import my.examples.studymanager.repository.StudyUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudyServiceImpl implements StudyService {

    private final StudyRepository studyRepository;


    @Override
    @Transactional(readOnly = true)
    public List<Study> getStudiesByUser(Long userId) {
        return studyRepository.getStudiesByUser(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Study> getStudiesByUserIdAndCategoryId(Long userId, Long categoryId) {
        return studyRepository.getStudiesByUserIdCategoryId(userId, categoryId);
    }

    @Override
    @Transactional(readOnly = true)
    public Study getStudy(Long studyId) {
        return studyRepository.getOne(studyId);
    }

    @Override
    @Transactional
    public void deleteStudy(Long studyId) {
        studyRepository.deleteById(studyId);
    }

    @Override
    @Transactional
    public void modifyStudy(StudyDto studyDto) {
        Study study = studyRepository.getOne(studyDto.getStudyId());
        study.setStudyName(studyDto.getStudyName());
        study.setStudyInformation(studyDto.getStudyInformation());
        studyRepository.save(study);

    }

    @Override
    @Transactional
    public void addStudy(Study study) {
        studyRepository.save(study);
    }
}
