package my.examples.studymanager.service;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.domain.Study;
import my.examples.studymanager.repository.StudyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudyServiceImpl implements StudyService {

    private final StudyRepository studyRepository;


    @Override
    @Transactional(readOnly = true)
    public List<Study> getStudiesByUser(String userId) {
        return studyRepository.getStudiesByUserId(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Study> getStudiesByUserIdAndCategoryId(String userId, Long categoryId) {
        return studyRepository.getStudiesByUserIdAndCategory(userId, categoryId);
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
    public void modifyStudy(Study study) {

    }

    @Override
    @Transactional
    public void addStudy(Study study) {
        studyRepository.save(study);
    }
}
